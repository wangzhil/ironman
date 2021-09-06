package com.wzl.gof23.structrue.decorator;

import lombok.Data;

/**
 * 超级食品接口
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/6 8:11
 */
@Data
public abstract class Food {

    public Food(Integer price, Integer count) {
        this.price = price;
        this.count = count;
    }

    Integer price;

    String description;

    Integer count;

    public abstract String getCost();
}
