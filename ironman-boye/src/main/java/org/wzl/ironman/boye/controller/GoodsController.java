package org.wzl.ironman.boye.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wzl.ironman.boye.domain.goods.GoodsRequest;
import org.wzl.ironman.boye.service.GoodsService;

/**
 * 商品控制层
 *
 * @author wangzhilei@tinman.cn
 * @date 2022/08/20
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @PostMapping("/price")
    public String calculatePrice(@ModelAttribute @Valid GoodsRequest goods, Model model) {
        String price;
        if (ObjectUtils.isNotEmpty(goods.getCost())) {
            price = goodsService.calculatePrice(goods.convertGoodsEntity());
        } else {
            price = "0";
        }
        goods.setPrice(price);
        model.addAttribute("goods", goods);
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        GoodsRequest goods = new GoodsRequest();
        model.addAttribute("goods", goods);
        return "index";
    }
}
