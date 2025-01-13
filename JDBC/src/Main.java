import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT name FROM my_table where type = 'iPad'";

        String url = "jdbc:postgresql://localhost:5432/my_database";
        String user = "postgres";
        String password = "2005021";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}