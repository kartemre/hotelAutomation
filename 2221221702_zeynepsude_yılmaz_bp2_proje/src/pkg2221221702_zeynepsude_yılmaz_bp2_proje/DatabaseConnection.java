package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hoteldatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Emre123.";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Veritabanı bağlantısı başarılı!");
                connection.close(); // Bağlantıyı kapatmayı unutmayın
            }
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantısı başarısız!");
            e.printStackTrace();
        }
    }
}
