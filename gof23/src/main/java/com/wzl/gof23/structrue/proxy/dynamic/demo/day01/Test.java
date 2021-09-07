package com.wzl.gof23.structrue.proxy.dynamic.demo.day01;

import com.wzl.gof23.structrue.proxy.dynamic.HomeOwner;
import com.wzl.gof23.structrue.proxy.dynamic.Rent;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/7 8:07
 */
public class Test {

    public static void main(String[] args) {
        Rent rentProxy = (Rent) new RentProxy(new HomeOwner()).getRentProxy(new HomeOwner());
        rentProxy.rent();
    }
}
