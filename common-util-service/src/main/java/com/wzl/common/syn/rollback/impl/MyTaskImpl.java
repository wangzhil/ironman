package com.wzl.common.syn.rollback.impl;

import com.wzl.common.syn.rollback.MyTask;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/25 8:48
 */
public class MyTaskImpl extends MyTask {

    public MyTaskImpl(String name, Integer timeSeconds, boolean successFlag) {
        super(name, timeSeconds, successFlag);
    }

    @Override
    public void cancel() {
        this.interrupt();
        System.out.println(this.getName() + ": MyTaskImpl取消完成");
    }

    @Override
    public void rollBack() {

    }
}
