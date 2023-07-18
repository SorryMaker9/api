package tech.cqxqg.youcai.user.converter;


import org.mapstruct.Mapper;
import tech.cqxqg.youcai.persistence.entity.SecuritiesFirms;
import tech.cqxqg.youcai.user.dto.dto.SecuritiesFirmDTO;
import tech.cqxqg.youcai.user.dto.request.SecuritiesFirmCommand;
import tech.cqxqg.youcai.user.dto.vo.SecuritiesFirmsVo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecuritiesFirmConverter {

    List<SecuritiesFirmsVo> entityListToVoList(List<SecuritiesFirms> securitiesFirms);

    SecuritiesFirms commandToEntity(SecuritiesFirmCommand securitiesFirmCommand);

    SecuritiesFirms dtoTOEntity(SecuritiesFirmDTO securitiesFirmDTO);

}
