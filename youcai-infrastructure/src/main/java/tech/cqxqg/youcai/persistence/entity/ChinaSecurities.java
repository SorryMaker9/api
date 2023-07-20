package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swak.frame.dto.base.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
/*
@Data
@TableName(value = "china_securities")
public class ChinaSecurities extends Entity {
    */

/**
 * 股票代码
 */
@Data
@TableName("china_securities")


public class ChinaSecurities extends Entity {

    @TableId(value = "code")
    private String code;

    @TableField(value = "acronym")
    private String acronym;

    @TableField(value = "exchange_type")
    private String exchangeType;

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "name")
    private String name;

    @TableField(value = "listed_at")
    private Timestamp listedAt;

    @TableField(value = "by_people")
    private Boolean byPeople;

    @TableField(value = "by_robot")
    private Boolean byRobot;

    @TableField(value = "xueqiu_url")
    private String xueqiuUrl;

    @TableField(value = "xueqiu_follow")
    private Integer xueqiuFollow;

    @TableField(value = "price")
    private BigDecimal price;

    @TableField(value = "`range`")
    private Double range;

    @TableField(value = "dividend_rate")
    private Double dividendRate;

    @TableField(value = "year_dividend_cash")
    private Integer yearDividendCash;

    @TableField(value = "is_dividend")
    private Boolean isDividend;

    @TableField(value = "latest_dividend_desc")
    private String latestDividendDesc;

    @TableField(value = "market_value")
    private String marketValue;

    @TableField(value = "stock_amount")
    private Integer stockAmount;


    @TableField(value = "pe")
    private Double pe;

    @TableField(value = "pb")
    private Double pb;

    @TableField(value = "ttm")
    private Double ttm;

    @TableField(value = "roe")
    private Double roe;

    @TableField(value = "revenue_year_growth_rate")
    private Double revenueYearGrowthRate;

    @TableField(value = "revenue_quarter_growth_rate")
    private Double revenueQuarterGrowthRate;

    @TableField(value = "profit_year_growth_rate")
    private Double profitYearGrowthRate;

    @TableField(value = "profit_quarter_growth_rate")
    private Double profitQuarterGrowthRate;

    @TableField(value = "intro")
    private String intro;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "count_reminders")
    private Integer countReminders;

    @TableField(value = "tag_ids")
    private String tagIds;

    @TableField(value = "is_delist")
    private Boolean isDelist;

    @TableField(value = "cache_tags")
    private String cacheTags;
}



