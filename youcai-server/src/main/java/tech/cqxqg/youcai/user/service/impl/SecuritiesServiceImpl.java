package tech.cqxqg.youcai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.swak.frame.dto.PageInfo;
import com.swak.frame.exception.Assert;
import org.apache.commons.collections4.CollectionUtils;

import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.core.enums.ResultCode;
import tech.cqxqg.youcai.persistence.entity.ChinaSecurities;
import tech.cqxqg.youcai.persistence.service.MpSecuritiesService;
import tech.cqxqg.youcai.user.constants.SecuritiesResultCode;
import tech.cqxqg.youcai.user.converter.SecuritiesConverter;
import tech.cqxqg.youcai.user.dto.SecuritiesVo;
import tech.cqxqg.youcai.user.dto.request.SecuritiesCommand;
import tech.cqxqg.youcai.user.dto.request.SecuritiesPageReq;
import tech.cqxqg.youcai.user.service.SecuritiesService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SecuritiesServiceImpl implements SecuritiesService {
    @Resource
    private MpSecuritiesService mpSecuritiesService;
    @Resource
    private SecuritiesConverter securitiesConverter;

    @Override
    public Result<Void> addSecurities(SecuritiesCommand command) {
        SecuritiesVo securitiesVo = selectSecuritiesByCode(command.getCode());
        if (Objects.nonNull(securitiesVo)) {
            return Result.fail(SecuritiesResultCode.SECURITIES_EXIST.getCode(), "证券已存在");
        }
        ChinaSecurities chinaSecurities = securitiesConverter.toEntity(command);

        return mpSecuritiesService.save(chinaSecurities) ? Result.success() : Result.fail(ResultCode.UPDATE_ERROR);
    }

    @Override
    public Result<Pagination<SecuritiesVo>> querySecuritiesList(SecuritiesPageReq query) {
        QueryWrapper<ChinaSecurities> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(StringUtils.isNotEmpty(query.getName()), ChinaSecurities::getName, query.getName());
        Page<ChinaSecurities> page = mpSecuritiesService.page(new Page<>(query.getCurrentPage(), query.getPageSize()), queryWrapper);
        List<SecuritiesVo> securitiesVos = page.getRecords().stream().map(securitiesConverter::entityToVo).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(securitiesVos)) {
            return Result.success(Pagination.builder(Collections.emptyList(), PageInfo.page(query, 0L)));
        }
        return Result.success(Pagination.builder(securitiesVos, PageInfo.page(query, page.getTotal())));
    }


    @Override
    public SecuritiesVo selectSecuritiesByCode(String code) {
        SecuritiesVo securitiesVo = securitiesConverter.entityToVo(mpSecuritiesService.lambdaQuery().eq(ChinaSecurities::getCode, code).one());
        return securitiesVo;
    }

    @Override
    public Result<Void> updateSecurities(SecuritiesCommand command) {
        Assert.notNull(command.getCode(),"证券代码信息不能为空");

        ChinaSecurities chinaSecurities = securitiesConverter.toEntity(command);
        chinaSecurities.setCode(command.getCode());
        return mpSecuritiesService.updateById(chinaSecurities) ? Result.success() : Result.fail(ResultCode.UPDATE_ERROR);
    }

    @Override
    public Result<Void> deleteSecurities(SecuritiesCommand command) {
        return null;
    }

    @Override
    public Result<Void> sellSecurities(String code, Integer number) {

        //v1.0无法获取用户登录信息，固定用户

        SecuritiesVo securitiesVo = selectSecuritiesByCode(code);
        if(securitiesVo == null){
            return Result.fail(1401,"没有查询到此证券");
        }
        SecuritiesCommand command = new SecuritiesCommand();
        BeanUtils.copyProperties(securitiesVo,command);
        ChinaSecurities chinaSecurities = securitiesConverter.toEntity(command);
        if(chinaSecurities.getStockAmount() - number < 0){
            return Result.fail(1401,"股本数量不够了");
        }
        chinaSecurities.setStockAmount(chinaSecurities.getStockAmount() - number);

        return mpSecuritiesService.updateById(chinaSecurities) ? Result.success() : Result.fail(ResultCode.UPDATE_ERROR);
    }
}
