package com.wzl.common.syn.rollback;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任务线程池
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/25 8:30
 */
@Builder
@Data
public class Boss {

    private List<MyTask> tasks;

    public void add(MyTask t) {
        tasks.add(t);
    }

    public void cancel() {
        tasks.forEach(MyTask::cancel);
    }

    public void rollBack() {
        tasks.forEach(MyTask::rollBack);
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(12, "十二");
    }
}
