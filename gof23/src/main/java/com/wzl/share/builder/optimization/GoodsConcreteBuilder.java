package com.wzl.share.builder.optimization;

import com.wzl.share.builder.Goods;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 21:37
 */
public class GoodsConcreteBuilder extends GoodsBuilder {

    @Override
    Goods generalGoods() {

        goods.setGoodsName("普通商品");
        goods.setType(1);
        return goods;
    }

    @Override
    Goods electronicGoods() {
        goods.setGoodsName("电子卡券商品");
        goods.setCode("12341234");
        goods.setType(2);
        return goods;
    }

    @Override
    Goods getVideo() {
        goods.setGoodsName("视频");
        goods.setUrl("www.baidu.com");
        goods.setType(3);
        return goods;
    }
}
