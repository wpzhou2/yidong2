package com.cmos.gd.cvideo.dao;

import com.cmos.gd.cvideo.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/7/29  14:36
 * @Description:
 **/
@Repository
public class SystemUserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //不分页查询用户
    public List<User> findUserByUsernameOrNickname(String username, String nickname){
        String sql = "";
        //如果账号和姓名都为空，返回空列表
        if(StringUtils.isEmpty(username) && StringUtils.isEmpty(nickname)){
            return new ArrayList<User>();
        }
        else if(!StringUtils.isEmpty(username) && StringUtils.isEmpty(nickname)){
            sql = "select * from system_user where s_username like '%"+username+"%'";
        }
        else if(StringUtils.isEmpty(username) && !StringUtils.isEmpty(nickname)){
            sql = "select * from system_user where s_nickname like '%"+nickname+"%'";
        }else{
            sql = "select * from system_user where s_username like '%"+username+"%' or s_nickname like '%"+nickname+"%'";
        }

        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setPhone(rs.getString("s_phone"));
                user.setUsername(rs.getString("s_username"));
                user.setNickname(rs.getString("s_nickname"));
                user.setEmail(rs.getString("s_email"));
                user.setGroupId(rs.getString("s_group_id"));
                user.setPosition(rs.getString("s_position"));
                user.setSex(rs.getString("s_sex"));
                user.setImg(rs.getString("s_img"));
                user.setActive(rs.getString("s_active"));
                user.setErrnum(rs.getInt("s_errnum"));
                user.setRole(rs.getString("s_role"));
                return user;
            }
        });
        return users;
    }

    //分页查询用户
    public List<User> searchUserByUsernameOrNicknameByPage(String username, String nickname
                                ,int start, int size){
        String sql = "";
        //如果账号和姓名都为空，返回空列表
        if(StringUtils.isEmpty(username) && StringUtils.isEmpty(nickname)){
            return new ArrayList<User>();
        }
        else if(!StringUtils.isEmpty(username) && StringUtils.isEmpty(nickname)){
            sql = "select * from system_user where s_username like '%"+username+"%'";
        }
        else if(StringUtils.isEmpty(username) && !StringUtils.isEmpty(nickname)){
            sql = "select * from system_user where s_nickname like '%"+nickname+"%'";
        }else{
            sql = "select * from system_user where s_username like '%"+username+"%' or s_nickname like '%"+nickname+"%'";
        }

        sql += " limit "+size+" offset "+start;
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setPhone(rs.getString("s_phone"));
                user.setUsername(rs.getString("s_username"));
                user.setNickname(rs.getString("s_nickname"));
                user.setEmail(rs.getString("s_email"));
                user.setGroupId(rs.getString("s_group_id"));
                user.setPosition(rs.getString("s_position"));
                user.setSex(rs.getString("s_sex"));
                user.setImg(rs.getString("s_img"));
                user.setActive(rs.getString("s_active"));
                user.setErrnum(rs.getInt("s_errnum"));
                user.setRole(rs.getString("s_role"));
                user.setLogDate(rs.getTimestamp("s_logdate"));
                return user;
            }
        });
        return users;
    }

    public int updateUser(User user,String editUsername) {
        System.out.println("editUsername:"+editUsername);
        String sql = "update system_user set s_username=?,s_nickname=?,s_sex=?,s_group_id=?," +
                "s_phone=?,s_email=?,s_position=?,s_role=?,s_active=? where s_username=?";

        int result = jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getNickname(),
                user.getSex(),user.getGroupId(),user.getPhone(),
                user.getEmail(),user.getPosition(),user.getRole(),
                user.getActive(),editUsername});

        return result;
    }

    public int deleteUser(String deleteUsername) {
        String sql = "delete from system_user where s_username = ?";
        int result = jdbcTemplate.update(sql, deleteUsername);
        return result;
    }

    public int addUser(User user) {
        String sql = "insert into system_user (s_username,s_nickname,s_sex,s_group_id,s_phone,s_email,s_position,s_role,s_active,s_password,s_img,s_errnum,s_logdate) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getNickname(),user.getSex(),user.getGroupId(),user.getPhone(),
                user.getEmail(),user.getPosition(),user.getRole(),user.getActive(),user.getPassword(),"",0,new Date()});

        return result;

    }

    //判断该账号是否是新的账号
    public boolean isNewUsername(String username) {
        String sql = "select count(*) from system_user where s_username = '"+username+"'";
        int count=0;
        try {
            count = jdbcTemplate.queryForObject(sql,Integer.class);
            if(count == 0){
                return true;
            }else{
                //数据库已有该账号，返回false
                return false;
            }
        } catch (Exception e) {
            //查不到数据，故为新账号，返回true
            return true;
        }
    }

    //返回查询的用户列表的总数目
    public int findUserTotalcount(String username, String nickname) {
        String sql = "";
        //如果账号和姓名都为空，返回0
        if(StringUtils.isEmpty(username) && StringUtils.isEmpty(nickname)){
            return 0;
        }
        else if(!StringUtils.isEmpty(username) && StringUtils.isEmpty(nickname)){
            sql = "select count(*) from system_user where s_username like '%"+username+"%'";
        }
        else if(StringUtils.isEmpty(username) && !StringUtils.isEmpty(nickname)){
            sql = "select count(*) from system_user where s_nickname like '%"+nickname+"%'";
        }else{
            sql = "select count(*) from system_user where s_username like '%"+username+"%' or s_nickname like '%"+nickname+"%'";
        }

        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }
}
