package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.PageInfo;
import lombok.Data;
import lombok.ToString;

@Data
public class UserCssPageReq extends PageInfo {
    /**
     * 用户 ID
     */
    private Integer userId;
    /**
     * 0-股票,1-场内基金,2-国债
     */
    private Integer type;
    /**
     * 证券名称
     */
    private String name;
    /**
     * 证券代码
     */
    private String code;

}
