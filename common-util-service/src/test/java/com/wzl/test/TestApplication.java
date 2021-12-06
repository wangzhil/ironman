package com.wzl.test;

import com.wzl.common.CommonUtilServiceApplication;
import com.wzl.common.util.redis.RedisOperations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/5 21:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonUtilServiceApplication.class)
public class TestApplication {

    @Resource
    private RedisOperations redisOperations;

    @Test
    public void getTest() {
//        redisOperations.set("test:2222222", "2222222");
        final String s = redisOperations.get("test:111111");
        System.out.println(s);
    }
}
