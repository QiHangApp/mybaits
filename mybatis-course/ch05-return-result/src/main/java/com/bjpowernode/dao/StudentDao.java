package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
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




}

