package entity;

import java.util.Date;

public class Sudu40 {
    private Date now;

    private Double acc40;

    private Date time;

    private String number;

    private String name;

    public Sudu40() {
    }

    public Sudu40(Date now, Double acc40, Date time, String number, String name) {
        this.now = now;
        this.acc40 = acc40;
        this.time = time;
        this.number = number;
        this.name = name;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Double getAcc40() {
        return acc40;
    }

    public void setAcc40(Double acc40) {
        this.acc40 = acc40;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}