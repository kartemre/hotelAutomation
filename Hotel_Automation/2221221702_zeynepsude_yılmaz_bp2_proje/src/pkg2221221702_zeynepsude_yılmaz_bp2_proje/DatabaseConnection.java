/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

/**
 *
 * @author emrekart
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Emre123.";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT username, first_name, last_name, email, password, gender FROM Users";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("first_name"));
                user.setSurname(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static String getValidTestUsername() {
        // Implement logic to fetch a valid username from the database for testing
        // Example:
        String query = "SELECT username FROM users LIMIT 1"; // Adjust the query as needed
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void exportUsersToFile(String filePath) {
        List<User> users = getAllUsers();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Ad,Soyad,Kullanıcı Adı,Mail,Şifre,Cinsiyet");
            writer.newLine();

            for (User user : users) {
                writer.write(user.getName() + "," + user.getSurname() + "," + user.getUsername() + "," + user.getEmail() + "," + user.getPassword() + "," + user.getGender());
                writer.newLine();
            }

            System.out.println("Kullanıcılar başarıyla dosyaya aktarıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String username) {
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT username, first_name, last_name, email, password, gender FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("first_name"));
                user.setSurname(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean validateUser(String username, String password) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(" validate failed.");

        }
        return false;
    }

    public void updateUser(String username, String newFirstName, String newLastName, String newEmail, String newPassword) throws SQLException {
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

    public boolean deleteUser(String username) {
        String deleteQuery = "DELETE FROM Users WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, username);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void addUser(User user) throws SQLException {
        String query = "INSERT INTO Users (first_name, last_name, username, email, password, gender) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getGender());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMultipleUsers(List<User> users) throws SQLException {
        for (User user : users) {
            addUser(user);
        }
    }

    public List<User> readUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 6) {
                    User user = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
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

    public List<Reservations> getAllReservations() {
        List<Reservations> reservations = new ArrayList<>();
        String query = "SELECT reservationID, reservationCity, reservationStartDate, reservationEndDate, threeMeals, hotPool, funCenter FROM reservations";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("reservationID");
                String city = resultSet.getString("reservationCity");
                Date start = resultSet.getDate("reservationStartDate");
                Date finish = resultSet.getDate("reservationEndDate");
                boolean threemeal = resultSet.getBoolean("threeMeals");
                boolean pool = resultSet.getBoolean("hotPool");
                boolean funC = resultSet.getBoolean("funCenter");

                Reservations reservation = new Reservations(id, city, start, finish, threemeal, pool, funC);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public boolean deleteReservation(int reservationId) {
        String deleteSQL = "DELETE FROM reservations WHERE reservationID = ?";

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
