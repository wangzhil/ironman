package com.wzl.gof23.structrue.decorator;

/**
 * 辅食
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/6 8:42
 */
public abstract class Garnish extends Food {

    Food food;

    public Garnish(Integer price, Integer count) {
        super(price, count);
    }

    public Garnish(Food food, Integer price, Integer count) {
        super(price, count);
        this.food = food;
    }

}
