package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户证券公司
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@Data
@TableName("user_securities_firms")
public class UserSecuritiesFirms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 证券公司id
     */
    @TableField("securities_firm_id")
    private Long securitiesFirmId;
    /**
     * 公司logo
     */
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
    private Boolean isDefault;
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
    private Boolean hasShenzhenFee;
    /**
     * 沪市是否收取过户费(0：不收取，1：收取)
     */
    @TableField("has_shanghai_fee")
    private Boolean hasShanghaiFee;
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
     *
     */
    @TableField("invested_all")
    private Integer investedAll;
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
    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    /**
     * 更新时间
     */
    @TableField(value = "updated_time",fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;


}
