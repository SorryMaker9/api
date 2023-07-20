package tech.cqxqg.youcai.user.dto;

import lombok.Data;

@Data
public class BondsVo {
    //买入数量
    private Integer number;
    //买入成本费 买入价 + 手续费
    private Integer costPrice;
    //买入手续费
    private Integer fee;
}
