package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 证券信息表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@Data
@TableName(value = "user_css")
public class UserCss implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户 ID
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 0-股票,1-场内基金,2-国债
     */
    @TableField("type")
    private Integer type;
    /**
     * 证券名称
     */
    @TableField("name")
    private String name;
    /**
     * 证券代码
     */
    @TableField("code")
    private String code;
    /**
     * 持仓比例
     */
    @TableField("position_ratio")
    private Integer positionRatio;
    /**
     * 市值
     */
    @TableField("market_value")
    private Integer marketValue;
    /**
     * 投入总资金量
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
     * 持有总数量
     */
    private Integer holdings;
    /**
     * 目标持有总数量
     */
    @TableField("target_holdings")
    private Integer targetHoldings;
    /**
     * 锁仓购买股数
     */
    @TableField("locked_buy_number")
    private Integer lockedBuyNumber;
    /**
     * 未锁仓最低买入价格
     */
    @TableField("lowest_unlocked_buy_price")
    private Integer lowestUnlockedBuyPrice;
    /**
     * 未锁仓最低买入记录 ID
     */
    @TableField("lowest_unlocked_buy_id")
    private Integer lowestUnlockedBuyId;
    /**
     * 最近提醒买入价
     */
    @TableField("reminded_buy_price")
    private Integer remindedBuyPrice;
    /**
     * 最近提醒买入波动
     */
    @TableField("reminded_buy_fluctuation")
    private Integer remindedBuyFluctuation;
    /**
     * 买入最近提醒时间
     */
    @TableField("reminded_buy_time")
    private Date remindedBuyTime;
    /**
     * 0-最高卖出价，1-最近卖出价
     */
    @TableField("sell_refer_type")
    private Integer sellReferType;
    /**
     * 最近提醒卖出价
     */
    @TableField("reminded_sell_price")
    private Integer remindedSellPrice;
    /**
     * 最近提醒卖出波动
     */
    @TableField("reminded_sell_fluctuation")
    private Integer remindedSellFluctuation;
    /**
     * 卖出最近提醒时间
     */
    @TableField("reminded_sell_time")
    private Date remindedSellTime;
    /**
     * 目标买入价
     */
    @TableField("target_buy_price")
    private Integer targetBuyPrice;
    /**
     * 最近提醒目标买入价
     */
    @TableField("reminded_target_buy_price")
    private Integer remindedTargetBuyPrice;
    /**
     * 目标买入价最近提醒时间
     */
    @TableField("reminded_target_buy_time")
    private Date remindedTargetBuyTime;
    /**
     * 目标卖出价
     */
    @TableField("target_sell_price")
    private Integer targetSellPrice;
    /**
     * 最近提醒目标卖出价
     */
    @TableField("reminded_target_sell_price")
    private Integer remindedTargetSellPrice;
    /**
     * 目标卖出价最近提醒时间
     */
    @TableField("reminded_target_sell_time")
    private Date remindedTargetSellTime;
    /**
     * 买入上涨初次提醒波动间隔
     */
    @TableField("buy_up_first_interval")
    private Integer buyUpFirstInterval;
    /**
     * 买入继续上涨提醒波动间隔
     */
    @TableField("buy_up_continue_interval")
    private Integer buyUpContinueInterval;
    /**
     * 买入下跌初次提醒波动间隔
     */
    @TableField("buy_down_first_interval")
    private Integer buyDownFirstInterval;
    /**
     * 买入继续下跌提醒波动间隔
     */
    @TableField("buy_down_continue_interval")
    private Integer buyDownContinueInterval;
    /**
     * 卖出下跌初次提醒波动间隔
     */
    @TableField("sell_up_first_interval")
    private Integer sellUpFirstInterval;
    /**
     * 卖出继续下跌提醒波动间隔
     */
    @TableField("sell_up_continue_interval")
    private Integer sellUpContinueInterval;
    /**
     * 个人备注
     */
    private String remark;
    /**
     * 是否清仓
     */
    @TableField("is_cleared")
    private Integer isCleared;
    /**
     * 清仓时间
     */
    @TableField("cleared_at")
    private Date clearedAt;
    /**
     * 总分红现金
     */
    @TableField("count_cash_dividends")
    private Integer countCashDividends;
    /**
     * 总送股
     */
    @TableField("count_stock_dividends")
    private Integer countStockDividends;
    /**
     * 总转增股
     */
    @TableField("count_stock_add")
    private Integer countStockAdd;
    /**
     * 成本价
     */
    @TableField("cost_price")
    private Integer costPrice;
    /**
     * 未售出每股均摊成本价
     */
    @TableField("average_price")
    private Integer averagePrice;
    /**
     * 网格间隔
     */
    @TableField("grid_interval")
    private Integer gridInterval;
    /**
     * 网格计划最低价
     */
    @TableField("grid_target_price")
    private BigDecimal gridTargetPrice;
    /**
     * 网格每笔加仓股数
     */
    @TableField("grid_number_per_order")
    private Integer gridNumberPerOrder;
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
