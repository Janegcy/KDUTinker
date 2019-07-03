package com.example.kdutinker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PwActivity extends AppCompatActivity {
     Button submitBtn;
     EditText enter_email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw);

        submitBtn = (Button)findViewById(R.id.submit_Btn);
        enter_email2 = (EditText)findViewById(R.id.enter_email2);

    }
}
