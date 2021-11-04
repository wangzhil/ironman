package com.wzl.study.newspring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 扫描注解
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/11/1 8:34
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScan {

    String value();
}
