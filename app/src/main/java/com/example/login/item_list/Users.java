package com.example.login.item_list;

public class Users {
     private String username, fullname;
    public Users(String username, String fullname){
        this.username = username;
        this.fullname = fullname;
    }
    public String getUsername(){
        return this.username;
    }
    public String getFullname(){
        return this.fullname;
    }
}
