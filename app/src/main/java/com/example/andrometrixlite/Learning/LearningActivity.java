package com.example.andrometrixlite.Learning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.andrometrixlite.R;


public class LearningActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    public  static  LearningActivity Instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        Instance =this;

        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.NavyBlue));
        bottomNavigation =findViewById(R.id.bottom_navigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_about));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.route));
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:
                        fragment =new AboutLearningFragment();
                        break;
                    case 2:
                        fragment =new HomeLearningFragment();
                        break;
                    case 3:
                        fragment =new RoadMapFragment();
                        break;
                }
                londFragment(fragment);
            }
        });

        bottomNavigation.setCount(1,"10");
        bottomNavigation.show(2,true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "You Clicked "+item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"You Reselected"+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void londFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }

    public static LearningActivity getInstance(){
        return Instance;
    }
}