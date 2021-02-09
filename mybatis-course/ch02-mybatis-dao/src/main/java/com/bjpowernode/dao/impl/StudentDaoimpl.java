package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lqh
 * @date 2021/2/9 下午10:13
 */
public class StudentDaoimpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId="com.bjpowernode.dao.StudentDao.selectStudents";
        //执行sql语句， 使用SqlSession类的方法
        List<Student> students  = sqlSession.selectList(sqlId);
        //关闭
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId="com.bjpowernode.dao.StudentDao.insertStudent";
        //执行sql语句， 使用SqlSession类的方法
        int nums = sqlSession.insert(sqlId,student);
        //提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return nums;
    }
}
