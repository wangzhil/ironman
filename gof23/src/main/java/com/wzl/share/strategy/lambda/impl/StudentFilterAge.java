package com.wzl.share.strategy.lambda.impl;

import com.wzl.share.strategy.lambda.Student;
import com.wzl.share.strategy.lambda.StudentFilter;

/**
 * 年龄过滤实现
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 8:16
 */
public class StudentFilterAge implements StudentFilter {


    @Override
    public boolean filter(Student student) {
        return student.getAge() > 20;
    }
}
