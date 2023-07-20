package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.base.Command;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class SecuritiesCommand extends Command {
    private String code;

    private String acronym;

    private String exchangeType;

    private Integer type;

    private String name;

    private Timestamp listedAt;

    private Boolean byPeople;

    private Boolean byRobot;

    private String xueqiuUrl;

    private Integer xueqiuFollow;

    private BigDecimal price;

    private Double range;

    private Double dividendRate;

    private Integer yearDividendCash;

    private Boolean isDividend;

    private String latestDividendDesc;

    private String marketValue;

    private Integer stockAmount;

    private Double pe;

    private Double pb;

    private Double ttm;

    private Double roe;

    private Double revenueYearGrowthRate;

    private Double revenueQuarterGrowthRate;

    private Double profitYearGrowthRate;

    private Double profitQuarterGrowthRate;

    private String intro;


    private Integer status;


    private Integer countReminders;


    private String tagIds;


    private Boolean isDelist;


    private String cacheTags;
}
