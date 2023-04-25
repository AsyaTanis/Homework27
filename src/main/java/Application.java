import java.sql.*;
import java.util.List;
public class Application {
    public static void main(String[] args) {

        /*
        final String user = "postgres";
        final String password = "qwerty";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id = 3 ")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("ID работника: " + idOfEmployee);

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");

                int amountOfCity = resultSet.getInt("city_id");

                System.out.println("Имя: " + firstName);
                System.out.println("Фамилия: " + lastName);
                System.out.println("Пол сотрудника: " + gender);
                System.out.println("Город сотрудника: " + amountOfCity);
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }*/

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        // Получение списка всех объектов Employee из базы.
        List <Employee> employees_1 = employeeDAO.getAllEmployee();

        for (Employee employee : employees_1) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Имя: " + employee.getFirst_name());
            System.out.println("Фамилия: " + employee.getLast_name());
            System.out.println("Пол сотрудника: " + employee.getGender());
            System.out.println("Возраст сотрудника: " + employee.getAge());
            System.out.println("Город сотрудника: " + employee.getCity_id());
        }
        System.out.println();

        //Получение конкретного объекта Employee по id.

        Employee employees_2 = employeeDAO.getEmployeeById(3);

        System.out.println("ID: " + employees_2.getId());
        System.out.println("Имя: " + employees_2.getFirst_name());
        System.out.println("Фамилия: " + employees_2.getLast_name());
        System.out.println("Пол сотрудника: " + employees_2.getGender());
        System.out.println("Возраст сотрудника: " + employees_2.getAge());
        System.out.println("Город сотрудника: " + employees_2.getCity_id());
        System.out.println();

        //Получение конкретного объекта Employee по id.
        employeeDAO.createEmployee(new Employee(8,"Татьяна","Иванова","жен",33, 1));

        //Изменение конкретного объекта Employee в базе по id.
        employeeDAO.updateEmployee(new Employee(8,"Татьяна","Петрова","жен",34, 2));

        //Удаление конкретного объекта Employee из базы по id.
        employeeDAO.deleteEmployee(8);

    }
}