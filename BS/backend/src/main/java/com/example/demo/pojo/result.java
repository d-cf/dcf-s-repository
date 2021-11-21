package com.example.demo.pojo;

import com.example.demo.model.User;
import java.io.Serializable;

//public class Re1 implements Serializable {
//    private static final long serialVersionUID = 1L;
//    private Integer code;
//    private Object data;
//
//    private R() {
//
//    }
//
//    public R(ResultCode resultCode, Object data) {
//        this.code = resultCode.code();
//        this.data = data;
//    }
//
//    private void setResultCode(ResultCode resultCode) {
//        this.code = resultCode.code();
//    }
//
//    // 返回成功
//    public static R success() {
//        R result = new R();
//        result.setResultCode(ResultCode.SUCCESS);
//        return result;
//    }
//
//    // 返回成功
//    public static R success(Object data) {
//        R result = new R();
//        result.setResultCode(ResultCode.SUCCESS);
//        result.setData(data);
//        return result;
//    }
//
//    // 返回失败
//    public static R fail(Integer code) {
//        R result = new R();
//        return result;
//    }
//
//    // 返回失败
//    public static R fail(ResultCode resultCode) {
//        R result = new R();
//        result.setResultCode(resultCode);
//        return result;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//
//
//
//}
public class result{
    private String code;
    private User data;

    public result() {

    }

    public result(String code, User user) {
        this.code = code;
        this.data = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getData() {
        return data;
    }

    public void setData(User user) {
        this.data = user;
    }
}