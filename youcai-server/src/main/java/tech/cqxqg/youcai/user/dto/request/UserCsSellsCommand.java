package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.base.Command;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserCsSellsCommand extends Command {
    /**
     * 卖出记录id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户中国证券ID
     */
    private Integer userCsfId;

    /**
     * 证券代码
     */
    private String code;

    /**
     * 用户持有中国证券ID
     */
    private Integer userCsId;

    /**
     * 卖出时间
     */
    private Date soldAt;

    /**
     * 卖出价格
     */
    private Integer price;

    /**
     * 卖出数量
     */
    private Integer number;

    /**
     * 用户证券公司历史费率
     */
    private Integer userCsfhId;

    /**
     * 总股票—过户费
     */
    private Integer fee1;

    /**
     * 总股票-印花税
     */
    private Integer fee2;

    /**
     * 总证券佣金
     */
    private Integer csfFee;

    /**
     * 总已结算红利税
     */
    private Integer dividendFee;

    /**
     * 总已结算利息
     */
    private Integer interests;

    /**
     * 利润
     */
    private Integer profit;

    /**
     * 获利比
     */
    private BigDecimal profitRate;

    /**
     * 持有天数
     */
    private Integer holdingDays;

    /**
     * 日获利年化比
     */
    private BigDecimal dailyRate;

    /**
     * 是否做买入参考
     */
    private Boolean isRefered;

    /**
     * 个人备注
     */
    private String remark;

    /**
     * 是否委托买入
     */
    private Boolean isBuyEntrusted;
}
