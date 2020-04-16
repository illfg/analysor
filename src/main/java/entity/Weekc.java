package entity;

public class Weekc {
    private Integer id;

    private String year;

    private Integer week;

    private Integer month;

    private String day;

    private String hum;

    private Double acc40;

    private String tem;

    private String number;

    public Weekc() {
    }

    public Weekc(Integer id, String year, Integer week, Integer month, String day, String hum, Double acc40, String tem, String number) {
        this.id = id;
        this.year = year;
        this.week = week;
        this.month = month;
        this.day = day;
        this.hum = hum;
        this.acc40 = acc40;
        this.tem = tem;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum == null ? null : hum.trim();
    }

    public Double getAcc40() {
        return acc40;
    }

    public void setAcc40(Double acc40) {
        this.acc40 = acc40;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem == null ? null : tem.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }
}