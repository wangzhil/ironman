package com.wzl.gof23.behavior.commond;

import com.wzl.gof23.behavior.commond.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/1 17:04
 */
public class XiaoEr {

    private List<ICuisine> iCuisineList = new ArrayList<>();

    public void order(ICuisine iCuisine) {
        iCuisineList.add(iCuisine);
    }


    public synchronized void placeOrder() {
        iCuisineList.forEach(ICuisine::cuisine);
        iCuisineList.clear();
    }
}
