package ru.litvinov.diplom.models;

public class Slots {

    private int id;
    private String phoneNumber;
    private String name;
    private String day;
    private String time;

    public Slots() {
    }

    public Slots(String phoneNumber, String name, String day, String time, int id) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.day = day;
        this.time = time;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
