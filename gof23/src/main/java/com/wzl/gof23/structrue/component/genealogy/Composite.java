package com.wzl.gof23.structrue.component.genealogy;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝结构，组合树叶和树干部分
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 22:12
 */
public class Composite extends Component {

    private List<Component> componentList = new ArrayList<>();

    void add(Component component) {
        componentList.add(component);
    }

    void remove(Component component) {
        componentList.remove(component);
    }

    List<Component> getChildren() {
        return componentList;
    }

    @Override
    public void operation() {
        System.out.println("树干结构！");
    }
}
