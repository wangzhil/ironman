package com.wzl.share.proxy.statici;

/**
 * 静态方法测试
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/26 11:20
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        final LogProxy logProxy = new LogProxy().setRentProxy(new HomeOwnerProxy());
        logProxy.operationA();
        logProxy.operationB();
        logProxy.operationC();
        logProxy.operationD();

    }
}
