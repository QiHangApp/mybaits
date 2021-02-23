package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author lqh
 * @date 2021/2/9 下午9:55
 */
public interface StudentDao {

    //动态sql,使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where使用
    List<Student> selectStudentWhere(Student student);
}

