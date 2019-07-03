package com.example.kdutinker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kdutinker.Database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    Button sign_Up2;
    EditText email_new, password_new, password_new2;
    AutoCompleteTextView autoTextView;
    TextView sign_In2;
    DatabaseHelper db;

    private static final String [] COURSES = new String[]{
            "Diploma in Mechanical Engineering","Diploma in Computer Studies","Diploma in Communication & Media","Diploma in Accountancy",
            "Bachelor of Computer Science","Bachelor of Business"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        sign_Up2 = (Button) findViewById(R.id.sign_Up2);
        email_new = (EditText) findViewById(R.id.email_new);
        password_new = (EditText) findViewById(R.id.password_new);
        password_new2 = (EditText) findViewById(R.id.password_new2);
        autoTextView = (AutoCompleteTextView) findViewById(R.id.autoTextView);
        sign_In2 = (TextView) findViewById(R.id.sign_In2);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,COURSES);
        autoTextView.setAdapter(adapter);

        sign_In2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        sign_Up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_new.getText().toString().trim();
                String pwd= password_new.getText().toString().trim();
                String cfm_pwd = password_new2.getText().toString().trim();

                if(pwd.equals(cfm_pwd)){
                    long val = db.addUser(email,pwd);
                    if (val >0){
                        Toast.makeText(RegisterActivity.this,"Successful Registration",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
