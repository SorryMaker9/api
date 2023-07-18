package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.base.Command;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SecuritiesCommand extends Command {
    /**
     * 股票代码
     */
    private String code;
    /**
     * 证券首字母缩写
     */
    private String arcronym;
    /**
     * 交易所类型
     */
    private String exchangeType;
    /**
     * 0-股票,1-场内基金,2-国债,3-可转债 4-企业债,5逆回购
     */
    private Integer type;
    /**
     * 名称
     */
    private String name;
    /**
     * 上市时间
     */
    private Date listAt;
    /**
     * 人工判断优质否 true优质, false-不优质,默认false
     */

    private Integer byPeople;
    /**
     * 机器判断优质否 true优质, false-不优质,默认false
     */

    private Integer byRebot;
    /**
     * 雪球链接
     */

    private String xueqiuUrl;
    /**
     * 雪球关注数
     */

    private Integer xueqiuFollow;
    /**
     * 当前价格
     */
    private BigDecimal price;
    /**
     * 当前涨跌幅
     */
    private Double range;
    /**
     * 当前股息率
     */

    private Double dividendRate;
    /**
     * 年分红现金 每10股能分得的现金,单位为分
     */

    private Integer dividendCash;
    /**
     * 是否长期分红 true-每年分红,false分红不稳定,默认为true
     */

    private Integer isDividend;
    /**
     * 最新分红描述 取分红最新的一条记录 2019预/2019-6-6登记10转A送B派C
     */

    private String latestDividendDesc;
    /**
     * 市值
     */

    private String marketValue;
    /**
     * 当前股本数量
     */

    private Integer stockAmount;
    /**
     *  市盈率 存10.22,显示10.22%
     */
    private Double pe;
    /**
     * 市净率 存10.22,显示10.22%
     */
    private Double pb;
    /**
     * 动态市盈率 存10.22,显示10.22%
     */
    private Double ttm;
    /**
     * 净资产收益率 存10.22,显示10.22%
     */
    private Double roe;
    /**
     * 营收年增长率 存10.22,显示10.22%
     */

    private Double revenueYearGrowthRate;
    /**
     * 营收季度增长率 存10.22,显示10.22%
     */

    private Double revenueQuarterGrowthRate;
    /**
     * 利润年增长率 存10.22,显示10.22%
     */

    private Double profitYearGrowthRate;
    /**
     * 利润季度增长率 存10.22,显示10.22%
     */

    private Double profitQuarterGrowthRate;
    /**
     * 简介
     */
    private String intro;
    /**
     * 状态 0-正常 1-删除 2-禁用 3-退市
     */
    private Integer status;
    /**
     * 需要提醒的会员数
     */

    private Integer countReminders;
    /**
     * 标签IDs, 以|分隔
     */

    private String tagIds;
    /**
     * 退市 0-退市, 1-正常
     */

    private Integer isDelist;
    /**
     * 标签名称 以|分隔
     */

    private String cacheTags;
}
