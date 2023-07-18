package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.swak.frame.dto.base.Entity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 证券公司
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@Data
@TableName("securities_firms")
public class SecuritiesFirms extends Entity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
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
     * 是否单独手续深市过户费
     */
    @TableField("has_shenzhen_fee")
    private Boolean hasShenzhenFee;
    /**
     * 用户数
     */
    @TableField("count_users")
    private Integer countUsers;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;

}
