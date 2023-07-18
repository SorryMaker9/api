package tech.cqxqg.youcai.user.dto.request;


import com.swak.frame.dto.base.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserSecuritiesFirmsCommand extends Command implements Serializable {

    @NotNull(message = "param not null")
    Long id;

    private String logo;

    private String customName;

    private Boolean isDefault;

    private BigDecimal stockMinFee;

    private BigDecimal stockCommissionRate;

    private BigDecimal fundMinFee;

    private BigDecimal fundCommissionRate;

    private Integer financingYearRate;

    private BigDecimal financingDayRate;

    private Boolean hasShenzhenFee;

    private Boolean hasShanghaiFee;

    private Integer countSecurities;

    private Integer countStocks;

    private Integer countFloorFunds;

    private BigDecimal investedAll;

    private BigDecimal investedCash;

    private BigDecimal investedFinancing;

    private BigDecimal investedLoans;

    private Integer status;

}
