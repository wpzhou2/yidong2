package com.cmos.gd.cvideo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: weipeng
 * @Date: 2019/7/23  15:25
 * @Description:
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    //账号
    private String username;
    //姓名
    private String nickname;
    //密码
    private String password;
    //性别
    private String sex;
    //组织架构编码
    private String groupId;
    //头像base64编码
    private String img;
    //手机号码
    private String phone;
    //电子邮箱
    private String email;
    //职位
    private String position;
    //是否有效
    private String active;
    //角色编号列表
    private String role;
    //登录错误次数
    private int errnum;

    //最新登录时间
    private Date logDate;

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getErrnum() {
        return errnum;
    }

    public void setErrnum(int errnum) {
        this.errnum = errnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", groupId='" + groupId + '\'' +
                ", img='" + img + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
