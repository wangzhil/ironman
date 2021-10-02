package com.wzl.gof23.behavior.visitor;

import com.wzl.gof23.behavior.visitor.user.User;
import com.wzl.gof23.behavior.visitor.user.impl.Student;
import com.wzl.gof23.behavior.visitor.user.impl.Teacher;
import com.wzl.gof23.behavior.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 14:28
 */
public class DataView {

    List<User> userList = new ArrayList<>();

    public DataView() {
        userList.add(new Student("谢飞机", "重点班", "一年一班"));
        userList.add(new Student("windy", "重点班", "一年一班"));
        userList.add(new Student("大毛", "普通班", "二年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "一年一班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "一年一班"));
        userList.add(new Teacher("dangdang", "普通教师", "二年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }

    public void show(Visitor visitor) {
        userList.forEach(user -> user.accept(visitor));
    }
}
