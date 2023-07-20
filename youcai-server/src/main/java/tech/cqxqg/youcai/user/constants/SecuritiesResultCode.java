package tech.cqxqg.youcai.user.constants;

import com.swak.frame.enums.IResultCode;

public enum  SecuritiesResultCode implements IResultCode {

    SECURITIES_NOT_FOUND(1401,"证券不存在"),
    SECURITIES_EXIST(1401,"证券已存在"),
    ;
    private Integer code;
    private String msg;

    SecuritiesResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
