package com.cmos.gd.cvideo.service.system;

import com.cmos.gd.cvideo.dao.SystemUserDao;
import com.cmos.gd.cvideo.entity.PageBean;
import com.cmos.gd.cvideo.entity.Result;
import com.cmos.gd.cvideo.entity.StatusCode;
import com.cmos.gd.cvideo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/7/26  9:44
 * @Description:
 **/
@Controller
public class SystemUserService {
    @Autowired
    SystemUserDao systemUserDao;

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:12
     * @Description:  系统用户管理
     **/
    @RequestMapping(value = "/system/test.html",method = RequestMethod.GET)
    public String test(){
        return "test";
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:12
     * @Description:  系统用户管理
     **/
    @RequestMapping(value = "/system/systemUserSearch.html",method = RequestMethod.GET)
    public String systemUserSearch(){
        return "systemUserSearch";
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:13
     * @Description:  查看系统用户信息
     **/
    @RequestMapping(value = "/system/systemUserShow.html",method = RequestMethod.GET)
    public String systemUserShow(){
        return "systemUserShow";
    }


    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:38
     * @Description: 系统用户--新增
     **/
    @ResponseBody
    @RequestMapping(value = "/system/systemUserService/add.do",method = RequestMethod.POST)
    public Result add(@RequestBody User user){
        System.out.println(user);
        int result = 0;
        if(isNewUsername(user.getUsername())){
            result = systemUserDao.addUser(user);
        }
        return new Result(true, StatusCode.OK,"添加用户成功");
    }

    //判断该账号是否是新的账号
    boolean isNewUsername(String username){
        return systemUserDao.isNewUsername(username);
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:40
     * @Description:  系统用户--删除
     **/
    @ResponseBody
    @RequestMapping(value = "/system/systemUserService/delete.do",method = RequestMethod.GET)
    public Result delete(String deleteUsername){
        int result = systemUserDao.deleteUser(deleteUsername);
        return new Result(true, StatusCode.OK,"删除用户成功");
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:55
     * @Description:  系统用户--修改,更新
     **/
    @ResponseBody
    @RequestMapping(value = "/system/systemUserService/update.do/{editUserename}",method = RequestMethod.POST)
    public Result update(@RequestBody User user, @PathVariable("editUserename") String editUsername){
        System.out.println(user);
        System.out.println(editUsername);
        int result = 0;
        if(isOkToUpdate(user.getUsername(),editUsername)){
            result = systemUserDao.updateUser(user,editUsername);
            return new Result(true, StatusCode.OK,"更新用户成功");
        }else{
            return new Result(false, StatusCode.ERROR,"更新用户失败，可能是账号名重复");
        }

    }

    //是否可以更新账号
    boolean isOkToUpdate(String username,String editUsername){
        //账号名没有修改，可以
        if(username.equals(editUsername)){
            return true;
        } else if(isNewUsername(username)){
            //账号名没有重复，可以
            return true;
        } else{
            return false;
        }
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:56
     * @Description:  系统用户--不分页查询
     **/
    @RequestMapping(value = "/system/systemUserService/find.do",method = RequestMethod.POST)
    @ResponseBody
    public Result find(@RequestBody User user){
        String nickname = user.getNickname();
        String username = user.getUsername();

        List<User> users = systemUserDao.findUserByUsernameOrNickname(username, nickname);
        return new Result(true, StatusCode.OK,"更新用户成功",users);
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:56
     * @Description:  系统用户--分页查询
     **/
    @RequestMapping(value = "/system/systemUserService/search.do/{currentPage}/{size}",method = RequestMethod.POST)
    @ResponseBody
    public Result search(@RequestBody User user,
                         @PathVariable("currentPage") int currentPage,
                         @PathVariable("size") int size){
        String username = user.getUsername();
        String nickname = user.getNickname();

        int totalCount = systemUserDao.findUserTotalcount(username,nickname);
        int totalPage = totalCount % size == 0 ? totalCount / size : (totalCount / size) + 1;
        int start = (currentPage - 1) * size;

        List<User> users = systemUserDao.searchUserByUsernameOrNicknameByPage(username, nickname,start,size);

        PageBean<User> mypage = new PageBean<User>();
        mypage.setTotalCount(totalCount);
        mypage.setTotalPage(totalPage);
        mypage.setCurrentPage(currentPage);
        mypage.setPageSize(size);
        mypage.setList(users);

        return new Result(true, StatusCode.OK,"分页查询用户成功",mypage);
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:56
     * @Description:  系统用户--获取
     **/
    @RequestMapping(value = "/system/systemUserService/get.do",method = RequestMethod.POST)
    public List<User> get(){
        return null;
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:57
     * @Description:  系统用户--是否存在
     **/
    @RequestMapping(value = "/system/systemUserService/isExist.do",method = RequestMethod.GET)
    public boolean isExist(){
        return false;
    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:58
     * @Description:  系统用户--清空
     **/
    @RequestMapping(value = "/system/systemUserService/clear.do",method = RequestMethod.GET)
    public void clear(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 15:59
     * @Description:  系统用户--重置
     **/
    @RequestMapping(value = "/system/systemUserService/reset.do",method = RequestMethod.GET)
    public void reset(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:00
     * @Description:  系统用户--解锁账号
     **/
    @RequestMapping(value = "/system/systemUserService/unlock.do",method = RequestMethod.GET)
    public void unlock(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:01
     * @Description:  系统用户--激活账号
     **/
    @RequestMapping(value = "/system/systemUserService/active.do",method = RequestMethod.GET)
    public void active(){

    }


    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:01
     * @Description:  系统用户--禁用账号
     **/
    @RequestMapping(value = "/system/systemUserService/unactive.do",method = RequestMethod.GET)
    public void unactive(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:02
     * @Description:  系统用户--重置默认密码
     **/
    @RequestMapping(value = "/system/systemUserService/resetDefaultPwd.do",method = RequestMethod.GET)
    public void resetDefaultPwd(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:08
     * @Description:  系统用户--重置密码
     **/
    @RequestMapping(value = "/system/systemUserService/resetPwd.do",method = RequestMethod.GET)
    public void resetPwd(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:08
     * @Description:  系统用户--修改密码
     **/
    @RequestMapping(value = "/system/systemUserService/changePwd.do",method = RequestMethod.GET)
    public void changePwd(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:09
     * @Description:  系统用户--设置头像
     **/
    @RequestMapping(value = "/system/systemUserService/setImg.do",method = RequestMethod.GET)
    public void setImg(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:10
     * @Description:  系统用户--设置权限列表，以英文逗号分开
     **/
    @RequestMapping(value = "/system/systemUserService/setRole.do",method = RequestMethod.GET)
    public void setRole(){

    }

    /**
     * @Author: weipeng
     * @Date: 2019/7/25 16:10
     * @Description:  系统用户--根据座席工号获取映射的系统用户对象
     **/
    @RequestMapping(value = "/system/systemUserService/getByAgentid.do",method = RequestMethod.GET)
    public void getByAgentid(){

    }


}
