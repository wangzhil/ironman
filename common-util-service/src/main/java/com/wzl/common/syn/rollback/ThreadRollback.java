package com.wzl.common.syn.rollback;

import com.wzl.common.syn.rollback.impl.MyTaskImpl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 模拟事务回滚
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/24 21:03
 */
public class ThreadRollback {

    public static void main(String[] args) {

        MyTask t1 = new MyTaskImpl("t1", 3, true);
        MyTask t2 = new MyTaskImpl("t2", 4, true);
        MyTask t3 = new MyTaskImpl("t3", 1, false);

        final Boss boss = Boss.builder().tasks(Arrays.asList(t1, t2, t3)).build();
        final List<MyTask> tasks = boss.getTasks();
        tasks.forEach(Thread::start);
        AtomicBoolean flag = new AtomicBoolean(true);
        while (flag.get()) {

            tasks.forEach(task -> {
                if (task.getStatus() == ResultEnum.FAILED) {
                    boss.cancel();
                    flag.set(false);
                }
            });
        }


    }
}
