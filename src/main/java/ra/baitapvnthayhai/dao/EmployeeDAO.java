package ra.baitapvnthayhai.dao;

import ra.baitapvnthayhai.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();
    Employee getEmployeeById(Integer emId);
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Integer emId);

}
