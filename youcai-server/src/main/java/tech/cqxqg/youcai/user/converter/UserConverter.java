package com.demo.user.converter;

import com.demo.persistence.entity.SysUser;
import com.demo.user.dto.UserVo;
import com.demo.user.dto.request.UserCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserVo entityToVo(SysUser user);

    SysUser toEntity(UserCommand command);
}

