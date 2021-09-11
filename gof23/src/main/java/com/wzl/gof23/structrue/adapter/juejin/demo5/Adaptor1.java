package com.wzl.gof23.structrue.adapter.juejin.demo5;

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
public class Adaptor1 implements Target {

    public Source source;
    @Override
    public void request() {
        source.request1();
    }
}
