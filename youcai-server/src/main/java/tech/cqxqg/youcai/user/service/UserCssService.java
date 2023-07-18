package tech.cqxqg.youcai.user.service;




import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import tech.cqxqg.youcai.user.dto.UserCssVo;
import tech.cqxqg.youcai.user.dto.request.UserCssPageReq;

public interface UserCssService {


    /**
     * 根据用户id 证券类型 证券名 证券代码查询
     */
    Result<Pagination<UserCssVo>> queryUserCssList(UserCssPageReq query);

}
