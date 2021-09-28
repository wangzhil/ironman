package com.wzl.share.strategy.lambda;


import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.wzl.share.strategy.lambda.impl.StudentFilterAge;
import com.wzl.share.strategy.lambda.impl.StudentFilterScore;

/**
 * 策略模式的测试
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/23 18:16
 */
public class StrategySingletonTest {

    public List<Student> list = Arrays.asList(
            new Student("小张", 12, 90),
            new Student("小李", 16, 91),
            new Student("小王", 18, 100),
            new Student("小赵", 22, 55),
            new Student("小孙", 26, 60),
            new Student("小周", 32, 20)
    );

    /**
     * 过滤年龄大于20的学生
     */
    @Test
    public void test1() {
        final List<Student> students = filterAge(list);
        students.forEach(System.out::println);
    }

    /**
     * 过滤及格分数的学生
     */
    @Test
    public void test2() {
        final List<Student> students = filterScore(list);
        students.forEach(System.out::println);
    }

    /**
     * 过滤及格分数的学生
     */
    @Test
    public void test3() {
        final List<Student> students = filter(list, new StudentFilterAge());
        students.forEach(System.out::println);

        System.out.println("==================== 很劲爆的分割线 ====================");

        final List<Student> xxx = filter(students, new StudentFilterScore());
        xxx.forEach(System.out::println);
    }

    /**
     * lambda
     */
    @Test
    public void test4() {

        filter(list, student -> student.getAge() > 20);

    }

    /**
     * 过滤年龄
     *
     * @param studentList 学生列表
     * @return {@link List}<{@link Student}>
     */
    public List<Student> filter(List<Student> studentList, StudentFilter studentFilter) {

        List<Student> list = new ArrayList<>();
        for (Student student : studentList) {
            if (studentFilter.filter(student)) {
                list.add(student);
            }
        }
        return list;
    }


    /**
     * 过滤年龄
     *
     * @param studentList 学生列表
     * @return {@link List}<{@link Student}>
     */
    public List<Student> filterAge(List<Student> studentList) {

        List<Student> list = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getAge() > 20) {
                list.add(student);
            }
        }
        return list;
    }


    /**
     * 过滤得分
     *
     * @param studentList 学生列表
     * @return {@link List}<{@link Student}>
     */
    public List<Student> filterScore(List<Student> studentList) {

        List<Student> list = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getScore() >= 60) {
                list.add(student);
            }
        }
        return list;
    }


    @Test
    public void test11() {
        final List<Student> collect = list.stream()
                .filter(e -> e.getAge() > 16)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


}
