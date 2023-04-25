import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    void createEmployee(Employee user);
    void updateEmployee(Employee user);
    void deleteEmployee(int id);
}
