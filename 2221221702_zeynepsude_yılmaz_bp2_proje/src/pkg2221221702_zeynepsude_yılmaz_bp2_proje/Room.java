/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

/**
 *
 * @author zeysu
 */
public class Room{
    private int odaNumarasi;
    private int kapasite;
    private double fiyat;

    public Room(int odaNumarasi, int kapasite, double fiyat) {
        this.odaNumarasi = odaNumarasi;
        this.kapasite = kapasite;
        this.fiyat = fiyat;
    }

    public int getOdaNumarasi() {
        return odaNumarasi;
    }

    public void setOdaNumarasi(int odaNumarasi) {
        this.odaNumarasi = odaNumarasi;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
    
class SingleRoom extends Room {
    public SingleRoom(int roomNumber, double price) {
        super(roomNumber, 1, price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom(int roomNumber, double price) {
        super(roomNumber, 2, price);
    }
}

class TripleRoom extends Room {
    public TripleRoom(int roomNumber, double price) {
        super(roomNumber, 3, price);
    }
}
