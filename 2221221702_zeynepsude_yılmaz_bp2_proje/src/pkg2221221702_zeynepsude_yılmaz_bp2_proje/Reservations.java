/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;

import java.util.Date;

/**
 *
 * @author zeysu
 */
public class Reservations {

    int id;
    String city;
    Date start;
    Date finish;
    boolean threemeal;
    boolean pool;
    boolean funC;

    public Reservations(int id, String city, Date start, Date finish, boolean threemeal, boolean pool, boolean funC) {
        this.city = city;
        this.start = start;
        this.finish = finish;
        this.id = id;
        this.threemeal = threemeal;
        this.pool = pool;
        this.funC = funC;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public void setThreemeal(boolean threemeal) {
        this.threemeal = threemeal;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public void setFunC(boolean funC) {
        this.funC = funC;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }

    public boolean isThreemeal() {
        return threemeal;
    }

    public boolean isPool() {
        return pool;
    }

    public boolean isFunC() {
        return funC;
    }
}
