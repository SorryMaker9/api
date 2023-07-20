package tech.cqxqg.youcai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.swak.frame.dto.PageInfo;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tech.cqxqg.youcai.core.enums.ResultCode;
import tech.cqxqg.youcai.persistence.entity.UserCsBuys;
import tech.cqxqg.youcai.persistence.service.MpUserCsBuysService;
import tech.cqxqg.youcai.user.converter.UserCsBuysConverter;
import tech.cqxqg.youcai.user.dto.UserCsBuysVo;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysCommand;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysPageReq;
import tech.cqxqg.youcai.user.service.UserCsBuysService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCsBuysServiceImpl implements UserCsBuysService {
    @Resource
    private MpUserCsBuysService mpUserCsBuysService;

    @Resource
    private UserCsBuysConverter userCsBuysConverter;

    @Override
    public Result<Pagination<UserCsBuysVo>> queryUserList(UserCsBuysPageReq query) {
        //第一版暂时只固定用户
        Integer userId = 123456;
        Integer userCsfId = 1234567;
        QueryWrapper<UserCsBuys> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(query.getUserId() != null, UserCsBuys::getUserId, query.getUserId())
                .eq(query.getUserCsfId() != null, UserCsBuys::getUserCsId, query.getUserCsfId())
                .eq(StringUtils.isNotEmpty(query.getCode()), UserCsBuys::getCode, query.getCode());
        Page<UserCsBuys> page = mpUserCsBuysService.page(new Page<>(query.getCurrentPage(), query.getPageSize()), queryWrapper);
        List<UserCsBuysVo> userCsBuysVos = page.getRecords().stream().map(userCsBuysConverter::entityToVo).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(userCsBuysVos)) {
            return Result.success(Pagination.builder(Collections.emptyList(), PageInfo.page(query, 0L)));
        }
        return Result.success(Pagination.builder(userCsBuysVos, PageInfo.page(query, page.getTotal())));
    }

    @Override
    public Result<Void> addUserCsBuys(UserCsBuysCommand userCsBuysCommand) {
        UserCsBuys userCsBuys = userCsBuysConverter.toEntity(userCsBuysCommand);
        userCsBuys.setCreatedAt(new Date());

        return mpUserCsBuysService.save(userCsBuys) ? Result.success() : Result.fail(ResultCode.UPDATE_ERROR);
    }
}
