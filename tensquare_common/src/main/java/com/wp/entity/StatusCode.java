package com.wp.entity;

/**
 * @author: wp
 * @Title: StatusCode
 * @Description: TODO
 * @date 2019/12/3 21:16
 */
public enum StatusCode {
    OK(2000,"成功"),
    ERROR(2001,"响应失败"),
    LOGINERROR(2002,"登陆失败"),
    ACCESSERROR(2003,"权限不足"),
    REMOTEERROR(2004,"远程调用失败"),
    REPERROR(2005,"重复操作");

    private Integer status;
    private String text;

    //构造方法
    StatusCode(Integer status,String text ){
        this.status = status;
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }
}
