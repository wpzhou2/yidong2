package com.cmos.gd.cvideo.entity;

import java.io.Serializable;

/**
 * @Author: weipeng
 * @Date: 2019/7/23  15:25
 * @Description:
 **/
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;

    //资源编码
    private String id;
    //上级资源编码
    private String pid;
    //资源类型
    private String type;
    //资源名称
    private String title;
    //是否叶节点
    private String leaf;
    //资源地址
    private String url;
    //资源图标
    private String icon;
    //资源序号
    private int order;
    //资源是否有效
    private String active;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
