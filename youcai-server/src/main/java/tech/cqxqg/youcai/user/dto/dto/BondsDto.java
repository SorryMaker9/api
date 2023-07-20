package tech.cqxqg.youcai.user.dto.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户证券公司 ID、、买入日期、买入价、买入数量
 */
@Data
public class BondsDto {
    //买入记录Id
    private Integer id;
    //中国证券ID
    private Integer firmId;
    //证券ID
    private String code;
    //买入日期
    private String buyTime;
    //买入价 分为单位
    private Integer buyPrice;
    //买入数量
    private Integer number;
    //个人备注
    private String remark;
}
