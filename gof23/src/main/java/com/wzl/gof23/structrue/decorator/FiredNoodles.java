package com.wzl.gof23.structrue.decorator;

/**
 * 炒面
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/6 9:02
 */
public class FiredNoodles extends Food {

    public FiredNoodles(Integer price, Integer count) {
        super(price, count);
        this.description = "炒面";
    }

    @Override
    public String getCost() {
        System.out.println("desc: "+ description + ", 价格: " + count * price);
        return String.valueOf(count * price);
    }
}
