package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 中国证券分红送配表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("cs_dividends")
public class CsDividends implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 股票分红记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 分红送配报告年份 公司财报
     */
    private Integer year;
    /**
     * 分红送配报告月份 公司财报 3-一季度 6-中报 9-三季度 12-年报 0其他
     */
    private Integer month;
    /**
     * 财报PDF链接
     */
    @TableField("dividend_pdf_url")
    private String dividendPdfUrl;
    /**
     * 股票代码
     */
    private String code;
    /**
     * 网易爬虫关键字
     */
    @TableField("creeper_code")
    private String creeperCode;
    /**
     * 名称
     */
    private String name;
    /**
     * 股权登记日
     */
    @TableField("record_at")
    private Date recordAt;
    /**
     * 派息日
     */
    @TableField("pay_at")
    private Date payAt;
    /**
     * 除权除息日
     */
    @TableField("ex_dividend_at")
    private Date exDividendAt;
    /**
     * 除权除息年份
     */
    @TableField("ex_dividend_year")
    private Integer exDividendYear;
    /**
     * 公告日期
     */
    @TableField("announced_at")
    private Date announcedAt;
    /**
     * 年度利润
     */
    @TableField("year_profit")
    private BigDecimal yearProfit;
    /**
     * 年度营收
     */
    @TableField("year_revenue")
    private BigDecimal yearRevenue;
    /**
     * 利润分红比 分红比例5.36%则存储536 显示除以10000
     */
    private Integer sharing;
    /**
     * 股本数量,当年分红的股本数量,以万为单位暂不计算逆回购
     */
    @TableField("stock_amount")
    private BigDecimal stockAmount;
    /**
     * 分红总额 万元
     */
    @TableField("total_dividend")
    private BigDecimal totalDividend;
    /**
     * 同比增长 存5.36,显示5.36%
     */
    @TableField("growth_rate")
    private Double growthRate;
    /**
     * 净利润同比增长 存5.36,显示5.36%
     */
    @TableField("profit_growth_rate")
    private Double profitGrowthRate;
    /**
     * 营收同比增长存5.36,显示5.36%
     */
    @TableField("revenue_growth_rate")
    private Double revenueGrowthRate;
    /**
     * 送股
     */
    @TableField("count_stock_give")
    private Integer countStockGive;
    /**
     * 转增
     */
    @TableField("count_stock_add")
    private Integer countStockAdd;
    @TableField("count_money")
    private Double countMoney;
    /**
     * 人工校验 true-人工校验正确 false 未校验 默认为false
     */
    @TableField("is_checked")
    private Integer isChecked;
    /**
     * 股息1%的价格
     */
    @TableField("rate_1")
    private Double rate1;
    /**
     * 股息1%的价格
     */
    @TableField("rate_2")
    private Double rate2;
    /**
     * 股息1%的价格
     */
    @TableField("rate_3")
    private Double rate3;
    /**
     * 股息1%的价格
     */
    @TableField("rate_4")
    private Double rate4;
    /**
     * 股息1%的价格
     */
    @TableField("rate_5")
    private Double rate5;
    /**
     * 股息1%的价格
     */
    @TableField("rate_6")
    private Double rate6;
    /**
     * 股息1%的价格
     */
    @TableField("rate_7")
    private Double rate7;
    /**
     * 股息1%的价格
     */
    @TableField("rate_8")
    private Double rate8;
    /**
     * 股息1%的价格
     */
    @TableField("rate_9")
    private Double rate9;
    /**
     * 股息1%的价格
     */
    @TableField("rate_10")
    private Double rate10;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getDividendPdfUrl() {
        return dividendPdfUrl;
    }

    public void setDividendPdfUrl(String dividendPdfUrl) {
        this.dividendPdfUrl = dividendPdfUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreeperCode() {
        return creeperCode;
    }

    public void setCreeperCode(String creeperCode) {
        this.creeperCode = creeperCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }

    public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }

    public Date getExDividendAt() {
        return exDividendAt;
    }

    public void setExDividendAt(Date exDividendAt) {
        this.exDividendAt = exDividendAt;
    }

    public Integer getExDividendYear() {
        return exDividendYear;
    }

    public void setExDividendYear(Integer exDividendYear) {
        this.exDividendYear = exDividendYear;
    }

    public Date getAnnouncedAt() {
        return announcedAt;
    }

    public void setAnnouncedAt(Date announcedAt) {
        this.announcedAt = announcedAt;
    }

    public BigDecimal getYearProfit() {
        return yearProfit;
    }

    public void setYearProfit(BigDecimal yearProfit) {
        this.yearProfit = yearProfit;
    }

    public BigDecimal getYearRevenue() {
        return yearRevenue;
    }

    public void setYearRevenue(BigDecimal yearRevenue) {
        this.yearRevenue = yearRevenue;
    }

    public Integer getSharing() {
        return sharing;
    }

    public void setSharing(Integer sharing) {
        this.sharing = sharing;
    }

    public BigDecimal getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(BigDecimal stockAmount) {
        this.stockAmount = stockAmount;
    }

    public BigDecimal getTotalDividend() {
        return totalDividend;
    }

    public void setTotalDividend(BigDecimal totalDividend) {
        this.totalDividend = totalDividend;
    }

    public Double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(Double growthRate) {
        this.growthRate = growthRate;
    }

    public Double getProfitGrowthRate() {
        return profitGrowthRate;
    }

    public void setProfitGrowthRate(Double profitGrowthRate) {
        this.profitGrowthRate = profitGrowthRate;
    }

    public Double getRevenueGrowthRate() {
        return revenueGrowthRate;
    }

    public void setRevenueGrowthRate(Double revenueGrowthRate) {
        this.revenueGrowthRate = revenueGrowthRate;
    }

    public Integer getCountStockGive() {
        return countStockGive;
    }

    public void setCountStockGive(Integer countStockGive) {
        this.countStockGive = countStockGive;
    }

    public Integer getCountStockAdd() {
        return countStockAdd;
    }

    public void setCountStockAdd(Integer countStockAdd) {
        this.countStockAdd = countStockAdd;
    }

    public Double getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(Double countMoney) {
        this.countMoney = countMoney;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public Double getRate1() {
        return rate1;
    }

    public void setRate1(Double rate1) {
        this.rate1 = rate1;
    }

    public Double getRate2() {
        return rate2;
    }

    public void setRate2(Double rate2) {
        this.rate2 = rate2;
    }

    public Double getRate3() {
        return rate3;
    }

    public void setRate3(Double rate3) {
        this.rate3 = rate3;
    }

    public Double getRate4() {
        return rate4;
    }

    public void setRate4(Double rate4) {
        this.rate4 = rate4;
    }

    public Double getRate5() {
        return rate5;
    }

    public void setRate5(Double rate5) {
        this.rate5 = rate5;
    }

    public Double getRate6() {
        return rate6;
    }

    public void setRate6(Double rate6) {
        this.rate6 = rate6;
    }

    public Double getRate7() {
        return rate7;
    }

    public void setRate7(Double rate7) {
        this.rate7 = rate7;
    }

    public Double getRate8() {
        return rate8;
    }

    public void setRate8(Double rate8) {
        this.rate8 = rate8;
    }

    public Double getRate9() {
        return rate9;
    }

    public void setRate9(Double rate9) {
        this.rate9 = rate9;
    }

    public Double getRate10() {
        return rate10;
    }

    public void setRate10(Double rate10) {
        this.rate10 = rate10;
    }

    @Override
    public String toString() {
        return "CsDividends{" +
        ", id=" + id +
        ", year=" + year +
        ", month=" + month +
        ", dividendPdfUrl=" + dividendPdfUrl +
        ", code=" + code +
        ", creeperCode=" + creeperCode +
        ", name=" + name +
        ", recordAt=" + recordAt +
        ", payAt=" + payAt +
        ", exDividendAt=" + exDividendAt +
        ", exDividendYear=" + exDividendYear +
        ", announcedAt=" + announcedAt +
        ", yearProfit=" + yearProfit +
        ", yearRevenue=" + yearRevenue +
        ", sharing=" + sharing +
        ", stockAmount=" + stockAmount +
        ", totalDividend=" + totalDividend +
        ", growthRate=" + growthRate +
        ", profitGrowthRate=" + profitGrowthRate +
        ", revenueGrowthRate=" + revenueGrowthRate +
        ", countStockGive=" + countStockGive +
        ", countStockAdd=" + countStockAdd +
        ", countMoney=" + countMoney +
        ", isChecked=" + isChecked +
        ", rate1=" + rate1 +
        ", rate2=" + rate2 +
        ", rate3=" + rate3 +
        ", rate4=" + rate4 +
        ", rate5=" + rate5 +
        ", rate6=" + rate6 +
        ", rate7=" + rate7 +
        ", rate8=" + rate8 +
        ", rate9=" + rate9 +
        ", rate10=" + rate10 +
        "}";
    }
}
