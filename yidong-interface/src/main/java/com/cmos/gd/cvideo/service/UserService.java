package com.cmos.gd.cvideo.service;

import com.cmos.gd.cvideo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: weipeng
 * @Date: 2019/7/25  15:37
 * @Description:
 **/
public interface UserService {
    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:38
     * @Description: 系统用户--新增
     **/
    public User add();


    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:40
     * @Description:  系统用户--删除
     **/
    public int delete();
}
