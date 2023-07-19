package tech.cqxqg.youcai.user.converter;

import org.mapstruct.Mapper;
import tech.cqxqg.youcai.persistence.entity.UserCsSells;
import tech.cqxqg.youcai.user.dto.UserCsSellsVo;
import tech.cqxqg.youcai.user.dto.request.UserCsSellsCommand;

@Mapper(componentModel = "spring")
public interface UserCsSellsConverter {
    UserCsSellsVo entityToVo(UserCsSells userCsSells);

    UserCsSells toEntity(UserCsSellsCommand command);
}
