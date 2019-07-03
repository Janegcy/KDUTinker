package com.example.kdutinker;

import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.kdutinker.Adapters.ViewPagerAdapter;
import com.example.kdutinker.fragments.FragmentClassroom;
import com.example.kdutinker.fragments.FragmentLab1;
import com.example.kdutinker.fragments.FragmentLecturehall;

public class MenuActivity extends AppCompatActivity {

        private TabLayout tablayout;
        private AppBarLayout appBarLayout;
        private ViewPager viewPager;
        ViewSwitcher switcher;
        ImageView first, second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        switcher = (ViewSwitcher) findViewById(R.id.switcher);
        first = (ImageView) findViewById(R.id.first);
        second = (ImageView) findViewById(R.id.second);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Adding fragments
        adapter.AddFragment(new FragmentLecturehall(),"Lecture Hall");
        adapter.AddFragment(new FragmentClassroom(),"Classroom");
        adapter.AddFragment(new FragmentLab1(),"Lab");
        //adapter setup
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                @DrawableRes int image = -1;
                switch (position){
                    case 0:
                        image = R.drawable.lecture_hall;
                        break;
                    case 1:
                        image = R.drawable.classroom;
                        break;
                    case 2:
                        image = R.drawable.lab;
                        break;

                }
                if (first.getVisibility() == View.VISIBLE) {
                    second.setImageResource(image);
                    switcher.showNext();
                } else {
                    first.setImageResource(image);
                    switcher.showPrevious();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tablayout.getTabAt(0).setIcon(R.drawable.hall_logo);
        tablayout.getTabAt(1).setIcon(R.drawable.classroomlogo);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_computer_black_24dp);

    }

}
