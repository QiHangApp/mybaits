import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        System.out.println("dao=" + studentDao.getClass().getName());
        Student student = studentDao.selectStudentById(1007);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectMutilParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper((StudentDao.class));

        List<Student> students = dao.selectMultiParam("李四", 20);

        for (Student student : students) {
            System.out.println("学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelctViewStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        ViewStudent student = dao.selectStudentReturnViewStudent(1005);

        System.out.println("1005 student=" + student);
        sqlSession.close();
    }

    @Test
    public void testSelectCount() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int counts = dao.countStudent();

        System.out.println("学生数量 = " + counts);
        sqlSession.close();
    }

    //返回map
    @Test
    public void testSelectMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object, Object> map = dao.selectMapById(1001);

        System.out.println("map = " + map);
        sqlSession.close();
    }

    //========================================
    @Test
    public void testSelectAllStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectAllStudents();

        for (Student student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAllStudents2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> myStudents = dao.selectMyStudent();

        for (MyStudent myStudent : myStudents) {
            System.out.println("学生 = " + myStudent);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectDiffcolProperty() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> myStudents = dao.selectDiffColProperty();

        for (MyStudent myStudent : myStudents) {
            System.out.println("########学生 = " + myStudent);
        }
        sqlSession.close();
    }
}
