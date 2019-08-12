package com.cmos.gd.cvideo.service.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: weipeng
 * @Date: 2019/7/26  9:57
 * @Description:
 **/
@Controller
public class SystemOraganizationService {
    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:11
     * @Description:  组织架构--新增
     **/
    @RequestMapping(value = "/system/systemOraganizationService/add.do",method = RequestMethod.GET)
    public void addOraganization(){}
}
