package com.example.handinapp.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "register_table")
public class Register {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String email;
    private String phonenumber;
    private String date;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Register(String name, String email, String  phonenumber, String date) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getDate() {
        return date;
    }
}
