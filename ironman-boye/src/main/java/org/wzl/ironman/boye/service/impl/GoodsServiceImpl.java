package org.wzl.ironman.boye.service.impl;

import org.springframework.stereotype.Service;
import org.wzl.ironman.boye.domain.goods.GoodsEntity;
import org.wzl.ironman.boye.domain.goods.GoodsRequest;
import org.wzl.ironman.boye.service.GoodsService;

/**
 * @author wangzhilei@tinman.cn
 * @date 2022/08/20
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public String calculatePrice(GoodsEntity goodsEntity) {

        return goodsEntity
            .convertLogistics()
            .convertGoodsFactor()
            .calculatePrice();
    }
}
