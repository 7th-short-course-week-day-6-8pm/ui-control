package com.rathana.ui_control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {


    EditText userName,email,password;
    TextView tvUserName,tvEmail,tvPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUiObject();

        btnRegister.setOnClickListener(v->{
            String username=userName.getText().toString();
            String userEmail=email.getText().toString();
            String userPass=password.getText().toString();

            //set values to TextViews
            displayUserInfo(username,userEmail,userPass);

        });

    }

    private void displayUserInfo(String username,String email,String password){
        tvUserName.setText("User name : "+username);
        tvEmail.setText("User email : "+email);
        tvPassword.setText("password : "+password);
    }

    private void initUiObject(){
        userName=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        tvUserName=findViewById(R.id.tvUserName);
        tvEmail=findViewById(R.id.tvEmail);
        tvPassword=findViewById(R.id.tvPass);
        btnRegister=findViewById(R.id.btnRegister);
    }
}
