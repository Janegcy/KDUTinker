package com.example.kdutinker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PanoramaHallActivity extends AppCompatActivity {

    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;
    Button firstBtn,secondBtn,thirdBtn,forthBtn,fifthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama_hall);


        mInflater = LayoutInflater.from(this);
        initData();
        initView();


    }

    private void initData()
    {
        mImgIds = new int[] { R.drawable.panorama_hall};
    }
    private void initView()
    {
        mGallery = (LinearLayout) findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.length; i++)
        {

            View view = mInflater.inflate(R.layout.panorama_hall_image,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.id_index_gallery_item_text);
            txt.setText("info "+i);
            mGallery.addView(view);
        }
        firstBtn = (Button) findViewById(R.id.firstBtn);
        secondBtn = (Button)findViewById(R.id.secondBtn);
        thirdBtn = (Button) findViewById(R.id.thirdBtn);
        forthBtn = (Button) findViewById(R.id.forthBtn);
        fifthBtn = (Button) findViewById(R.id.fifthBtn);

        thirdBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent loginIntent = new Intent(PanoramaHallActivity.this,SeatPlanActivity.class);
            startActivity(loginIntent);
        }

    });
        forthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(PanoramaHallActivity.this,LightingPlanActivity.class);
                startActivity(loginIntent);
            }
        });

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(PanoramaHallActivity.this,ProjectorLayoutActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
