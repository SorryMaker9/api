package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.base.Command;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserCommand extends Command {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门ID
     */
    @NotNull
    private Long deptId;

    /**
     * 角色ID
     */
    @NotNull
    private Long roleId;

    /**
     * 登录名称
     */
    @NotBlank
    private String loginName;

    /**
     * 用户名称
     */
    @NotBlank
    private String userName;

    /**
     * 用户邮箱
     */
    @NotBlank
    private String email;

    /**
     * 手机号码
     */
    @NotBlank
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
