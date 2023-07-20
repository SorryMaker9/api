package tech.cqxqg.youcai.user.converter;


import org.mapstruct.Mapper;
import tech.cqxqg.youcai.persistence.entity.UserCss;
import tech.cqxqg.youcai.user.dto.UserCssVo;
import tech.cqxqg.youcai.user.dto.request.UserCssCommand;

@Mapper(componentModel = "spring")
public interface UserCssConverter {
    UserCssVo entityToVo(UserCss userCss);

    UserCss toEntity(UserCssCommand command);
}
