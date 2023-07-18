package tech.cqxqg.youcai.user.converter;



import org.mapstruct.Mapper;
import tech.cqxqg.youcai.persistence.entity.ChinaSecurities;
import tech.cqxqg.youcai.user.dto.SecuritiesVo;
import tech.cqxqg.youcai.user.dto.request.SecuritiesCommand;

@Mapper(componentModel = "spring")
public interface SecuritiesConverter {
    SecuritiesVo entityToVo(ChinaSecurities securities);

    ChinaSecurities toEntity(SecuritiesCommand command);
}
