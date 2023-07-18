package tech.cqxqg.youcai.user.constants;

import com.swak.frame.enums.IResultCode;

public enum StockResultCode implements IResultCode {

    USER_NOT_LOGIN(2001, "用户当前未登录"),
    FIRM_EXIST(2002, "当前证券公司已存在"),
    FIRM_NOT_EXIST(2003, "当前证券公司不存在"),
    USER_FIRM_EXIST(2004, "用户证券公司记录已存在"),
    USER_AND_FIRM_NO_ACCORD(2005, "当前用户与当前用户证券公司不符"),
    OPERATION_ABNORMAL(2222, "操作异常");

    private Integer code;
    private String msg;

    private StockResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
