import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoimpl;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author lqh
 * @date 2021/2/9 下午10:46
 */
public class TestMyBatis {
    @Test
    public void testSelectStudent() {
        StudentDao studentDao = new StudentDaoimpl();
        /**
         * List<Student> studentList = dao.selectStudents();调用
         * 1.dao对象，类型是StudentDao，全限定名称是：com.jpowernode.dao.StudentDao
         *      全限定名称和mapper文件中namespace是一样的。
         *
         * 2.方法名称，selectStudent，这个方法就是mapper文件中的id值selectStudents
         *
         * 3.通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法
         *      如果返回值是List，调用的是SQlSession.selectList()方法。
         *      如果返回值int，或是非List的，看mapper文件中的的标签是<insert>,<update>就会调用
         *      SqlSession的insert，update等方法
         *
         * mybatis的动态代理：mybatis根据dao的方法调用，获取执行sql语句的信息。
         *      mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象。
         *      完成SqlSession调用方法，访问数据库。
         */
        List<Student> studentList = studentDao.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testInsertStudent() {
        StudentDao studentDao = new StudentDaoimpl();
        Student student1 = new Student();
        student1.setAge(11);
        student1.setEmail("ssos@163.com");
        student1.setId(1009);
        student1.setName("盾山");
        int num = studentDao.insertStudent(student1);
        System.out.println("添加对象数量：" + num);

    }
}
