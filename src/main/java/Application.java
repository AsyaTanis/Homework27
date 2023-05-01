import jdk.jfr.Percentage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Employee employee = new Employee("Татьяна","Иванова","жен",33, 1);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        employeeDAO.getAllEmployees();
        System.out.println(employeeDAO.getEmployeeById(1));
        employeeDAO.createEmployee(employee);
        employeeDAO.getAllEmployees();
        employee.setAge(44);
        employeeDAO.updateEmployee(employee);
        employeeDAO.deleteEmployee(employee);
        employeeDAO.getAllEmployees();
    }
}