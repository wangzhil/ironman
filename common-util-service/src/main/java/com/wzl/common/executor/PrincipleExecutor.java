package com.wzl.common.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/11 9:06
 */
public class PrincipleExecutor {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        ExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        ExecutorService workStealingPool = Executors.newWorkStealingPool();

    }
}
