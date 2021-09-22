package com.wzl.share.builder.optimization;

import com.wzl.share.builder.Goods;

/**
 * 抽象接口
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 21:30
 */
public abstract class GoodsBuilder {

    protected Goods goods = new Goods();

    /**
     * 获取普通商品
     *
     * @return {@link Goods}
     */
    abstract Goods generalGoods();

    /**
     * 电子产品
     *
     * @return {@link Goods}
     */
    abstract Goods electronicGoods();

    /**
     * 得到视频
     *
     * @return {@link Goods}
     */
    abstract Goods getVideo();

    /**
     * 得到货物
     *
     * @return {@link Goods}
     */
    public Goods getGoods() {
        return goods;
    }
}
