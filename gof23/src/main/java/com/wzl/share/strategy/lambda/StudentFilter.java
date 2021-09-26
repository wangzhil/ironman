package com.wzl.share.strategy.lambda;

/**
 * 学生过滤接口
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/24 8:14
 */
public interface StudentFilter {


    /**
     * 过滤器
     *
     * @param student 学生
     * @return boolean
     */
    boolean filter(Student student);
}
