package com.example.sqlitedbexample;

public class Contact {

    int id;
    String name;
    String email;
    public Contact(){   }
    public Contact(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Contact(String name, String email){
        this.name = name;
        this.email = email;
    }

    public int get_id() {
        return id;
    }

    public void set_id(int _id) {
        this.id = _id;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String _name) {
        this.name = _name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
