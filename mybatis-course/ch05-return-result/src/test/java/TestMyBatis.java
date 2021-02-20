import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //com.sun.proxy.$Proxy2 : jdk的动态代理
        System.out.println("dao="+ studentDao.getClass().getName());
        Student student = studentDao.selectStudentById(1007);
        System.out.println(student);
    }
    @Test
    public void testSelectMutilParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper((StudentDao.class));

        List<Student> students = dao.selectMultiParam("李四", 20);

        for (Student student : students) {
            System.out.println("学生="+student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiObject() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setParamAge(28);
        param.setParamName("夏侯惇");
        List<Student> students = studentDao.selectMultiObject(param);

        for (Student student : students) {
            System.out.println("学生="+student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("夏侯惇");
        student.setAge(28);
        List<Student> students = studentDao.selectMultiStudent(student);

        for (Student stu : students) {
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = studentDao.selectMultiPosition("夏侯惇", 28);
        for (Student stu : students) {
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiByMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Map<String, Object> data = new HashMap<>();
        data.put("myname", "夏侯惇");
        data.put("age1",28);
        List<Student> students = studentDao.selectMultiByMap(data);
        for (Student stu : students) {
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$("'夏侯惇'");

        for (Student student : students) {
            System.out.println("学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$Order() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("age");

        for (Student student : students) {
            System.out.println("学生=" + student);
        }
        sqlSession.close();
    }
}
