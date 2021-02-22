package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lqh
 * @date 2021/2/9 下午9:55
 */
public interface StudentDao {


    public Student selectStudentById(Integer id);

    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();

    //定义方法返回Map
    Map<Object, Object> selectMapById(Integer id);

    /**
     * 使用resultMap定义映射关系
     */
    List<Student> selectAllStudents();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    /*第一种模糊查询，在java代码指定like的内容*/
    List<Student> selectLikeOne(String name);

    List<Student> selectLikeTwo(String name);
}

