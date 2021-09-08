package com.wzl.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 14:18
 */
public class LambdaTest {

    public static void main(String[] args) {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = integers.stream()
                .map(e -> {
                    e = e + 1;
                    return e;
                }).collect(Collectors.toList());

        List<Integer> collect1 = integers.stream()
                .peek(e -> e = e + 1
                ).collect(Collectors.toList());

        collect.stream().forEach(System.out::println);
        collect1.stream().forEach(System.out::println);
    }
}
