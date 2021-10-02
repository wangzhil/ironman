package com.wzl.gof23.behavior.template;

/**
 * 模板接口
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/1 10:04
 */
public abstract class CrawlingSteps {

    public void crawlingEntrance() {
        login();
        crawling();
        generatePoster();
    }

    protected abstract void login();

    protected abstract void crawling();

    protected abstract void generatePoster();
}
