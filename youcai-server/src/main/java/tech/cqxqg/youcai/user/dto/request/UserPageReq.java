package tech.cqxqg.youcai.user.dto.request;


import com.swak.frame.dto.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class UserPageReq extends PageInfo {

    private String loginName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 状态
     */
    private String status;
}
