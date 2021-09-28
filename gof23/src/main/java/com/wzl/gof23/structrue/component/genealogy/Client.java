package com.wzl.gof23.structrue.component.genealogy;

/**
 * 客户端
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/8 22:18
 */
public class Client {

    public static void main(String[] args) {
        Composite root = new Composite();
        Composite site = new Composite();
        Component leaf = new Leaf();
        Component leaf1 = new Leaf();
        
        site.add(leaf);
        site.add(leaf1);
        root.add(site);
        root.add(leaf1);

        Client.showTree(root);
    }

    public static void showTree(Composite root){
        for(Component c: root.getChildren()){
            if(c instanceof Leaf){
                //叶子节点
                c.operation();
            } else {
                //树枝节点
                c.operation();
                showTree((Composite)c);
            }
        }
    }
}
