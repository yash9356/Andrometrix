package com.example.andrometrixlite.ImageRes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;


import com.example.andrometrixlite.Courses.PageAdapter;
import com.example.andrometrixlite.PageTransformer.DepthPageTransformer;
import com.example.andrometrixlite.R;


import com.google.android.material.tabs.TabLayout;

public class ImageResActivity extends AppCompatActivity {
    public static ImageResActivity INSTANCE;
    ViewPager viewPager;
    ConstraintLayout toolbartab;
    TabLayout tabLayout;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_image_res);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.DarkBlue));
        INSTANCE =this;
        toolbartab=findViewById(R.id.toolbartab1);
        tabLayout=findViewById(R.id.tablayout1);
        viewPager=findViewById(R.id.viewpager1);


        pageAdapter=new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new FreeImageResFragment(),"Free ");
        pageAdapter.addFragment(new PaidImageResFragment(),"Paid ");


        viewPager.setPageTransformer(true,new DepthPageTransformer());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
//                        getWindow().setStatusBarColor(Color.GRAY);
//                        toolbar.setBackgroundColor(Color.GRAY);
//                        toolbartab.setBackgroundColor(Color.GRAY);
//                        tabLayout.setBackgroundColor(Color.GRAY);

                        break;
                    case 1:
//                        getWindow().setStatusBarColor(R.color.colorPrimaryDark);
//                        toolbar.setBackgroundColor(Color.GREEN);
//                        toolbartab.setBackgroundColor(Color.GREEN);
//                        tabLayout.setBackgroundColor(Color.GREEN);
                        break;
//
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public static ImageResActivity getInstance(){
        return INSTANCE;
    }
}