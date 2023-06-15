package com.firedance.gps.model.enums;

/**
 * 1天、3天、1个月、2个月、1年、3年
 * @author qi.tang
 */
public enum ExceptionEnum {
    A000001("A000001","挂载点不在支持列表中"),
    A000002("A000002","账户或密码错误"),
    A000003("A000003","账户不可用"),
    A000004("A000004","password has updated,please reacquire it"),
    ;

    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
