package tech.cqxqg.youcai.user.service;


import com.swak.frame.dto.Pagination;
import tech.cqxqg.youcai.user.dto.dto.SecuritiesFirmDTO;
import tech.cqxqg.youcai.user.dto.request.SecuritiesFirmCommand;
import tech.cqxqg.youcai.user.dto.vo.SecuritiesFirmsVo;

public interface SecuritiesFirmService {


    Pagination<SecuritiesFirmsVo> getPage(String name, Integer page, Integer pageSize);

    void saveSecuritiesFirm(SecuritiesFirmDTO securitiesFirmDTO);

    void updateSecuritiesFirm(SecuritiesFirmCommand securitiesFirmCommand);

    void deleteSecuritiesFirm(Long id);

}
