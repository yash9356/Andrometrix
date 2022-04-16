package com.example.andrometrixlite.Courses;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.andrometrixlite.PageTransformer.DepthPageTransformer;
import com.example.andrometrixlite.R;

import com.google.android.material.tabs.TabLayout;



public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    ConstraintLayout toolbartab;
    TabLayout tabLayout;
    int a;
     RecyclerAdapterClone1 myAdapter;
    private static MainActivity INSTANCE;
    PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar7);
        toolbartab=findViewById(R.id.toolbartab);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);
        INSTANCE=this;
        pageAdapter=new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new FreeCoursesFragment(),"Free Courses");
        pageAdapter.addFragment(new PaidCoursesFragment(),"Paid Courses");


        viewPager.setPageTransformer(true,new DepthPageTransformer());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        a=0;
                        myAdapter =FreeCoursesFragment.getAdapterClone1();

                        break;
                    case 1:
                        a=1;
                        myAdapter =PaidCoursesFragment.getAdapterClone1();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search Here!");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if(a==0){
                    myAdapter =FreeCoursesFragment.getAdapterClone1();
                }else {
                    myAdapter =PaidCoursesFragment.getAdapterClone1();
                }
               myAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public static MainActivity getINSTANCE() {
        return INSTANCE;
    }
}