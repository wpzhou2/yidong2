package com.cmos.gd.cvideo.entity;

import java.io.Serializable;

/**
 * @Author: weipeng
 * @Date: 2019/7/23  15:25
 * @Description:
 **/
public class Role  implements Serializable {
    private static final long serialVersionUID = 1L;

    //编码
    private String id;
    //权限编码
    private String authorityId;
    //资源编码
    private String resourceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
