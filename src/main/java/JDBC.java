import java.sql.*;

public class JDBC {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testdv";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String sql = "Select * from developers";
        ResultSet resultSet = statement.executeQuery(sql);


        System.out.println("Moving cursor to the last position...");
        resultSet.absolute(1);

        System.out.println("Getting record (by name)...");
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String specialty = resultSet.getString("specialty");
        int salary = resultSet.getInt("salary");

        System.out.println("Last record in result set:");
        System.out.println("id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
        System.out.println("Salary: $" + salary);
        System.out.println("\n=========================\n");


        int newSalary = resultSet.getInt("salary") + 1000;
        resultSet.updateInt("salary", newSalary);
        resultSet.updateRow();




        resultSet.close();
        statement.close();
        connection.close();

    }
}
