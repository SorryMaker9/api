package tech.cqxqg.youcai.user.converter;

import tech.cqxqg.youcai.persistence.entity.SysUser;
import tech.cqxqg.youcai.user.dto.UserVo;
import tech.cqxqg.youcai.user.dto.request.UserCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserVo entityToVo(SysUser user);

    SysUser toEntity(UserCommand command);
}

