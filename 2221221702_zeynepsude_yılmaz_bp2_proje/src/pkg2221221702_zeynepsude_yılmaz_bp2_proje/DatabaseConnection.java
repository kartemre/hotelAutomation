/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

/**
 *
 * @author emrekart
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Emre123.";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public static User getUser(String username, String password) {
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT first_name, last_name, email, password FROM Users WHERE username = ? AND password = ?";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("first_name"));
                user.setSurname(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username")); 
                user.setGender(resultSet.getString("gender"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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