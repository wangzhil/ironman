package com.wzl.gof23.structrue.proxy.dynamic.statici;

/**
 * 日志代理
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/2 9:35
 */
public class LogProxy implements RentProxy {
    private RentProxy rentProxy;

    @Override
    public void operationA() {
        this.log();
        rentProxy.operationA();
    }

    @Override
    public void operationB() {
        this.log();
        rentProxy.operationB();
    }

    @Override
    public void operationC() {
        this.log();
        rentProxy.operationC();
    }

    @Override
    public void operationD() {
        this.log();
        rentProxy.operationD();
    }

    @Override
    public void rent() {
        this.log();
        rentProxy.rent();
    }

    public void setRentProxy(RentProxy rentProxy) {
        this.rentProxy = rentProxy;
    }

    void log() {
        System.out.println("我要在所有方法前加日志.");
    }
}
