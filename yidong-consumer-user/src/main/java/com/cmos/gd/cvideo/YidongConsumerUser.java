package com.cmos.gd.cvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author: weipeng
 * @Date: 2019/7/24  11:44
 * @Description:
 **/
@SpringBootApplication
//@EnableRedisHttpSession
public class YidongConsumerUser {
    public static void main(String[] args) {
        SpringApplication.run(YidongConsumerUser.class,args);
    }
}
