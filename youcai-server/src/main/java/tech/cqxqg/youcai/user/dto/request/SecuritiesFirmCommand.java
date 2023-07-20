package tech.cqxqg.youcai.user.dto.request;


import com.swak.frame.dto.base.Command;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SecuritiesFirmCommand extends Command implements Serializable  {

    private Long id;

    private String logo;

    private String name;

    private BigDecimal stockMinFee;

    private BigDecimal stockCommissionRate;

    private BigDecimal floorFundMinRate;

    private BigDecimal fundCommissionRate;

    private BigDecimal financingYearRate;

    private BigDecimal financingDayRate;

    private BigDecimal financingRate;

    private Boolean hasShenzhenFee;

}
