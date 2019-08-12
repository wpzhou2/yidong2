package com.cmos.gd.cvideo.entity;

import java.io.Serializable;

/**
 * @Author: weipeng
 * @Date: 2019/7/23  15:25
 * @Description:
 **/
public class Organization  implements Serializable {
    private static final long serialVersionUID = 1L;

    //组织编码
    private String id;
    //上级组织编码
    private String pid;
    //组织名称
    private String title;
    //组织说明
    private String descn;
    //排列序号
    private int order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
