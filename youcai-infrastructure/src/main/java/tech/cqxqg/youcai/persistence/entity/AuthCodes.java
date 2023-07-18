package tech.cqxqg.youcai.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 登录验证码表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("auth_codes")
public class AuthCodes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录验证码id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 类型 0-邮箱注册验证码 1-手机
     */
    private Integer type;
    /**
     * 随机数
     */
    private String code;
    /**
     * 用户IP
     */
    @TableField("user_ip")
    private String userIp;
    /**
     * 是否使用
     */
    @TableField("is_used")
    private Integer isUsed;
    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AuthCodes{" +
        ", id=" + id +
        ", userId=" + userId +
        ", type=" + type +
        ", code=" + code +
        ", userIp=" + userIp +
        ", isUsed=" + isUsed +
        ", createdAt=" + createdAt +
        "}";
    }
}
