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
