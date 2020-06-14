package com.example.handinapp.Model;

public class Food {

    private String title;
    private int id;

    public Food(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
