package tech.cqxqg.youcai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swak.frame.dto.PageInfo;
import com.swak.frame.dto.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.core.filter.RequestContext;
import tech.cqxqg.youcai.persistence.entity.SecuritiesFirms;
import tech.cqxqg.youcai.persistence.service.MpSecuritiesService;
import tech.cqxqg.youcai.persistence.service.MpUserSecuritiesFirmsService;
import tech.cqxqg.youcai.user.common.ExistTypeEnum;
import tech.cqxqg.youcai.user.constants.StockConstants;
import tech.cqxqg.youcai.user.constants.StockResultCode;
import tech.cqxqg.youcai.user.dto.dto.SecuritiesFirmDTO;
import tech.cqxqg.youcai.user.dto.request.SecuritiesFirmCommand;
import tech.cqxqg.youcai.user.dto.vo.SecuritiesFirmsVo;
import tech.cqxqg.youcai.user.exception.StockException;
import tech.cqxqg.youcai.user.service.SecuritiesFirmService;
import tech.cqxqg.youcai.user.util.ConvertUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SecuritiesFirmServiceImpl implements SecuritiesFirmService {

    @Resource
    private MpSecuritiesService mpSecuritiesService;

    @Resource
    private MpUserSecuritiesFirmsService mpUserSecuritiesFirmsService;

    @Override
    public Pagination<SecuritiesFirmsVo> getPage(String name, Integer page, Integer pageSize) {

        if (pageSize > StockConstants.MAX_PAGE_SIZE) {
            //限制分页条数，最大20条
            pageSize = StockConstants.MAX_PAGE_SIZE;
        }

        Page<SecuritiesFirms> firmPage = new Page(page, pageSize);

        LambdaQueryWrapper<SecuritiesFirms> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.likeRight(StringUtils.isNotBlank(name), SecuritiesFirms :: getName, name);

        Page<SecuritiesFirms> pages = mpSecuritiesService.page(firmPage, queryWrapper);

        Pagination<SecuritiesFirmsVo> voPagination = new Pagination();

        PageInfo pageInfo = PageInfo.newPageInfo(page, pageSize);

        List<SecuritiesFirms> records = pages.getRecords();

        if (records.isEmpty()) {
            //查询结果为空直接返回
            voPagination.setPage(pageInfo);

            return voPagination;
        }

        List<SecuritiesFirmsVo> securitiesFirmsVos = new ArrayList(records.size());

        for (SecuritiesFirms record : records) {

            SecuritiesFirmsVo securitiesFirmsVo = new SecuritiesFirmsVo();

            BeanUtils.copyProperties(record, securitiesFirmsVo);
            //转换金额相关字段
            ConvertUtil.convertProperties(record, securitiesFirmsVo);

            securitiesFirmsVos.add(securitiesFirmsVo);
        }

        voPagination.setList(securitiesFirmsVos);

        Integer count = mpSecuritiesService.count(queryWrapper);

        pageInfo.setTotalSize(count.longValue());

        voPagination.setPage(pageInfo);

        return voPagination;
    }

    @Override
    public void saveSecuritiesFirm(SecuritiesFirmDTO securitiesFirmDTO) {

        String userId = RequestContext.getUserId();

        if (StringUtils.isBlank(userId)) {
            //用户未登录
            throw new StockException(StockResultCode.USER_NOT_LOGIN);
        }

        boolean isExistSecuritiesFirm = this.isExistByName(securitiesFirmDTO.getName());

        if (isExistSecuritiesFirm) {
            //公司已存在
            throw new StockException(StockResultCode.FIRM_EXIST);
        }

        SecuritiesFirms securitiesFirm = new SecuritiesFirms();

        BeanUtils.copyProperties(securitiesFirmDTO, securitiesFirm);

        ConvertUtil.convertProperties(securitiesFirmDTO, securitiesFirm);

        mpSecuritiesService.save(securitiesFirm);
    }

    @Override
    public void updateSecuritiesFirm(SecuritiesFirmCommand securitiesFirmCommand) {

        LambdaQueryWrapper<SecuritiesFirms> wrapper = new LambdaQueryWrapper();

        wrapper.eq(SecuritiesFirms::getId, securitiesFirmCommand.getId());

        int count = mpSecuritiesService.count(wrapper);

        if (ExistTypeEnum.NO_EXIST.ordinal() == count) {
            //公司不存在
            throw new StockException(StockResultCode.FIRM_NOT_EXIST);
        }

        SecuritiesFirms securitiesFirm = new SecuritiesFirms();

        BeanUtils.copyProperties(securitiesFirmCommand, securitiesFirm);

        ConvertUtil.convertProperties(securitiesFirmCommand, securitiesFirm);

        mpSecuritiesService.updateById(securitiesFirm);
    }

    @Override
    public void deleteSecuritiesFirm(Long id) {

        mpSecuritiesService.removeById(id);
    }


    /**
     * 根据公司名称查询公司是否存在
     * @param name 公司名称
     * @return true:存在  false:不存在
     */
    private boolean isExistByName(String name) {

        if (StringUtils.isBlank(name)) {
            return false;
        }
        LambdaQueryWrapper<SecuritiesFirms> wrapper = new LambdaQueryWrapper();

        wrapper.eq(SecuritiesFirms::getName, name);

        int count = mpSecuritiesService.count(wrapper);

        return ExistTypeEnum.NO_EXIST.ordinal() != count;
    }
}
