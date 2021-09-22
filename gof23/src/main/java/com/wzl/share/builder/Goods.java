package com.wzl.share.builder;

import lombok.Data;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 21:19
 */
@Data
public class Goods {

    private String goodsName;
    private Integer type;
    private String code;
    private String url;

    public static Goods getItem(String scene) {
        Goods item = new Goods();
        if ("创建普通商品".equals(scene)) {
            item.setGoodsName("普通商品");
            item.setType(1);
        } else if ("创建电子卡券商品".equals(scene)) {
            item.setGoodsName("电子卡券商品");
            item.setCode("12341234");
            item.setType(2);
        } else if ("创建视频".equals(scene)) {
            item.setGoodsName("视频");
            item.setUrl("www.baidu.com");
            item.setType(3);
        }
        return item;
    }


    public static void main(String[] args) {
        String scene = "创建普通商品";
        Goods.getItem(scene);
    }
}
