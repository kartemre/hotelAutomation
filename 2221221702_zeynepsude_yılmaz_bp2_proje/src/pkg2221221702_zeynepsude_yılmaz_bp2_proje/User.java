/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

/**
 *
 * @author emrekart
 */
public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String username; // Kullanıcı adı alanı eklendi
    private String gender;   // Cinsiyet alanı eklendi

    // Getter ve Setter metodları her bir alan için
    public User() {}

    public User(String name, String surname, String email, String password, String username, String gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

