package tech.cqxqg.youcai.user.converter;


import org.mapstruct.Mapper;
import tech.cqxqg.youcai.persistence.entity.UserCsBuys;
import tech.cqxqg.youcai.user.dto.UserCsBuysVo;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysCommand;

@Mapper(componentModel = "spring")
public interface UserCsBuysConverter {
    UserCsBuysVo entityToVo(UserCsBuys userCsBuys);

    UserCsBuys toEntity(UserCsBuysCommand command);
}
