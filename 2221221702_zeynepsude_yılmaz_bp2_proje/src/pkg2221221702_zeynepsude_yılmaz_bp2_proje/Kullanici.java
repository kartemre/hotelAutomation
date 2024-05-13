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
    private String mail;
    private String parola;
    
      public Kullanici(String ad, String soyad, String mail,String parola ) {
        this.ad = ad;
        this.soyad = soyad;
        this.mail=mail;
        this.parola=parola;
    }
    public String getAd() {
        return ad;
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
