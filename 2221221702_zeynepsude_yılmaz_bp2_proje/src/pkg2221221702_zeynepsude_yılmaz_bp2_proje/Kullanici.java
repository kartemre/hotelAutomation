/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

/**
 *
 * @author zeysu
 */
public class Kullanici {
     private String ad;
    private String soyad;
    private String user_name;
    private String mail;
    private String parola;
    private String cinsiyet;
    
      public Kullanici(String ad, String soyad,String user_name, String mail,String parola, String cinsiyet) {
        this.ad = ad;
        this.soyad = soyad;
        this.user_name=user_name;
        this.mail=mail;
        this.parola=parola;
        this.cinsiyet=cinsiyet;
    }
    public String getAd() {
        return ad;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getMail() {
        return mail;
    }

    public String getParola() {
        return parola;
    }
    
}
