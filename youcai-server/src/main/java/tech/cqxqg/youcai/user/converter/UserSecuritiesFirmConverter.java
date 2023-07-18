package tech.cqxqg.youcai.user.converter;



import org.mapstruct.Mapper;
import tech.cqxqg.youcai.persistence.entity.UserSecuritiesFirms;
import tech.cqxqg.youcai.user.dto.dto.UserSecuritiesFirmsDTO;
import tech.cqxqg.youcai.user.dto.request.UserSecuritiesFirmsCommand;
import tech.cqxqg.youcai.user.dto.vo.UserSecuritiesFirmsVo;

@Mapper(componentModel = "spring")
public interface UserSecuritiesFirmConverter {

    UserSecuritiesFirms dtoToEntity(UserSecuritiesFirmsDTO userSecuritiesFirmsDTO);

    UserSecuritiesFirms commandToEntity(UserSecuritiesFirmsCommand userSecuritiesFirmsCommand);

    UserSecuritiesFirmsVo entityToVO(UserSecuritiesFirms userSecuritiesFirms);
}
