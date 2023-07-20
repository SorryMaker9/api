package tech.cqxqg.youcai.user.dto.request;

import com.swak.frame.dto.base.Command;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户证券表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@Data
@ToString
public class UserCsBuysCommand extends Command implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 用户 ID
     */
    private Integer userId;
    /**
     * 用户中国证券公司 ID
     */

    private Integer userCsfId;
    /**
     * 证券代码
     */
    private String code;
    /**
     * 用户持有中国证券 ID
     */
    private Integer userCsId;
    /**
     * 买入时间
     */
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
    private Integer userCsfhId;
    /**
     * 总股票-过户费
     */
    private Integer fee1;
    /**
     * 总证券佣金
     */
    private Integer csfFee;
    /**
     * 成本价（加上手续费）
     */

    private Integer costPrice;
    /**
     * 是否锁仓 true:锁仓,false:解锁
     */
    private Integer isLocked;
    /**
     * 投资资金来源; 0-现金，1-场内融资，2-场外借贷
     */
    private Integer sourceInvestment;
    /**
     * 手动未售出数量
     */
    private Integer manualUnsoldNumber;
    /**
     * 手动未售出已产生利息
     */

    private Integer manualUnsoldInterests;
    /**
     * 利息计算更新时间
     */
    private Date interestComputedAt;
    /**
     * 售出状态; 0-未售出,1-全部售出,2-部分售出
     */

    private Integer sellStatus;
    /**
     * 售出描述
     */

    private String sellIntro;
    /**
     * 个人备注
     */
    private String remark;
    /**
     * 未售出股数
     */

    private Integer fifoUnsoldNumber;
    /**
     * 是否委托买入
     */

    private Integer isBuyEntrusted;
    /**
     * 是否委托卖出
     */

    private Integer isSellEntrusted;
    /**
     * 证券获得方式 0-正常买入,1-送股,2-转增股
     */
    private Integer from;
    /**
     * 创建时间
     */

    private Date createdAt;
    /**
     * 更新时间
     */

    private Date updatedAt;

}
