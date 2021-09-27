package com.wzl.share.proxy.statici;

/**
 * 房东
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 9:22
 */
public class HomeOwner implements Rent {

    @Override
    public void rent() {
        System.out.println("我是房东，我想要租房!");
    }
}
