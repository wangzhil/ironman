package com.wzl.gof23.behavior.visitor.user.impl;

import com.wzl.gof23.behavior.visitor.user.User;
import com.wzl.gof23.behavior.visitor.visitor.Visitor;

/**
 * 学生
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 13:22
 */
public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
