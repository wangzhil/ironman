package com.wzl.common.syn.rollback;

import lombok.SneakyThrows;

/**
 * 我的任务
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/24 21:11
 */
public abstract class MyTask extends Thread implements BossCancel {

    private String name;

    private Integer timeSeconds;

    private boolean successFlag;

    private ResultEnum status = ResultEnum.NOTEND;

    public MyTask(String name, Integer timeSeconds, boolean successFlag) {
        this.name = name;
        this.timeSeconds = timeSeconds;
        this.successFlag = successFlag;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(timeSeconds * 1000);
        this.status = successFlag ? ResultEnum.SUCCESS : ResultEnum.FAILED;
        System.out.println("线程" +  name +  "结束");
    }

    public ResultEnum getStatus() {
        return status;
    }

}
