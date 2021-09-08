package com.wzl.gof23.structrue.component.genealogy;

/**
 * 叶子结构，拆分到不能再拆分为止
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 22:16
 */
public class Leaf extends Component {

    @Override
    public void operation() {
        System.out.println("叶子节点的操作方法!");
    }
}
