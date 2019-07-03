package com.example.kdutinker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kdutinker.Database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    Button signUp,loginBtn;
    EditText enter_email,enter_password;
    CheckBox rmb_me;
    TextView forgot_password;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        signUp = (Button)findViewById(R.id.signUp);
        enter_email = (EditText)findViewById(R.id.enter_email);
        enter_password = (EditText)findViewById(R.id.enter_password);
        rmb_me = (CheckBox)findViewById(R.id.rmb_me);
        forgot_password = (TextView)findViewById(R.id.forgot_password);

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotpwIntent = new Intent(LoginActivity.this,PwActivity.class);
                startActivity(forgotpwIntent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = enter_email.getText().toString().trim();
                String pwd = enter_password.getText().toString().trim();
                Boolean res = db.checkUser(email, pwd);
                if (res == true){
                    Intent loginIntent = new Intent(LoginActivity.this,MenuActivity.class);
                    startActivity(loginIntent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Incorrect Email or Password",Toast.LENGTH_SHORT).show();
                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(signUpIntent);
            }
        });
    }
}
