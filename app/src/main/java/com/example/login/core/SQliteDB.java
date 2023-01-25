package com.example.login.core;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

public class SQliteDB {
    public static SQLiteDatabase getDB(){
        return  SQLiteDatabase.openDatabase(Environment.getExternalStorageDirectory() +
                "/Login/login_db.db", null, SQLiteDatabase.NO_LOCALIZED_COLLATORS
                | SQLiteDatabase.OPEN_READWRITE);
    }
}
