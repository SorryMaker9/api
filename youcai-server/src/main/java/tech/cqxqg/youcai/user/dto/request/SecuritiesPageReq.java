package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.PageInfo;
import lombok.Data;

@Data
public class SecuritiesPageReq extends PageInfo {
    /**
     * 证券类型
     */
    private Integer type;
    /**
     * 证券名称
     */
    private String name;
}
