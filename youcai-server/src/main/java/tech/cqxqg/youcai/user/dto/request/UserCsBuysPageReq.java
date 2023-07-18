package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.PageInfo;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserCsBuysPageReq extends PageInfo implements Serializable {


    /**
     * 用户 ID
     */
    private Integer userId;
    /**
     * 用户中国证券公司 ID
     */

    private Integer userCsfId;
    /**
     * 证券代码
     */
    private String code;
    /**
     * 用户持有中国证券 ID
     */

}
