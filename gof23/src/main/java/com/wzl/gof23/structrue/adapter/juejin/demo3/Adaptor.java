package com.wzl.gof23.structrue.adapter.juejin.demo3;

import lombok.Builder;
import lombok.Data;

/**
 * 适配器
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/11 9:28
 */
@Data
@Builder
public class Adaptor implements Target {

    private Target target;

    @Override
    public void request() {
        target.request();
    }
}
