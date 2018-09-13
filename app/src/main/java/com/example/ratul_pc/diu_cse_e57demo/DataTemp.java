package com.example.ratul_pc.diu_cse_e57demo;

public class DataTemp {

    private int id;
    private String name;
    private String phone;

    public DataTemp(String n, String p) {
        name = n;
        phone = p;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
