package com.example.login.model;
import  android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.login.core.SQliteDB;
import com.example.login.item_list.Users;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    List<Users> usersList = new ArrayList<>();
    public boolean addUser(String username, String password, String full_name){
        boolean result = false;
        SQLiteDatabase db = SQliteDB.getDB();
        String query ="INSERT INTO tbl_users(username, password, full_name)" +
                "VALUES ('"+username+"','"+password+"','"+full_name+"')";
        try{
            db.execSQL(query);
            result = true;
        }catch (Exception e){

        }
        return result;
    }
    public String showUsers(){
        String users =  "";
        SQLiteDatabase db = SQliteDB.getDB();
        boolean authenticated = false;
        String query = "Select * From tbl_users";
        try{
            Cursor cursor = db.rawQuery(query,null);
            if(cursor.moveToFirst()){
                do {
                    users += cursor.getString(1) + " " + cursor.getString(3) + "\n";
                }while (cursor.moveToNext());
            }else{

            }
        }catch (Exception e){}
        db.close();
        return users;
    }

    public boolean Authentication(String username, String password){
        SQLiteDatabase db = SQliteDB.getDB();
        boolean authenticated = false;
        String query = "Select full_name From tbl_users" + " WHERE username ='"+username+"' " +
                " AND password ='"+password+"'";
        try{
            Cursor cursor = db.rawQuery(query,null);
            if(cursor.moveToFirst()){
                if(cursor.getString(0)==null)
                    return  false;
                authenticated = true;
            }else{
                return false;
            }
        }catch (Exception e){}
        db.close();
        return authenticated;

    }

    public List<Users> getUsers(){
        SQLiteDatabase db = SQliteDB.getDB();
        String sql = "SELECT username, full_name FROM tbl_users";
        Cursor cursor = db.rawQuery(sql,null);


        if(cursor.moveToFirst()){
            do{
                String username = cursor.getString(0);
                String fullname = cursor.getString(1);

                //new item

                usersList.add(new  Users(username,fullname));
            }while (cursor.moveToNext());
        }
        db.close();
        return usersList;
    }
}
