package com.example.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.model.UserModel;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btn_login;
    UserModel userModel;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        getSupportActionBar().setTitle("Login");

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        userModel = new UserModel();

        btn_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(userModel.Authentication(username.getText().toString(), password.getText().toString())) {
                     Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                     startActivity(intent);
                     finish();
                 }else{
                     Snackbar.make(view, "Login Failed",Snackbar.LENGTH_SHORT).show();
                 }
             }
         });
    }
}