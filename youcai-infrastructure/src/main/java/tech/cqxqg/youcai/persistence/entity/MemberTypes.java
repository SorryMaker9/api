package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 会员类型表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("member_types")
public class MemberTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员类型id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 可读名称
     */
    @TableField("readable_name")
    private String readableName;
    /**
     * 每日手动刷新次数
     */
    @TableField("manual_refresh_number")
    private Integer manualRefreshNumber;
    /**
     * 市场行情刷新间隔
     */
    @TableField("market_update_interval")
    private Integer marketUpdateInterval;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReadableName() {
        return readableName;
    }

    public void setReadableName(String readableName) {
        this.readableName = readableName;
    }

    public Integer getManualRefreshNumber() {
        return manualRefreshNumber;
    }

    public void setManualRefreshNumber(Integer manualRefreshNumber) {
        this.manualRefreshNumber = manualRefreshNumber;
    }

    public Integer getMarketUpdateInterval() {
        return marketUpdateInterval;
    }

    public void setMarketUpdateInterval(Integer marketUpdateInterval) {
        this.marketUpdateInterval = marketUpdateInterval;
    }

    @Override
    public String toString() {
        return "MemberTypes{" +
        ", id=" + id +
        ", name=" + name +
        ", readableName=" + readableName +
        ", manualRefreshNumber=" + manualRefreshNumber +
        ", marketUpdateInterval=" + marketUpdateInterval +
        "}";
    }
}
