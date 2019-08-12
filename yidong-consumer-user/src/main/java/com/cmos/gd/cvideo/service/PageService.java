package com.cmos.gd.cvideo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: weipeng
 * @Date: 2019/7/26  10:17
 * @Description:
 **/
public class PageService {



    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:13
     * @Description:  首页
     **/
    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public String index(){
        return "index";
    }



}
