package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 证券公司
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("securities_firms")
public class SecuritiesFirms implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 公司logo
     */
    private String logo;
    /**
     * 证券公司名称
     */
    private String name;
    /**
     * 默认股票最低佣金
     */
    @TableField("stock_min_fee")
    private Integer stockMinFee;
    /**
     * 默认证券佣金费率
     */
    @TableField("stock_commission_rate")
    private Integer stockCommissionRate;
    /**
     * 默认场内基金最低佣金
     */
    @TableField("floor_fund_min_rate")
    private Integer floorFundMinRate;
    /**
     * 默认场内基金证券佣金费率
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
     * 默认融资利率
     */
    @TableField("financing_rate")
    private Integer financingRate;
    /**
     * 是否单独手续深市过户费
     */
    @TableField("has_shenzhen_fee")
    private Integer hasShenzhenFee;
    /**
     * 用户数
     */
    @TableField("count_users")
    private Integer countUsers;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getFloorFundMinRate() {
        return floorFundMinRate;
    }

    public void setFloorFundMinRate(Integer floorFundMinRate) {
        this.floorFundMinRate = floorFundMinRate;
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

    public Integer getFinancingRate() {
        return financingRate;
    }

    public void setFinancingRate(Integer financingRate) {
        this.financingRate = financingRate;
    }

    public Integer getHasShenzhenFee() {
        return hasShenzhenFee;
    }

    public void setHasShenzhenFee(Integer hasShenzhenFee) {
        this.hasShenzhenFee = hasShenzhenFee;
    }

    public Integer getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(Integer countUsers) {
        this.countUsers = countUsers;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SecuritiesFirms{" +
        ", id=" + id +
        ", logo=" + logo +
        ", name=" + name +
        ", stockMinFee=" + stockMinFee +
        ", stockCommissionRate=" + stockCommissionRate +
        ", floorFundMinRate=" + floorFundMinRate +
        ", fundCommissionRate=" + fundCommissionRate +
        ", financingYearRate=" + financingYearRate +
        ", financingDayRate=" + financingDayRate +
        ", financingRate=" + financingRate +
        ", hasShenzhenFee=" + hasShenzhenFee +
        ", countUsers=" + countUsers +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
