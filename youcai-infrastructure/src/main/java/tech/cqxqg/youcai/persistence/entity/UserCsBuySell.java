package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户证券交易记录表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("user_cs_buy_sell")
public class UserCsBuySell implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户持有中国证券买入记录 ID
     */
    @TableField("user_cs_buy_id")
    private Integer userCsBuyId;
    /**
     * 用户持有中国证券卖出记录 ID
     */
    @TableField("user_cs_sell_id")
    private Integer userCsSellId;
    /**
     * 卖出前买入未售出数量
     */
    @TableField("before_unsold_number")
    private Integer beforeUnsoldNumber;
    /**
     * 卖出数量
     */
    @TableField("sold_number")
    private Integer soldNumber;
    /**
     * 卖出后买入未售出数量
     */
    @TableField("after_unsold_number")
    private Integer afterUnsoldNumber;
    /**
     * 股票-过户费
     */
    @TableField("buy_fee_1")
    private Integer buyFee1;
    /**
     * 买入证券佣金
     */
    @TableField("buy_csf_fee")
    private Integer buyCsfFee;
    /**
     * 股票-过户费
     */
    @TableField("sell_fee_1")
    private Integer sellFee1;
    /**
     * 股票-印花税
     */
    @TableField("sell_fee_2")
    private Integer sellFee2;
    /**
     * 卖出证券佣金
     */
    @TableField("sell_csf_fee")
    private Integer sellCsfFee;
    /**
     * 已结算红利税
     */
    @TableField("dividend_fee")
    private Integer dividendFee;
    /**
     * 已结算利息
     */
    private Integer interests;
    /**
     * 卖出利润
     */
    private Integer profit;
    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;
    /**
     * 更新时间
     */
    @TableField("updated_at")
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserCsBuyId() {
        return userCsBuyId;
    }

    public void setUserCsBuyId(Integer userCsBuyId) {
        this.userCsBuyId = userCsBuyId;
    }

    public Integer getUserCsSellId() {
        return userCsSellId;
    }

    public void setUserCsSellId(Integer userCsSellId) {
        this.userCsSellId = userCsSellId;
    }

    public Integer getBeforeUnsoldNumber() {
        return beforeUnsoldNumber;
    }

    public void setBeforeUnsoldNumber(Integer beforeUnsoldNumber) {
        this.beforeUnsoldNumber = beforeUnsoldNumber;
    }

    public Integer getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(Integer soldNumber) {
        this.soldNumber = soldNumber;
    }

    public Integer getAfterUnsoldNumber() {
        return afterUnsoldNumber;
    }

    public void setAfterUnsoldNumber(Integer afterUnsoldNumber) {
        this.afterUnsoldNumber = afterUnsoldNumber;
    }

    public Integer getBuyFee1() {
        return buyFee1;
    }

    public void setBuyFee1(Integer buyFee1) {
        this.buyFee1 = buyFee1;
    }

    public Integer getBuyCsfFee() {
        return buyCsfFee;
    }

    public void setBuyCsfFee(Integer buyCsfFee) {
        this.buyCsfFee = buyCsfFee;
    }

    public Integer getSellFee1() {
        return sellFee1;
    }

    public void setSellFee1(Integer sellFee1) {
        this.sellFee1 = sellFee1;
    }

    public Integer getSellFee2() {
        return sellFee2;
    }

    public void setSellFee2(Integer sellFee2) {
        this.sellFee2 = sellFee2;
    }

    public Integer getSellCsfFee() {
        return sellCsfFee;
    }

    public void setSellCsfFee(Integer sellCsfFee) {
        this.sellCsfFee = sellCsfFee;
    }

    public Integer getDividendFee() {
        return dividendFee;
    }

    public void setDividendFee(Integer dividendFee) {
        this.dividendFee = dividendFee;
    }

    public Integer getInterests() {
        return interests;
    }

    public void setInterests(Integer interests) {
        this.interests = interests;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserCsBuySell{" +
        ", id=" + id +
        ", userCsBuyId=" + userCsBuyId +
        ", userCsSellId=" + userCsSellId +
        ", beforeUnsoldNumber=" + beforeUnsoldNumber +
        ", soldNumber=" + soldNumber +
        ", afterUnsoldNumber=" + afterUnsoldNumber +
        ", buyFee1=" + buyFee1 +
        ", buyCsfFee=" + buyCsfFee +
        ", sellFee1=" + sellFee1 +
        ", sellFee2=" + sellFee2 +
        ", sellCsfFee=" + sellCsfFee +
        ", dividendFee=" + dividendFee +
        ", interests=" + interests +
        ", profit=" + profit +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
