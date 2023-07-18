package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户中国证券公司历史数据
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("user_csf_histories")
public class UserCsfHistories implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户中国证券公司 ID
     */
    @TableField("user_securities_firm_id")
    private Integer userSecuritiesFirmId;
    /**
     * 当时股票最低佣金
     */
    @TableField("stock_min_fee")
    private Integer stockMinFee;
    /**
     * 当时证券佣金费率
     */
    @TableField("stock_commission_rate")
    private Integer stockCommissionRate;
    /**
     * 当时基金最低佣金
     */
    @TableField("fund_min_fee")
    private Integer fundMinFee;
    /**
     * 当时基金证券佣金费率
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
     * 开始时间
     */
    @TableField("started_time")
    private Date startedTime;
    /**
     * 结束时间
     */
    @TableField("ended_time")
    private Date endedTime;
    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;
    /**
     * 更新时间
     */
    @TableField("updated_at")
    private Integer updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserSecuritiesFirmId() {
        return userSecuritiesFirmId;
    }

    public void setUserSecuritiesFirmId(Integer userSecuritiesFirmId) {
        this.userSecuritiesFirmId = userSecuritiesFirmId;
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

    public Date getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Date startedTime) {
        this.startedTime = startedTime;
    }

    public Date getEndedTime() {
        return endedTime;
    }

    public void setEndedTime(Date endedTime) {
        this.endedTime = endedTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserCsfHistories{" +
        ", id=" + id +
        ", userSecuritiesFirmId=" + userSecuritiesFirmId +
        ", stockMinFee=" + stockMinFee +
        ", stockCommissionRate=" + stockCommissionRate +
        ", fundMinFee=" + fundMinFee +
        ", fundCommissionRate=" + fundCommissionRate +
        ", financingYearRate=" + financingYearRate +
        ", financingDayRate=" + financingDayRate +
        ", startedTime=" + startedTime +
        ", endedTime=" + endedTime +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
