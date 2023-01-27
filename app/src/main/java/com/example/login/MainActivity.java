package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.login.adapter.UsersAdapter;
import com.example.login.item_list.Users;
import com.example.login.model.UserModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_users;
    public static Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Home");

        activity = this;

        UserModel model = new UserModel();
        model.addUser("mhae","mhae","MHAE");
        List<Users> userlist = model.getUsers();
        UsersAdapter adapter = new UsersAdapter(userlist);

        rv_users = findViewById(R.id.rv_users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        rv_users.setLayoutManager(linearLayoutManager);
        rv_users.setAdapter(adapter);
        //new branch
        //new branch
    }
}