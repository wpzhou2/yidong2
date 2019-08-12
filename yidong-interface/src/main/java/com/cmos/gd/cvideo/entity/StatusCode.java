package com.cmos.gd.cvideo.entity;

import java.io.Serializable;

/**
 * 返回结果的状态码
 * @Author weipeng
 * @Date 2019/8/2 12:23
 */
public class StatusCode implements Serializable {

    public static final int OK = 20000; //成功
    public static final int ERROR = 20001; //失败
    public static final int LOGINERROR = 20002; //用户名或密码错误
    public static final int ACCESSERROR = 20003; //权限不足
    public static final int REMOTEERROR = 20004; //远程调用失败
    public static final int REPERROR = 20005; //重复操作

}
