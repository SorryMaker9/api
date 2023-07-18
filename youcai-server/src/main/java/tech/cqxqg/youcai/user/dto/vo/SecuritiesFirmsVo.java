package tech.cqxqg.youcai.user.dto.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SecuritiesFirmsVo implements Serializable {

    private Long id;

    private String logo;

    private String name;

    private BigDecimal stockMinFee;

    private BigDecimal stockCommissionRate;

    private BigDecimal floorFundMinRate;

    private BigDecimal fundCommissionRate;

    private BigDecimal financingYearRate;

    private BigDecimal financingDayRate;

    private Boolean hasShenzhenFee;

    private Integer countUsers;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
