import jdk.jfr.Percentage;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {

        CityDAO cityDAO =new CityDAOImpl();
        Collection <City> cityList = cityDAO.getAllCity();
        System.out.println(cityList);
        System.out.println(cityDAO.getCityById(1));

        City city = new City ("Уфа");
        cityDAO.createCity(city);

        cityDAO.updateCity(new City(6,"Уфа"));

        cityDAO.deleteCity(6 ,city);

        CityDAO cityDAO2 = new CityDAOImpl();
        City city2 = new City( "Владивосток");
        cityDAO2.createCity(city2);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = new Employee("Татьяна", "Иванова", "жен", 33, city);
        Employee employee1 = new Employee("Татьяна", "Иванова", "жен", 33, city);
//
        employeeDAO.updateEmployee(new Employee(24, "Артем", "Иванов", "муж", 30, city2));

        employeeDAO.createEmployee(employee);
        employeeDAO.createEmployee(employee1);

        cityDAO.deleteCity(2, city);
    }
}