package com.example.kdutinker.Lists;

public class Classroom {
    private String Name;
    private int Photo;

    public Classroom() {
    }

    public Classroom(String name, int photo) {
        Name = name;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
