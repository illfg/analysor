package entity;

import java.util.Date;

public class Temperature {
    private Date now;

    private String tem;

    private Date time;

    private String name;

    private String number;

    public Temperature() {
    }

    public Temperature(Date now, String tem, Date time, String name, String number) {
        this.now = now;
        this.tem = tem;
        this.time = time;
        this.name = name;
        this.number = number;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem == null ? null : tem.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
}