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
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    
    public void updateUser(String username, String newFirstName, String newLastName, String newEmail, String newPassword) {
        String updateQuery = "UPDATE Users SET first_name = ?, last_name = ?, email = ?, password = ? WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, newFirstName);
            preparedStatement.setString(2, newLastName);
            preparedStatement.setString(3, newEmail);
            preparedStatement.setString(4, newPassword);
            preparedStatement.setString(5, username);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("User updated successfully.");
            } else {
            System.out.println("No user found to update.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void addRoom(int roomNumber, int capacity, double price, String roomType) {
        String insertQuery = "INSERT INTO Rooms (roomNumber, capacity, price, roomType) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, roomNumber);
            preparedStatement.setInt(2, capacity);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, roomType);

            int rowAffected = preparedStatement.executeUpdate();
        if (rowAffected > 0) {
            System.out.println("Room added successfully.");
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addReservation(String username, int roomNumber, String reservationCity, String reservationStartDate, String reservationEndDate, boolean threeMeals, boolean hotPool, boolean funCenter) {
        String insertQuery = "INSERT INTO Reservations (username, roomNumber, reservationCity, reservationStartDate, reservationEndDate, threeMeals, hotPool, funCenter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, roomNumber);
            preparedStatement.setString(3, reservationCity);
            preparedStatement.setDate(4, java.sql.Date.valueOf(reservationStartDate));
            preparedStatement.setDate(5, java.sql.Date.valueOf(reservationEndDate));
            preparedStatement.setBoolean(6, threeMeals);
            preparedStatement.setBoolean(7, hotPool);
            preparedStatement.setBoolean(8, funCenter);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Reservation added successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteReservation(int reservationId) {
        String deleteSQL = "DELETE FROM reservations WHERE reservation_id = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Silme sorgusunu hazırlama
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, reservationId);

            // Sorguyu çalıştırma
            int rowsAffected = preparedStatement.executeUpdate();

            // Silme işlemi başarılı mı kontrol et
            connection.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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