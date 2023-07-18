package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户证券公司
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("user_securities_firms")
public class UserSecuritiesFirms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 证券公司id
     */
    @TableField("securities_firm_id")
    private Integer securitiesFirmId;
    private String logo;
    /**
     * 用户自定义证券公司名称
     */
    @TableField("custom_name")
    private String customName;
    /**
     * 默认
     */
    @TableField("is_default")
    private Integer isDefault;
    /**
     * 当前股票最低佣金
     */
    @TableField("stock_min_fee")
    private Integer stockMinFee;
    /**
     * 当前证券佣金费率
     */
    @TableField("stock_commission_rate")
    private Integer stockCommissionRate;
    /**
     * 当前基金最低佣金
     */
    @TableField("fund_min_fee")
    private Integer fundMinFee;
    /**
     * 当前基金证券佣金费率
     */
    @TableField("fund_commission_rate")
    private Integer fundCommissionRate;
    /**
     * 默认年化融资利率
     */
    @TableField("financing_year_rate")
    private Integer financingYearRate;
    /**
     * 默认日融资利率
     */
    @TableField("financing_day_rate")
    private Integer financingDayRate;
    /**
     * 深市是否收取监管费(0：不收取，1：收取)
     */
    @TableField("has_shenzhen_fee")
    private Integer hasShenzhenFee;
    /**
     * 沪市是否收取过户费(0：不收取，1：收取)
     */
    @TableField("has_shanghai_fee")
    private Integer hasShanghaiFee;
    /**
     * 持有证券总数量
     */
    @TableField("count_securities")
    private Integer countSecurities;
    /**
     * 持有股票总数量
     */
    @TableField("count_stocks")
    private Integer countStocks;
    /**
     * 持有场内基金总数量
     */
    @TableField("count_floor_funds")
    private Integer countFloorFunds;
    /**
     * 投入现金
     */
    @TableField("invested_cash")
    private Integer investedCash;
    /**
     * 投入融资
     */
    @TableField("invested_financing")
    private Integer investedFinancing;
    /**
     * 投入借贷
     */
    @TableField("invested_loans")
    private Integer investedLoans;
    /**
     * 状态(0:正常 1:停用)
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;
    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSecuritiesFirmId() {
        return securitiesFirmId;
    }

    public void setSecuritiesFirmId(Integer securitiesFirmId) {
        this.securitiesFirmId = securitiesFirmId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getStockMinFee() {
        return stockMinFee;
    }

    public void setStockMinFee(Integer stockMinFee) {
        this.stockMinFee = stockMinFee;
    }

    public Integer getStockCommissionRate() {
        return stockCommissionRate;
    }

    public void setStockCommissionRate(Integer stockCommissionRate) {
        this.stockCommissionRate = stockCommissionRate;
    }

    public Integer getFundMinFee() {
        return fundMinFee;
    }

    public void setFundMinFee(Integer fundMinFee) {
        this.fundMinFee = fundMinFee;
    }

    public Integer getFundCommissionRate() {
        return fundCommissionRate;
    }

    public void setFundCommissionRate(Integer fundCommissionRate) {
        this.fundCommissionRate = fundCommissionRate;
    }

    public Integer getFinancingYearRate() {
        return financingYearRate;
    }

    public void setFinancingYearRate(Integer financingYearRate) {
        this.financingYearRate = financingYearRate;
    }

    public Integer getFinancingDayRate() {
        return financingDayRate;
    }

    public void setFinancingDayRate(Integer financingDayRate) {
        this.financingDayRate = financingDayRate;
    }

    public Integer getHasShenzhenFee() {
        return hasShenzhenFee;
    }

    public void setHasShenzhenFee(Integer hasShenzhenFee) {
        this.hasShenzhenFee = hasShenzhenFee;
    }

    public Integer getHasShanghaiFee() {
        return hasShanghaiFee;
    }

    public void setHasShanghaiFee(Integer hasShanghaiFee) {
        this.hasShanghaiFee = hasShanghaiFee;
    }

    public Integer getCountSecurities() {
        return countSecurities;
    }

    public void setCountSecurities(Integer countSecurities) {
        this.countSecurities = countSecurities;
    }

    public Integer getCountStocks() {
        return countStocks;
    }

    public void setCountStocks(Integer countStocks) {
        this.countStocks = countStocks;
    }

    public Integer getCountFloorFunds() {
        return countFloorFunds;
    }

    public void setCountFloorFunds(Integer countFloorFunds) {
        this.countFloorFunds = countFloorFunds;
    }

    public Integer getInvestedCash() {
        return investedCash;
    }

    public void setInvestedCash(Integer investedCash) {
        this.investedCash = investedCash;
    }

    public Integer getInvestedFinancing() {
        return investedFinancing;
    }

    public void setInvestedFinancing(Integer investedFinancing) {
        this.investedFinancing = investedFinancing;
    }

    public Integer getInvestedLoans() {
        return investedLoans;
    }

    public void setInvestedLoans(Integer investedLoans) {
        this.investedLoans = investedLoans;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "UserSecuritiesFirms{" +
        ", id=" + id +
        ", userId=" + userId +
        ", securitiesFirmId=" + securitiesFirmId +
        ", logo=" + logo +
        ", customName=" + customName +
        ", isDefault=" + isDefault +
        ", stockMinFee=" + stockMinFee +
        ", stockCommissionRate=" + stockCommissionRate +
        ", fundMinFee=" + fundMinFee +
        ", fundCommissionRate=" + fundCommissionRate +
        ", financingYearRate=" + financingYearRate +
        ", financingDayRate=" + financingDayRate +
        ", hasShenzhenFee=" + hasShenzhenFee +
        ", hasShanghaiFee=" + hasShanghaiFee +
        ", countSecurities=" + countSecurities +
        ", countStocks=" + countStocks +
        ", countFloorFunds=" + countFloorFunds +
        ", investedCash=" + investedCash +
        ", investedFinancing=" + investedFinancing +
        ", investedLoans=" + investedLoans +
        ", status=" + status +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}
