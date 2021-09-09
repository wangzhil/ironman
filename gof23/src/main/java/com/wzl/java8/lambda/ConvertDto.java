package com.wzl.java8.lambda;

import lombok.Data;

import java.util.Map;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/9 9:03
 */
@Data
public class ConvertDto {

    private String name;

    private String age;

    private Double salary;

    private Object[] arr;

    private Map<String, String> map;
}
