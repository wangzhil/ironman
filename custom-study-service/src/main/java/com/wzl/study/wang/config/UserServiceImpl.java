package com.wzl.study.wang.config;

import com.wzl.study.spring.Autowired;
import com.wzl.study.spring.BeanNameAware;
import com.wzl.study.spring.Component;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/28 7:57
 */
@Component(value = "userService")
public class UserServiceImpl implements UserService, BeanNameAware {

    @Autowired(require = "orderService")
    private OrderService orderService;

    private String beanName;


    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void test() {
        System.out.println(orderService);
    }


}
