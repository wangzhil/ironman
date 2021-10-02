package com.wzl.gof23.behavior.visitor.visitor;

import com.wzl.gof23.behavior.visitor.user.impl.Student;
import com.wzl.gof23.behavior.visitor.user.impl.Teacher;

/**
 * 访问者抽象
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 13:28
 */
public interface Visitor {

    void visit(Student student);

    void visit(Teacher teacher);

}
