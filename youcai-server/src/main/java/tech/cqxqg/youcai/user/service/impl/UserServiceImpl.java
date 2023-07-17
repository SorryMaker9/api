package tech.cqxqg.youcai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tech.cqxqg.youcai.user.constants.UserResultCode;
import tech.cqxqg.youcai.user.converter.UserConverter;
import tech.cqxqg.youcai.core.enums.ResultCode;
import tech.cqxqg.youcai.core.filter.RequestContext;
import tech.cqxqg.youcai.persistence.entity.SysUser;
import tech.cqxqg.youcai.persistence.service.MpUserService;
import tech.cqxqg.youcai.user.dto.UserVo;
import tech.cqxqg.youcai.user.dto.request.UserCommand;
import tech.cqxqg.youcai.user.dto.request.UserPageReq;

import tech.cqxqg.youcai.user.service.UserService;
import com.swak.frame.dto.PageInfo;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import com.swak.frame.enums.Married;
import com.swak.frame.enums.Status;
import com.swak.frame.exception.Assert;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {


    @Resource
    private MpUserService mpUserService;

    @Resource
    private UserConverter userConverter;


    @Override
    public UserVo selectUserByLoginName(String userName) {
       return mpUserService.lambdaQuery().eq(SysUser::getLoginName, userName)
                .eq(SysUser::getDelFlag, Married.NO.getValue())
                .list().stream().findFirst()
                .map(userConverter::entityToVo).orElse(null);
    }

    @Override
    public UserVo selectUserByPhoneNumber(String phone) {
        return mpUserService.lambdaQuery().eq(SysUser::getPhone, phone)
                .eq(SysUser::getDelFlag, Married.NO.getValue())
                .list().stream().findFirst()
                .map(userConverter::entityToVo).orElse(null);
    }

    @Override
    public Result<Void> addUser(UserCommand command) {
        //判断用户是否存在
        UserVo oldSysUser = selectUserByLoginName(command.getLoginName());
        if(Objects.nonNull(oldSysUser)){
            //不为空，需要判断是否已经存在
            return Result.fail(UserResultCode.USER_EXIST.getCode(),"登录账号已存在");
        }

        if(StringUtils.isNotEmpty(command.getPhone())) {
            oldSysUser = selectUserByPhoneNumber(command.getPhone());
            if(Objects.nonNull(oldSysUser)){
                //不为空，需要判断是否已经存在
                return Result.fail(UserResultCode.USER_EXIST.getCode(),"手机号码已存在");
            }
        }

        if(StringUtils.isNotEmpty(command.getEmail())) {
            if (mpUserService.lambdaQuery()
                    .eq(SysUser::getEmail, command.getEmail())
                    .list().stream().findFirst().isPresent()) {
                //不为空，需要判断是否已经存在
                return Result.fail(UserResultCode.USER_EXIST.getCode(), "邮箱账号已存在");
            }
        }
        SysUser newUser = userConverter.toEntity(command);
        newUser.setCreateTime(new Date());
        newUser.setCreatorId(RequestContext.getUserId());
        boolean saved = mpUserService.save(newUser);
        return saved?Result.success():Result.fail(ResultCode.UPDATE_ERROR);
    }

    @Override
    public Result<Void> updateUser(UserCommand command) {
        Assert.notNull(command.getUserId(),"用户ID不能为空");
        SysUser user = userConverter.toEntity(command);
        user.setModifierId(RequestContext.getUserId());
        user.setModifyTime(new Date());
        user.setId(command.getUserId());
        boolean updated = mpUserService.updateById(user);
        return updated?Result.success():Result.fail(ResultCode.UPDATE_ERROR);
    }

    @Override
    public Result<Pagination<UserVo>> queryUserList(UserPageReq query) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(StringUtils.isNotEmpty(query.getLoginName()),SysUser::getLoginName,query.getLoginName())
                .eq(StringUtils.isNotEmpty(query.getPhone()),SysUser::getPhone,query.getPhone())
                .like(StringUtils.isNotEmpty(query.getEmail()),SysUser::getEmail,query.getEmail())
                .eq(StringUtils.isNotEmpty(query.getStatus()),SysUser::getStatus,query.getStatus());
        IPage<SysUser> page = mpUserService.page(new Page<>(query.getCurrentPage(), query.getPageSize()), queryWrapper);

        List<UserVo> userVos = page.getRecords().stream().map(userConverter::entityToVo).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(userVos)) {
            return Result.success(Pagination.builder(Collections.emptyList(), PageInfo.page(query, 0L)));
        }
        return Result.success(Pagination.builder(userVos, PageInfo.page(query, page.getTotal())));
    }

    @Override
    public Result<Void> delete(List<Long> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda().set(SysUser::getDelFlag, Status.INVALID.getValue())
                    .in(SysUser::getId, ids);
            if (CollectionUtils.isNotEmpty(ids)) {
                boolean deleted = mpUserService.update(updateWrapper);
                return deleted ? Result.success() : Result.fail(ResultCode.DELETE_ERROR);
            }
        }
        return Result.success();
    }
}
