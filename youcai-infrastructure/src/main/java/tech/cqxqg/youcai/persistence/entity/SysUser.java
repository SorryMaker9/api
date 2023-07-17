package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swak.frame.dto.base.Entity;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_user")
public class SysUser extends Entity {

	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 部门ID
	 */
	@TableField(value = "dept_id")
	private Long deptId;

	/**
	 * 登录名称
	 */
	@TableField(value = "login_name")
	private String loginName;

	/**
	 * 用户名称
	 */
	@TableField(value = "user_name")
	private String userName;

	/**
	 * 用户类型
	 */
	@TableField(value = "user_type")
	private String userType;

	/**
	 * 用户邮箱
	 */
	@TableField(value = "email")
	private String email;

	/**
	 * 手机号码
	 */
	@TableField(value = "phone")
	private String phone;

	/**
	 * 用户性别
	 */
	@TableField(value = "sex")
	private String sex;

	/**
	 * 用户头像
	 */
	@TableField(value = "avatar")
	private String avatar;

	/**
	 * 密码
	 */
	@TableField(value = "password")
	private String password;

	/**
	 * 盐加密
	 */
	@TableField(value = "salt")
	private String salt;

	/**
	 * 帐号状态（0正常 1停用）
	 */
	@TableField(value = "status")
	private String status;

	/**
	 * 删除标志（0代表存在 -1代表删除）
	 */
	@TableField(value = "del_flag")
	private String delFlag;

	/**
	 * 最后登录IP
	 */
	@TableField(value = "login_ip")
	private String loginIp;

	/**
	 * 最后登录时间
	 */
	@TableField(value = "login_date")
	private Date loginDate;

	/**
	 * 密码最后更新时间
	 */
	@TableField(value = "pwd_update_date")
	private Date pwdUpdateDate;

	/**
	 * 创建人
	 */
	@TableField(value = "creator_id")
	private String creatorId;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	private Date createTime;

	/**
	 * 修改人
	 */
	@TableField(value = "modifier_id")
	private String modifierId;

	/**
	 * 修改时间
	 */
	@TableField(value = "modify_time")
	private Date modifyTime;

}

