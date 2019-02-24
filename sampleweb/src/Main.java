import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/mysql?user=root&password=mysql");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT 1");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }

}