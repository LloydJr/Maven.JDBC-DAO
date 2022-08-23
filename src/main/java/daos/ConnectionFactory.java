package daos;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/RDBMS";
    public static final String USER = "root";
    public static final String PASS = "#Bucks4965";

    public static Connection getConnection() throws SQLException {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connection to the database", ex);
        }
    }
    /**
     * Test Connection
     * */
//    public static void main(String[] args) {
//        Connection connection = connectionFactory.getConnection;
//    }
}
