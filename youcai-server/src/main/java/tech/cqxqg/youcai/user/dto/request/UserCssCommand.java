package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.base.Command;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 证券信息表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@Data
@ToString
public class UserCssCommand extends Command{

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 用户 ID
     */
    private Integer userId;
    /**
     * 0-股票,1-场内基金,2-国债
     */
    private Integer type;
    /**
     * 证券名称
     */
    private String name;
    /**
     * 证券代码
     */
    private String code;
    /**
     * 持仓比例
     */
    private Integer positionRatio;
    /**
     * 市值
     */
    private Integer marketValue;
    /**
     * 投入总资金量
     */
    private Integer investedAll;
    /**
     * 投入现金
     */
    private Integer investedCash;
    /**
     * 投入融资
     */
    private Integer investedFinancing;
    /**
     * 投入借贷
     */
    private Integer investedLoans;
    /**
     * 持有总数量
     */
    private Integer holdings;
    /**
     * 目标持有总数量
     */
    private Integer targetHoldings;
    /**
     * 锁仓购买股数
     */
    private Integer lockedBuyNumber;
    /**
     * 未锁仓最低买入价格
     */
    private Integer lowestUnlockedBuyPrice;
    /**
     * 未锁仓最低买入记录 ID
     */
    private Integer lowestUnlockedBuyId;
    /**
     * 最近提醒买入价
     */
    private Integer remindedBuyPrice;
    /**
     * 最近提醒买入波动
     */
    private Integer remindedBuyFluctuation;
    /**
     * 买入最近提醒时间
     */
    private Date remindedBuyTime;
    /**
     * 0-最高卖出价，1-最近卖出价
     */
    private Integer sellReferType;
    /**
     * 最近提醒卖出价
     */
    private Integer remindedSellPrice;
    /**
     * 最近提醒卖出波动
     */
    private Integer remindedSellFluctuation;
    /**
     * 卖出最近提醒时间
     */
    private Date remindedSellTime;
    /**
     * 目标买入价
     */
    private Integer targetBuyPrice;
    /**
     * 最近提醒目标买入价
     */
    private Integer remindedTargetBuyPrice;
    /**
     * 目标买入价最近提醒时间
     */
    private Date remindedTargetBuyTime;
    /**
     * 目标卖出价
     */
    private Integer targetSellPrice;
    /**
     * 最近提醒目标卖出价
     */
    private Integer remindedTargetSellPrice;
    /**
     * 目标卖出价最近提醒时间
     */
    private Date remindedTargetSellTime;
    /**
     * 买入上涨初次提醒波动间隔
     */
    private Integer buyUpFirstInterval;
    /**
     * 买入继续上涨提醒波动间隔
     */
    private Integer buyUpContinueInterval;
    /**
     * 买入下跌初次提醒波动间隔
     */
    private Integer buyDownFirstInterval;
    /**
     * 买入继续下跌提醒波动间隔
     */
    private Integer buyDownContinueInterval;
    /**
     * 卖出下跌初次提醒波动间隔
     */
    private Integer sellUpFirstInterval;
    /**
     * 卖出继续下跌提醒波动间隔
     */
    private Integer sellUpContinueInterval;
    /**
     * 个人备注
     */
    private String remark;
    /**
     * 是否清仓
     */
    private Integer isCleared;
    /**
     * 清仓时间
     */
    private Date clearedAt;
    /**
     * 总分红现金
     */
    private Integer countCashDividends;
    /**
     * 总送股
     */
    private Integer countStockDividends;
    /**
     * 总转增股
     */
    private Integer countStockAdd;
    /**
     * 成本价
     */
    private Integer costPrice;
    /**
     * 未售出每股均摊成本价
     */
    private Integer averagePrice;
    /**
     * 网格间隔
     */
    private Integer gridInterval;
    /**
     * 网格计划最低价
     */
    private BigDecimal gridTargetPrice;
    /**
     * 网格每笔加仓股数
     */
    private Integer gridNumberPerOrder;


}
