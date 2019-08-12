package com.cmos.gd.cvideo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: weipeng
 * @Date: 2019/7/23  15:25
 * @Description:
 **/
public class Log  implements Serializable {
    private static final long serialVersionUID = 1L;

    //自动编码
    private long id;
    //类型
    private String type;
    //package
    private String pkg;
    //方法
    private String way;
    //post/get请求
    private String med;
    //请求地址
    private String url;
    //源ip
    private String ip;
    //请求协议
    private String protocol;
    //当前用户session
    private String session;
    //记录时间
    private Timestamp logdate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Timestamp getLogdate() {
        return logdate;
    }

    public void setLogdate(Timestamp logdate) {
        this.logdate = logdate;
    }
}
