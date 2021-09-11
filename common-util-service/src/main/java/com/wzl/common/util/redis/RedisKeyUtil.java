package com.wzl.common.util.redis;

/**
 * 创建可读性key值的拼接公用类
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/8/2 16:00
 */
public class RedisKeyUtil {

    private static final String KEY_SPLIT_CHAR = ":";

    /**
     * 新增前置redis存储Key值命名规则， module模块 + : + 业务 + ： + 号
     * @param module 模块
     * @param businessLogic 业务逻辑
     * @param businessNo 业务号
     * @return
     */
    public static String getKeyBuilder(String module, String businessLogic, String businessNo) {
        StringBuilder key = new StringBuilder(module);
        key.append(KEY_SPLIT_CHAR).append(businessLogic).append(KEY_SPLIT_CHAR).append(businessNo);
        return key.toString();
    }

}

