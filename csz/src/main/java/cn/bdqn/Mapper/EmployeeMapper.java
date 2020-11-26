package cn.bdqn.Mapper;

import cn.bdqn.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
                List<Employee> li();
       void   insert(Employee employee);
       Employee  selectAllEmployeesbyid(Integer id);
         void    daletebyid(Integer id);
         void updateidandname(Employee employee);
         List<Employee> nameandsex( @Param("empName")String empName , @Param("sex")String sex);
           List<Employee> selectname (String empName);

}
