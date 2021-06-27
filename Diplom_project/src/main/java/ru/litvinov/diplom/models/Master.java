package ru.litvinov.diplom.models;

public class Master {

    private int id;
    private String name;
    private String area;
    private String bio;

    public Master() {
    }

    public Master(int id, String name, String area, String bio) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
