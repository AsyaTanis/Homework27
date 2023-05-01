import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
//import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public List<Employee> getAllEmployees() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();
        entityManager.getTransaction().commit();
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee firstName: " + employee.getFirstName());
            System.out.println("Employee lastName: " + employee.getLastName());
            System.out.println("Employee age: " + employee.getAge());
            System.out.println("Employee gender: " + employee.getGender());
            System.out.println("Employee cityId: " + employee.getCityId());
            System.out.println("------------");
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Employee.class, id);

    }

    @Override
    public void createEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }
}