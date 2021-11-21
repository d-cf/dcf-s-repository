package com.example.demo.pojo;

public enum ResultCode {
    //"成功"
    SUCCESS(20000),
    /* 参数错误 */
    PARAM_IS_INVALID(1001),
    PARAM_IS_BLANK(1002),
    PARAM_TYPE_BIND_ERROR(1003),
    PARAM_NOT_COMPLETE(1004),
    /* 用户名不存在 2001-2999*/
    USER_NOTLOGGED_IN(2001),
    //密码错误
    USER_LOGIN_ERROR(2002),
    //系统异常，请稍后重试
    SYSTEM_ERROR(10000);

    private Integer code;

    private ResultCode(Integer code) {
        this.code = code;
    }

    public Integer code() {
        return this.code;
    }
}
