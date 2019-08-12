package com.cmos.gd.cvideo.entity;

import java.io.Serializable;

/**
 * @Author: weipeng
 * @Date: 2019/7/23  15:25
 * @Description:
 **/
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;

    //编码
    private String id;
    //权限名称
    private String title;
    //权限说明
    private String descn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
