package com.wzl.common.syn.rollback;

/**
 * 取消
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/25 8:41
 */
public interface BossCancel {

    /**
     * 取消
     */
    void cancel();

    /**
     * 回滚
     */
    void rollBack();

}
