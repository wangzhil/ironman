package com.wzl.study.executor.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/11/26 9:18
 */
public class CyclicBarrierTest1 {

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);

        for (int i = 0; i < N; i++) {
            if (i < N - 1)
                new Writer(barrier).start();
            else {
                try {
                    //运行时间远小于2000(cyclicBarrier.await 指定时间) 就不会抛出TimeoutException
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Writer(barrier).start();
            }

        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(3000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                try {
                    cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "所有线程写入完毕，继续处理其他任务...");
        }
    }
}
