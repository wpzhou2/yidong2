package com.cmos.gd.cvideo.controller;

import com.cmos.gd.cvideo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/7/23  15:18
 * @Description:
 **/
public class UserController {
    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:38
     * @Description: 系统用户--新增
     **/
    @RequestMapping("/system/systemUserService/add.do")
    public User add(){
        return null;
    }


    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:40
     * @Description:  系统用户--删除
     **/
    @RequestMapping("/system/systemUserService/delete.do")
    public int delete(){
        return 1;
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:55
     * @Description:  系统用户--修改
     **/
    @RequestMapping("/system/systemUserService/update.do")
    public User update(){
        return null;
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 15:56
     * @Description:  系统用户--查询
     **/
    @RequestMapping("/system/systemUserService/search.do")
    public List<User> search(){
        return null;
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:56
     * @Description:  系统用户--获取
     **/
    @RequestMapping("/system/systemUserService/get.do")
    public List<User> get(){
        return null;
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:57
     * @Description:  系统用户--是否存在
     **/
    @RequestMapping("/system/systemUserService/isExist.do")
    public boolean isExist(){
        return false;
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 15:58
     * @Description:  系统用户--清空
     **/
    @RequestMapping("/system/systemUserService/clear.do")
    public void clear(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 15:59
     * @Description:  系统用户--重置
     **/
    @RequestMapping("/system/systemUserService/reset.do")
    public void reset(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 15:59
     * @Description:  系统用户--不分页查询
     **/
    @RequestMapping("/system/systemUserService/find.do")
    public void find(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 16:00
     * @Description:  系统用户--解锁账号
     **/
    @RequestMapping("/system/systemUserService/unlock.do")
    public void unlock(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:01
     * @Description:  系统用户--激活账号
     **/
    @RequestMapping("/system/systemUserService/active.do")
    public void active(){
        
    }
    
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 16:01
     * @Description:  系统用户--禁用账号
     **/
    @RequestMapping("/system/systemUserService/unactive.do")
    public void unactive(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:02
     * @Description:  系统用户--重置默认密码
     **/
    @RequestMapping("/system/systemUserService/resetDefaultPwd.do")
    public void resetDefaultPwd(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 16:08
     * @Description:  系统用户--重置密码
     **/
    @RequestMapping("/system/systemUserService/resetPwd.do")
    public void resetPwd(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 16:08
     * @Description:  系统用户--修改密码
     **/
    @RequestMapping("/system/systemUserService/changePwd.do")
    public void changePwd(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 16:09
     * @Description:  系统用户--设置头像
     **/
    @RequestMapping("/system/systemUserService/setImg.do")
    public void setImg(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 16:10
     * @Description:  系统用户--设置权限列表，以英文逗号分开
     **/
    @RequestMapping("/system/systemUserService/setRole.do")
    public void setRole(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:10
     * @Description:  系统用户--根据座席工号获取映射的系统用户对象
     **/
    @RequestMapping("/system/systemUserService/getByAgentid.do")
    public void getByAgentid(){
        
    }
    
    /** 
     * @Author: weipeng 
     * @Date: 2019/7/25 16:11
     * @Description:  组织架构--新增
     **/
    @RequestMapping("/system/systemOraganizationService/add.do")
    public void addOraganization(){}

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:12
     * @Description:  系统用户管理
     **/
    @RequestMapping("/system/systemUserSearch.html")
    public void systemUserSearch(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:13
     * @Description:  首页
     **/
    @RequestMapping("/index.html")
    public void index(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:13
     * @Description:  查看系统用户信息
     **/
    @RequestMapping("/system/systemUserShow.html")
    public void systemUserShow(){

    }
}
