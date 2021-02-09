package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author lqh
 * @date 2021/2/9 下午9:55
 */
public interface StudentDao {
    List<Student> selectStudents();

    int insertStudent(Student student);
}
