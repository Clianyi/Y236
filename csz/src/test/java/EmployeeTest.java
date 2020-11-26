import cn.bdqn.Mapper.EmployeeMapper;
import cn.bdqn.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class EmployeeTest {
    // 测试1： 查询全部的员工
    @Test
    public void testSelectAllEmployees() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession(true);

        // 4、通过EmployeeMapper接口代理的方式去调用EmployeeMapper接口中的方法。
          //EmployeeMapper    employeeMapper=session.getMapper(EmployeeMapper.class);
           //    List<Employee> list=employeeMapper.li();
      // List<Employee> employees = session.selectList("cn.bdqn.Mapper.selectAllEmployees");
        // 5、循环遍历
        EmployeeMapper em=session.getMapper(cn.bdqn.Mapper.EmployeeMapper.class);
     List<Employee> ss=  em.li();
        for (Employee e:ss
             ) {
            System.out.println(e);
        }
        session.close();

        // 7、关闭流
        is.close();
    }
    //添加员工信息
    @Test
    public void testInsert() throws Exception{

         //1读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

//        2根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

//         3用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession(true);
     //   4通过SqlSession提供的方法添加员工
       Employee employee = new Employee();
       employee.setEmpName("崔");
        employee.setAddress("蓬莱");
       employee.setBirthday(new Date());
        employee.setEmail("cui@126.com");
      employee.setSex("男");
        EmployeeMapper em=session.getMapper(cn.bdqn.Mapper.EmployeeMapper.class);
         em.insert(employee);
        // 5、提交
        // 6关闭SqlSession
       session.close();
        // 7关闭流
//        is.close();
    }
    //根据id查询员工信息
    @Test
    public void testSelectById() throws Exception {

//        // 1、读取mybatis主配置文件
       InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//
//        // 2、根据配置文件创建SqlSessionFactory
      SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        // 3、用SqlSessionFactory工厂去创建SqlSession
       SqlSession session = factory.openSession();
          EmployeeMapper  employeeMapper=session.getMapper(EmployeeMapper.class);
          Employee employee=employeeMapper.selectAllEmployeesbyid(4);
//
//        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        Employee employees = session.selectOne("cn.bdqn.domain.selectAllEmployeesbyid", 4);
//        // 5、打印
        System.out.println(employee);
//
//        // 6、关闭SqlSession
        session.close();
//
//        // 7、关闭流
        is.close();
    }
    //根据id删除员工信息
    @Test
    public void testDeleteById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
       SqlSession session = factory.openSession();
    EmployeeMapper employeeMapper =session.getMapper(cn.bdqn.Mapper.EmployeeMapper.class);
      employeeMapper.daletebyid(4);
            session.commit();


        // 4、通过SqlSession提供的方法删除员工
        //session.delete("cn.bdqn.mapper.deleteById",5);

        // 5、提交


        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    // 根据姓名模糊查询员工信息
    @Test
   public void testSelectByName() throws Exception{
//    // 1、读取mybatis主配置文件
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//    // 2、根据配置文件创建SqlSessionFactory
   SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//    // 3、用SqlSessionFactory工厂去创建SqlSession
    SqlSession session = factory.openSession(true);
//    // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        EmployeeMapper employeeMapper =session.getMapper(cn.bdqn.Mapper.EmployeeMapper.class);
         List<Employee> employees=employeeMapper.selectname("%智%");
   // List<Employee> employees = session.selectList("cn.bdqn.domain.selectByName","%智%");
        System.out.println(employees);

//    // 6、关闭SqlSession
   session.close();
//    // 7、关闭流
   is.close();
}
   //添加员工信息返回id主键
   @Test
   public void testInsertReturnPrimaryKey_1() throws Exception{

//       // 1、读取mybatis主配置文件
      InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//
//       // 2、根据配置文件创建SqlSessionFactory
       SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//       // 3、用SqlSessionFactory工厂去创建SqlSession
      SqlSession session = factory.openSession();
//
//       // 4、通过SqlSession提供的方法添加员工
       Employee employee = new Employee();
       employee.setEmpName("凯");
       employee.setAddress("达达乌山谷");
       employee.setBirthday(new Date());
       employee.setEmail("cuican@126.com");
      employee.setSex("男");
//
      session.insert("cn.bdqn.domain.insertReturnPrimaryKey_1",employee);
//
       System.out.println("返回的主键id是:   " + employee.getId());
//
//       // 5、提交
       session.commit();
//
//       // 6、关闭SqlSession
       session.close();
//
//       // 7、关闭流
       is.close();
   }
   //根据id更新员工信息
    @Test
   public void testUpdateById() throws Exception{

       // 1、读取mybatis主配置文件
       InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

       // 2、根据配置文件创建SqlSessionFactory
       SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

       // 3、用SqlSessionFactory工厂去创建SqlSession
       SqlSession session = factory.openSession();
       // 4、通过SqlSession提供的方法更新员工
       EmployeeMapper employeeMapper=session.getMapper(cn.bdqn.Mapper.EmployeeMapper.class);
       Employee employee = new Employee();
       employee.setId(7);
       employee.setEmpName("小鑫");
       employee.setAddress("新乡");
      employeeMapper.updateidandname(employee);
       // 5、提交
       session.commit();

       // 6、关闭SqlSession
       session.close();

       // 7、关闭流
       is.close();
   }
    // 根据员工姓名和性别查询员工
    @Test
    public void nameandsex() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession(true);

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(cn.bdqn.Mapper.EmployeeMapper.class);
       List<Employee> em=employeeMapper.nameandsex("凯","男");
        System.out.println(em);
        session.close();
        // 7、关闭流
        is.close();
    }


}

