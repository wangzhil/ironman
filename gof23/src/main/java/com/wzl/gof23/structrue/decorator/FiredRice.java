package com.wzl.gof23.structrue.decorator;

/**
 * 炒饭
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/6 8:09
 */
public class FiredRice extends Food {


    public FiredRice(Integer price, Integer count) {
        super(price, count);
        this.description = "炒饭";
    }

    @Override
    public String getCost() {
        System.out.println("desc: " + description + ", 价格: "+ price * count);
        return String.valueOf(count * price);
    }
}
