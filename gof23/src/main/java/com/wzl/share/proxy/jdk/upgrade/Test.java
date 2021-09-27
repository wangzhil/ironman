package com.wzl.share.proxy.jdk.upgrade;

import com.wzl.share.proxy.statici.HomeOwner;
import com.wzl.share.proxy.statici.Rent;

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
