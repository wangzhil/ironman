package org.wzl.ironman.boye.service;

import org.wzl.ironman.boye.domain.goods.GoodsEntity;
import org.wzl.ironman.boye.domain.goods.GoodsRequest;

/**
 * @author wangzhilei@tinman.cn
 * @date 2022/08/20
 */
public interface GoodsService {

    /**
     * 计算价格
     *
     * @param goodsEntity 商品实体
     * @return {@link String}
     */
    String calculatePrice(GoodsEntity goodsEntity);
}
