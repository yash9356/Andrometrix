package com.example.andrometrixlite.Query;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.example.andrometrixlite.Courses.PageAdapter;
import com.example.andrometrixlite.PageTransformer.DepthPageTransformer;
import com.example.andrometrixlite.R;


import com.google.android.material.tabs.TabLayout;

public class QueryActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    ConstraintLayout toolbartab;
    TabLayout tabLayout;
    private static QueryActivity INSTANCE;
    PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.DarkOrange1));
        toolbartab=findViewById(R.id.toolbartab3);
        tabLayout=findViewById(R.id.tablayout3);
        viewPager=findViewById(R.id.viewpager3);
        setSupportActionBar(toolbar);
        INSTANCE=this;
        pageAdapter=new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new StackoverflowFragment(),"Stack Overflow");
        pageAdapter.addFragment(new UserGroupFragment(),"Global Users");
        viewPager.setPageTransformer(true,new DepthPageTransformer());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}