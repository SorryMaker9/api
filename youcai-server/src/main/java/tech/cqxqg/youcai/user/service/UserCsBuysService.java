package tech.cqxqg.youcai.user.service;


import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import tech.cqxqg.youcai.user.dto.UserCsBuysVo;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysCommand;
import tech.cqxqg.youcai.user.dto.request.UserCsBuysPageReq;

public interface UserCsBuysService {
    /**
     * 查询用户拥有所有股票
     */
    Result<Pagination<UserCsBuysVo>> queryUserList(UserCsBuysPageReq query);
    /**
     * 添加买入记录
     */
    Result<Void> addUserCsBuys(UserCsBuysCommand userCsBuysCommand);
}
