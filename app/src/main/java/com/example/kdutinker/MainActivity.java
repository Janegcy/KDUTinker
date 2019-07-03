package com.example.kdutinker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class  MainActivity extends AppCompatActivity {
    LinearLayout top_splash,bottom_splash;
    TextView header, subheader;
    Button splashButton;
    Animation splash_updown,splash_downup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        header = findViewById(R.id.header);
        subheader = findViewById(R.id.subheader);
        splashButton = (Button)findViewById(R.id.splashButton);
        top_splash = (LinearLayout) findViewById(R.id.top_splash);
        bottom_splash = (LinearLayout) findViewById(R.id.bottom_splash);

        splash_updown = AnimationUtils.loadAnimation(this,R.anim.splash_updown);
        top_splash.setAnimation(splash_updown);

        splash_downup = AnimationUtils.loadAnimation(this,R.anim.splash_downup);
        bottom_splash.setAnimation(splash_downup);

        splashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });

    }
}
