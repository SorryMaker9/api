package tech.cqxqg.youcai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.swak.frame.dto.PageInfo;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tech.cqxqg.youcai.persistence.entity.UserCss;
import tech.cqxqg.youcai.persistence.service.MpUserCssService;
import tech.cqxqg.youcai.user.converter.UserCssConverter;
import tech.cqxqg.youcai.user.dto.UserCssVo;
import tech.cqxqg.youcai.user.dto.request.UserCssPageReq;
import tech.cqxqg.youcai.user.service.UserCssService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserCssServiceImpl implements UserCssService {

    @Resource
    private MpUserCssService mpUserCssService;

    @Resource
    private UserCssConverter userCssConverter;


    @Override
    public Result<Pagination<UserCssVo>> queryUserCssList(UserCssPageReq query) {

        QueryWrapper<UserCss> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(query.getUserId() != null, UserCss::getUserId, query.getUserId())
                .eq(query.getType() != null, UserCss::getType, query.getType())
                .like(StringUtils.isNotEmpty(query.getName()), UserCss::getName, query.getName())
                .eq(StringUtils.isNotEmpty(query.getCode()), UserCss::getCode, query.getCode());


        /*queryWrapper.eq(UserCss::getUserId, query.getUserId()).or().eq(UserCss::getType, query.getType()).or().like(UserCss::getName, query.getName()).or().eq(UserCss::getCode, query.getCode());*/

        //IPage<UserCss> page = mpUserCssService.getBaseMapper().selectPage(new Page<>(query.getCurrentPage(), query.getPageSize()), queryWrapper);
        Page<UserCss> page = mpUserCssService.page(new Page<>(query.getCurrentPage(), query.getPageSize()), queryWrapper);
        List<UserCssVo> userCssVos = page.getRecords().stream().map(userCssConverter::entityToVo).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(userCssVos)) {
            return Result.success(Pagination.builder(Collections.emptyList(), PageInfo.page(query, 0L)));
        }
        return Result.success(Pagination.builder(userCssVos, PageInfo.page(query, page.getTotal())));
    }
}
