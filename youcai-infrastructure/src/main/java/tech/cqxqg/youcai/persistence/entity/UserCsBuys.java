package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 用户证券表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("user_cs_buys")
@Data
@ToString
public class UserCsBuys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户 ID
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 用户中国证券公司 ID
     */
    @TableField("user_csf_id")
    private Integer userCsfId;
    /**
     * 证券代码
     */
    private String code;
    /**
     * 用户持有中国证券 ID
     */
    @TableField("user_cs_id")
    private Integer userCsId;
    /**
     * 买入时间
     */
    @TableField("bought_at")
    private Date boughtAt;
    /**
     * 买入价格
     */
    private Integer price;
    /**
     * 买入数量
     */
    private Integer number;
    /**
     * 用户证券公司历史费率 ID
     */
    @TableField("user_csfh_id")
    private Integer userCsfhId;
    /**
     * 总股票-过户费
     */
    @TableField("fee_1")
    private Integer fee1;
    /**
     * 总证券佣金
     */
    @TableField("csf_fee")
    private Integer csfFee;
    /**
     * 成本价（加上手续费）
     */
    @TableField("cost_price")
    private Integer costPrice;
    /**
     * 是否锁仓 true:锁仓,false:解锁
     */
    @TableField("is_locked")
    private Integer isLocked;
    /**
     * 投资资金来源; 0-现金，1-场内融资，2-场外借贷
     */
    @TableField("source_investment")
    private Integer sourceInvestment;
    /**
     * 手动未售出数量
     */
    @TableField("manual_unsold_number")
    private Integer manualUnsoldNumber;
    /**
     * 手动未售出已产生利息
     */
    @TableField("manual_unsold_interests")
    private Integer manualUnsoldInterests;
    /**
     * 利息计算更新时间
     */
    @TableField("interest_computed_at")
    private Date interestComputedAt;
    /**
     * 售出状态; 0-未售出,1-全部售出,2-部分售出
     */
    @TableField("sell_status")
    private Integer sellStatus;
    /**
     * 售出描述
     */
    @TableField("sell_intro")
    private String sellIntro;
    /**
     * 个人备注
     */
    private String remark;
    /**
     * 未售出股数
     */
    @TableField("fifo_unsold_number")
    private Integer fifoUnsoldNumber;
    /**
     * 是否委托买入
     */
    @TableField("is_buy_entrusted")
    private Integer isBuyEntrusted;
    /**
     * 是否委托卖出
     */
    @TableField("is_sell_entrusted")
    private Integer isSellEntrusted;
    /**
     * 证券获得方式 0-正常买入,1-送股,2-转增股
     */
    private Integer from;
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

}
