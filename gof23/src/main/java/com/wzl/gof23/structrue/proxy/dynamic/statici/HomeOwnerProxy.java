package com.wzl.gof23.structrue.proxy.dynamic.statici;

/**
 * 租房代理
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 9:26
 */
public class HomeOwnerProxy implements RentProxy {

    private HomeOwner homeOwner;

    @Override
    public void operationA() {
        System.out.println("中介操作A");
    }

    @Override
    public void operationB() {
        System.out.println("中介操作B");
    }

    @Override
    public void operationC() {
        System.out.println("中介操作C");
    }

    @Override
    public void operationD() {
        System.out.println("中介操作D");
    }

    @Override
    public void rent() {
        homeOwner.rent();
    }

    void setHomeowner(HomeOwner homeowner) {
        this.homeOwner = homeowner;
    }
}
