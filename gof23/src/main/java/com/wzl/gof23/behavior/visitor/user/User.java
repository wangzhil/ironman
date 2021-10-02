package com.wzl.gof23.behavior.visitor.user;

import com.wzl.gof23.behavior.visitor.visitor.Visitor;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 13:25
 */
public abstract class User {

    public String name;      // 姓名
    public String identity;  // 身份；重点班、普通班 | 特级教师、普通教师、实习教师
    public String clazz;     // 班级

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    public abstract void accept(Visitor visitor);
}
