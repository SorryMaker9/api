package tech.cqxqg.youcai.persistence.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户持有中国证券卖出记录
 * </p>
 *
 * @author feng
 * @since 2023-07-18
 */
@Data
@TableName("user_cs_sells")
public class UserCsSells implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 卖出记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 用户中国证券ID
     */
    @TableField("user_csf_id")
    private Integer userCsfId;

    /**
     * 证券代码
     */
    @TableField("code")
    private String code;

    /**
     * 用户持有中国证券ID
     */
    @TableField("user_cs_id")
    private Integer userCsId;

    /**
     * 卖出时间
     */
    @TableField("sold_at")
    private LocalDateTime soldAt;

    /**
     * 卖出价格
     */
    @TableField("price")
    private Integer price;

    /**
     * 卖出数量
     */
    @TableField("number")
    private Integer number;

    /**
     * 用户证券公司历史费率
     */
    @TableField("user_csfh_id")
    private Integer userCsfhId;

    /**
     * 总股票—过户费
     */
    @TableField("fee_1")
    private Integer fee1;

    /**
     * 总股票-印花税
     */
    @TableField("fee_2")
    private Integer fee2;

    /**
     * 总证券佣金
     */
    @TableField("csf_fee")
    private Integer csfFee;

    /**
     * 总已结算红利税
     */
    @TableField("dividend_fee")
    private Integer dividendFee;

    /**
     * 总已结算利息
     */
    @TableField("interests")
    private Integer interests;

    /**
     * 利润
     */
    @TableField("profit")
    private Integer profit;

    /**
     * 获利比
     */
    @TableField("profit_rate")
    private BigDecimal profitRate;

    /**
     * 持有天数
     */
    @TableField("holding_days")
    private Integer holdingDays;

    /**
     * 日获利年化比
     */
    @TableField("daily_rate")
    private BigDecimal dailyRate;

    /**
     * 是否做买入参考
     */
    @TableField("is_refered")
    private Boolean isRefered;

    /**
     * 个人备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 是否委托买入
     */
    @TableField("is_buy_entrusted")
    private Boolean isBuyEntrusted;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;

}
