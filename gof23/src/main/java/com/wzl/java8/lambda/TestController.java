package com.wzl.java8.lambda;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/9 9:06
 */
@RestController
public class TestController {

    @PostMapping("/test")
    private void test(@RequestBody ConvertDto convertDto) {

        System.out.println(JSONObject.toJSONString(convertDto));

    }
}
