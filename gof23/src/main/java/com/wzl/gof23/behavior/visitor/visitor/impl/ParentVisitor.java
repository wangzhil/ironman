package com.wzl.gof23.behavior.visitor.visitor.impl;

import com.wzl.gof23.behavior.visitor.user.impl.Student;
import com.wzl.gof23.behavior.visitor.user.impl.Teacher;
import com.wzl.gof23.behavior.visitor.visitor.Visitor;

/**
 * 父母
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 13:31
 */
public class ParentVisitor implements Visitor {

    @Override
    public void visit(Student student) {
        System.out.println(student.name + student.clazz + student.identity);
    }

    @Override
    public void visit(Teacher teacher) {
        System.out.println(teacher);
    }
}
