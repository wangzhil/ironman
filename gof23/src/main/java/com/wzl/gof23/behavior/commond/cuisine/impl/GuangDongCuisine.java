package com.wzl.gof23.behavior.commond.cuisine.impl;

import com.wzl.gof23.behavior.commond.cook.ICook;
import com.wzl.gof23.behavior.commond.cuisine.ICuisine;

/**
 * 广东实物
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/1 16:58
 */
public class GuangDongCuisine implements ICuisine {

    private ICook iCook;

    GuangDongCuisine(ICook iCook) {
        this.iCook = iCook;
    }

    @Override
    public void cuisine() {
        iCook.cook();
    }
}
