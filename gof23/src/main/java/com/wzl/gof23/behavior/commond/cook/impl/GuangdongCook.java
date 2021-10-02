package com.wzl.gof23.behavior.commond.cook.impl;

import com.wzl.gof23.behavior.commond.cook.ICook;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/1 17:02
 */
public class GuangdongCook implements ICook {
    @Override
    public void cook() {
        System.out.println("广东菜!甜!");
    }
}
