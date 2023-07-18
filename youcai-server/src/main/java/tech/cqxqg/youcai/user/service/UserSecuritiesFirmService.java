package tech.cqxqg.youcai.user.service;


import com.swak.frame.dto.Pagination;
import tech.cqxqg.youcai.user.dto.dto.UserSecuritiesFirmsDTO;
import tech.cqxqg.youcai.user.dto.request.UserSecuritiesFirmsCommand;
import tech.cqxqg.youcai.user.dto.vo.UserSecuritiesFirmsVo;

public interface UserSecuritiesFirmService {

    void saveUserSecuritiesFirm(UserSecuritiesFirmsDTO userSecuritiesFirmsDTO);

    Pagination<UserSecuritiesFirmsVo> getPage(Integer page, Integer pageSize);

    void updateUserSecuritiesFirm(UserSecuritiesFirmsCommand userSecuritiesFirmsCommand);

    void deleteUserSecuritiesFirm(Long id);

}
