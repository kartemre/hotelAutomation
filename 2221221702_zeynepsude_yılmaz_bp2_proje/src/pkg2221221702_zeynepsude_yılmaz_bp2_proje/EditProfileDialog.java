package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emrekart
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditProfileDialog extends JDialog {

    private User user;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public EditProfileDialog(Frame parent, boolean modal, User user) {
        super(parent, modal);
        this.user = user;
        initComponents();
        displayUserInfo();
    }
    public User getUpdatedUser() {
        User updatedUser = new User();
        updatedUser.setName(firstNameField.getText());
        updatedUser.setSurname(lastNameField.getText());
        updatedUser.setEmail(emailField.getText());
        updatedUser.setPassword(new String(passwordField.getPassword()));
        updatedUser.setUsername(user.getUsername()); // Kullanıcı adını güncellemiyoruz

        return updatedUser;
    }


    private void initComponents() {
        setTitle("Edit Profile");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel firstNameLabel = new JLabel("Adınız:");
        panel.add(firstNameLabel);
        firstNameField = new JTextField();
        panel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Soyadınız:");
        panel.add(lastNameLabel);
        lastNameField = new JTextField();
        panel.add(lastNameField);

        JLabel emailLabel = new JLabel("Eposta:");
        panel.add(emailLabel);
        emailField = new JTextField();
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Şifre:");
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });
        panel.add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(cancelButton);

        add(panel);
    }

    private void displayUserInfo() {
        firstNameField.setText(user.getName());
        lastNameField.setText(user.getSurname());
        emailField.setText(user.getEmail());
        passwordField.setText(user.getPassword());
    }

    private void saveChanges() {
        String newFirstName = firstNameField.getText();
        String newLastName = lastNameField.getText();
        String newEmail = emailField.getText();
        String newPassword = new String(passwordField.getPassword());

    // DatabaseConnection sınıfındaki updateUser metodunu kullanarak güncelleme işlemini gerçekleştir
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.updateUser(user.getUsername(), newFirstName, newLastName, newEmail, newPassword);

    // Kullanıcı bilgilerini güncelle
        user.setName(newFirstName);
        user.setSurname(newLastName);
        user.setEmail(newEmail);
        user.setPassword(newPassword);

        dispose();
    }

}
