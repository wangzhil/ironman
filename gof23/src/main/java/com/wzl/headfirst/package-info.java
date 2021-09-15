/**
 * 阶段一：
 *
 * 做了一个鸭子的超类，所有鸭子不管是外观、行为都继承自他，当前存在问题就是如果增加鸭子类，考虑具体父类抽象或者行为的重写。
 * 存在问题： 比如：新增玩具鸭子，不会叫，不会飞，要覆盖父超级鸭子类做重写，但是当增加鸭子行为的时候呢？？？？如果几百个鸭子的实现类呢？
 * 是不是需要去判断每个鸭子是否重写该新增超类行为？就真的成了超累。。。。
 *
 * 又考虑将不同的行为都抽象出来做单独的接口，需要使用的再实现该接口即可。
 *
 * 阶段二：
 *
 *
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/13 9:23
 */
package com.wzl.headfirst;