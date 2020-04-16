package entity;

import java.util.Date;

public class Humidity {
    private Date now;

    private String hum;

    private String name;

    private String number;

    private Date time;

    public Humidity() {
    }

    public Humidity(Date now, String hum, String name, String number, Date time) {
        this.now = now;
        this.hum = hum;
        this.name = name;
        this.number = number;
        this.time = time;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum == null ? null : hum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}