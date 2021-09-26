package com.wzl.share.builder.optimization;

import com.wzl.share.builder.Goods;

/**
 * Director
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 21:46
 */
public class GoodsDirector extends GoodsBuilder {

    private GoodsBuilder goodsBuilder;

    public GoodsDirector(GoodsBuilder goodsBuilder) {
        this.goodsBuilder = goodsBuilder;
    }

    @Override
    Goods generalGoods() {
        goodsBuilder.generalGoods();
        return goodsBuilder.getGoods();
    }

    @Override
    Goods electronicGoods() {
        goodsBuilder.electronicGoods();
        return goodsBuilder.getGoods();
    }

    @Override
    Goods getVideo() {
        goodsBuilder.getVideo();
        return goodsBuilder.getGoods();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("a");
        sb.append("b")
                .append("c");
    }

}
