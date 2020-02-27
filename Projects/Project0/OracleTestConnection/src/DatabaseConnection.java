import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


	
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:odbc://localhost:1512/revatureDb";
    private String username = "Rahb";
    private String password = "root";
    private DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }
    public Connection getConnection() {
        return connection;
    }
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}