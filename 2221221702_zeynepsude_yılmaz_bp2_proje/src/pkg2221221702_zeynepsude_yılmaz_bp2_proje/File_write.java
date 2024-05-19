/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author zeysu
 */
public class File_write {
    String user_name;
    int room_number;
    String city ;
    Date baslangic ;
    Date bitis ;
    boolean threemeal;
    boolean pool;
    boolean funC;



    public File_write(String user_name, int room_number, String city, Date baslangic, Date bitis, boolean threemeal, boolean pool, boolean funC) {
        this.user_name = user_name;
        this.room_number = room_number;
        this.city = city;
        this.baslangic = baslangic;
        this.bitis = bitis;
        this.threemeal = threemeal;
        this.pool = pool;
        this.funC = funC;
        
        String dosyaYolu = "C:\\Users\\zeysu\\Desktop\\Hotel.txt";

        try {
            // FileWriter kullanarak dosyayı oluşturuyoruz (veya varsa üzerine yazarız)
            FileWriter dosyaYazici = new FileWriter(dosyaYolu);

            // BufferedWriter ile verileri daha hızlı yazmak için bir tampon oluşturuyoruz
            BufferedWriter tamponYazici = new BufferedWriter(dosyaYazici);

           

            // Metni dosyaya yazıyoruz
            tamponYazici.write(user_name +" "+ room_number+" "+ city+" "+ baslangic+" "+bitis+" "+threemeal+" "+pool+" "+funC );

            // Dosyayı kapatıyoruz
            tamponYazici.close();

            System.out.println("Dosyaya yazma işlemi tamamlandı.");
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
    }
 
}
