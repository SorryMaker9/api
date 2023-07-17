package tech.cqxqg.youcai.user.service;

import tech.cqxqg.youcai.user.dto.UserVo;
import tech.cqxqg.youcai.user.dto.request.UserCommand;
import tech.cqxqg.youcai.user.dto.request.UserPageReq;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;

import java.util.List;

/**
 * @author colley.ma
 * @since 2023/2/9 11:31
 */
public interface UserService {


	/**
	 * 通过用户名查询用户
	 *
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	 UserVo selectUserByLoginName(String userName);

	/**
	 * 通过手机号码查询用户
	 *
	 * @param phone 手机号码
	 * @return 用户对象信息
	 */
	 UserVo selectUserByPhoneNumber(String phone);

	/**
	 * 注册用户信息
	 *
	 * @param command 用户信息
	 * @return 结果
	 */
	 Result<Void> addUser(UserCommand command);

	/**
	 * 保存用户信息
	 *
	 * @param command 用户信息
	 * @return 结果
	 */
	Result<Void>  updateUser(UserCommand command);

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
    Result<Pagination<UserVo>> queryUserList(UserPageReq query);


	/**
	 * 删除用户
	 * @param ids
	 * @return
	 */
	 Result<Void> delete(List<Long> ids);

}
