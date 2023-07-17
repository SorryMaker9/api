package tech.cqxqg.youcai.user.dto;

import com.swak.frame.dto.base.VO;
import lombok.Data;

@Data
public class UserVo implements VO {
	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 登录名称
	 */
	private String loginName;

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 用户类型
	 */
	private String userType;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 用户性别
	 */
	private String sex;

	/**
	 * 用户头像
	 */
	private String avatar;
}
