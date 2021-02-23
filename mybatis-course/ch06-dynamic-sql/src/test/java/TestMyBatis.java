import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqh
 * @date 2021/2/9 下午10:46
 */
public class TestMyBatis {
    @Test
    public void testSelectStudentIf() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //mybatis动态代理机制
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = studentDao.selectStudentIf(student);
        for(Student stu: students) {
            System.out.println("if === " + stu);
        }
    }
    @Test
    public void testSelectStudentWhere() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //mybatis动态代理机制
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = studentDao.selectStudentWhere(student);
        for(Student stu: students) {
            System.out.println("where === " + stu);
        }
    }


    @Test
    public void testfor() {
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        //String sql = "select * from student where id in (1001,1002,1003)";
        String sql = "select * from student where id in ";

        StringBuilder builder = new StringBuilder("");
        int init = 0;
        int len = list.size();

        //添加开始的 (
        builder.append("(");
        for (Integer integer : list) {
            builder.append(integer).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        //循环结尾
        builder.append(")");
        sql = sql + builder.toString();
        System.out.println("sql == " + sql);
    }


    @Test
    public void testSelectforEachOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //mybatis动态代理机制
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        List<Student> students = studentDao.selectForeachOne(list);
        for (Student student : students) {
            System.out.println("foreachone === " + student);
        }
    }

    @Test
    public void testSelectforEachTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //mybatis动态代理机制
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> stuList = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        stuList.add(s1);

        s1 = new Student();
        s1.setId(1005);
        stuList.add(s1);


        List<Student> students = studentDao.selectForeachTwo(stuList);
        for (Student student : students) {
            System.out.println("foreachone === " + student);
        }
    }
}
