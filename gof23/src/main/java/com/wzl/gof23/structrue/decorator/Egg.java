package com.wzl.gof23.structrue.decorator;

/**
 * 鸡蛋
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/6 8:48
 */
public class Egg extends Garnish {


    public Egg(Food food, Integer price, Integer count) {
        super(food, price, count);
        this.description = "鸡蛋";
    }

    @Override
    public String getCost() {
        System.out.println("desc : " + food.description + description + ", 价格: " + (Integer.parseInt(food.getCost()) + this.count * this.price));
        return String.valueOf(Integer.parseInt(food.getCost()) + this.count * this.price);
    }
}
