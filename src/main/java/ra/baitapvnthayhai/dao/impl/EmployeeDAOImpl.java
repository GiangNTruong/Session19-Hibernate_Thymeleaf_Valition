package ra.baitapvnthayhai.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.baitapvnthayhai.dao.EmployeeDAO;
import ra.baitapvnthayhai.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Employee ").list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(Integer emId) {
        Session session = sessionFactory.openSession();
        try {
            Employee employee = session.get(Employee.class,emId);
            return employee;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
       Session session = sessionFactory.openSession();
       try {
           session.beginTransaction();
           session.save(employee);
           session.getTransaction().commit();
           return true;
       }catch (Exception ex){
           ex.printStackTrace();
           session.getTransaction().rollback();
       }finally {
           session.close();
       }
       return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Integer emId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(getEmployeeById(emId));
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }return false;
    }
}
