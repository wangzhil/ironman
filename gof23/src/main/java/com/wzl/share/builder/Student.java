package com.wzl.share.builder;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 打农药的小学生
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 19:57
 */
@Data
@Builder
public class Student {
    private String name;
    private Integer age;
    private BigDecimal salary;
}
