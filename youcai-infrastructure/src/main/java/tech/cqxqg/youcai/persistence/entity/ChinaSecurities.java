package tech.cqxqg.youcai.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swak.frame.dto.base.Entity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 中国证券表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@Data
@ToString
@TableName("china_securities")
public class ChinaSecurities extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 股票代码
     */
    @TableId(value = "`code`")
    private String code;
    /**
     * 证券中文首字母缩写
     */
    private String arcronym;
    /**
     * 交易所类型 SH/SZ/NQ/BJ
     */
    @TableField("exchange_type")
    private String exchangeType;
    /**
     * 0-股票,1-场内基金,2-国债,3-可转债 4-企业债,5逆回购
     */
    private Integer type;
    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;
    /**
     * 上市时间
     */
    @TableField("list_at")
    private Date listAt;
    /**
     * 人工判断优质否 true优质, false-不优质,默认false
     */
    @TableField("by_people")
    private Integer byPeople;
    /**
     * 机器判断优质否 true优质, false-不优质,默认false
     */
    @TableField("by_rebot")
    private Integer byRebot;
    /**
     * 雪球链接
     */
    @TableField("xueqiu_url")
    private String xueqiuUrl;
    /**
     * 雪球关注数
     */
    @TableField("xueqiu_follow")
    private Integer xueqiuFollow;
    /**
     * 当前价格
     */
    private BigDecimal price;
    /**
     * 当前涨跌幅
     */
    @TableField("`range`")
    private Double range;
    /**
     * 当前股息率
     */
    @TableField("dividend_rate")
    private Double dividendRate;
    /**
     * 年分红现金 每10股能分得的现金,单位为分
     */
    @TableField("dividend_cash")
    private Integer dividendCash;
    /**
     * 是否长期分红 true-每年分红,false分红不稳定,默认为true
     */
    @TableField("is_dividend")
    private Integer isDividend;
    /**
     * 最新分红描述 取分红最新的一条记录 2019预/2019-6-6登记10转A送B派C
     */
    @TableField("latest_dividend_desc")
    private String latestDividendDesc;
    /**
     * 市值
     */
    @TableField("market_value")
    private String marketValue;
    /**
     * 当前股本数量
     */
    @TableField("stock_amount")
    private Integer stockAmount;
    /**
     *  市盈率 存10.22,显示10.22%
     */
    private Double pe;
    /**
     * 市净率 存10.22,显示10.22%
     */
    private Double pb;
    /**
     * 动态市盈率 存10.22,显示10.22%
     */
    private Double ttm;
    /**
     * 净资产收益率 存10.22,显示10.22%
     */
    private Double roe;
    /**
     * 营收年增长率 存10.22,显示10.22%
     */
    @TableField("revenue_year_growth_rate")
    private Double revenueYearGrowthRate;
    /**
     * 营收季度增长率 存10.22,显示10.22%
     */
    @TableField("revenue_quarter_growth_rate")
    private Double revenueQuarterGrowthRate;
    /**
     * 利润年增长率 存10.22,显示10.22%
     */
    @TableField("profit_year_growth_rate")
    private Double profitYearGrowthRate;
    /**
     * 利润季度增长率 存10.22,显示10.22%
     */
    @TableField("profit_quarter_growth_rate")
    private Double profitQuarterGrowthRate;
    /**
     * 简介
     */
    private String intro;
    /**
     * 状态 0-正常 1-删除 2-禁用 3-退市
     */
    @TableField("`status`")
    private Integer status;
    /**
     * 需要提醒的会员数
     */
    @TableField("count_reminders")
    private Integer countReminders;
    /**
     * 标签IDs, 以|分隔
     */
    @TableField("tag_ids")
    private String tagIds;
    /**
     * 退市 0-退市, 1-正常
     */
    @TableField("is_delist")
    private Integer isDelist;
    /**
     * 标签名称 以|分隔
     */
    @TableField("cache_tags")
    private String cacheTags;

}
