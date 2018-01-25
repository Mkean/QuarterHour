package com.bwie.quarterhour.bean;

import java.io.Serializable;

/**
 * 作者：王庆
 * 时间：2018/1/23
 */

public class RegisterBean implements Serializable {

    /**
     * msg : 注册成功
     * code : 0
     */

    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
