package tech.cqxqg.youcai.user.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户证券公司 ID、买入日期、买入价、买入数量
 */
@Data
public class BondsDto {
    //用户证券公司 ID
    private String code;
    //买入日期
    private String buyTime;
    //买入价
    private BigDecimal buyPrice;
    //买入数量
    private Integer number;
}
