import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lqh
 * @date 2021/2/9 下午10:46
 */
public class TestMyBatis {
    @Test
    public void testSelectStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //mybatis动态代理机制
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student1 = new Student();
        student1.setAge(28);
        student1.setEmail("ssos@163.com");
        student1.setId(1007);
        student1.setName("张飞");
        int num = studentDao.insertStudent(student1);
        System.out.println("添加对象数量：" + num);

    }
}
