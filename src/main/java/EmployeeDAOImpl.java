import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "qwerty";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override  //Получение списка всех объектов Employee из базы.
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int idOfEmployee = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int amountOfCity = resultSet.getInt("city_id");

                employees.add(new Employee(idOfEmployee, firstName, lastName, gender, age, amountOfCity));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return employees;
    }

    @Override   //Получение конкретного объекта Employee по id.
    public Employee getEmployeeById(int id) {
        Employee employees = null;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id = " + id)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int idOfEmployee = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int amountOfCity = resultSet.getInt("city_id");
                employees = new Employee(idOfEmployee, firstName, lastName, gender, age, amountOfCity);
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void createEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO employee(id, first_name, last_name, gender, age, city_id) " +
                     "VALUES (?,?,?,?,?,?)")) {
            statement.setInt(1,employee.getId());
            statement.setString(2,employee.getFirst_name());
            statement.setString(3,employee.getLast_name());
            statement.setString(4,employee.getGender());
            statement.setInt(5,employee.getAge());
            statement.setInt(6,employee.getCity_id());
            int resultSet = statement.executeUpdate();
            System.out.println("Сотрудник добавлен");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE employee SET first_name= ?,last_name= ?,gender= ?,age= ? WHERE id = ?")) {
            statement.setInt(1,employee.getId());
            statement.setString(2,employee.getFirst_name());
            statement.setString(3,employee.getLast_name());
            statement.setString(4,employee.getGender());
            statement.setInt(5,employee.getAge());
            statement.setInt(6,employee.getCity_id());
            int resultSet = statement.executeUpdate();
            System.out.println("Сотрудник обновлен");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id =" + id)){
            int resultSet = statement.executeUpdate();
            System.out.println("Сотрудник удален");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }
}
