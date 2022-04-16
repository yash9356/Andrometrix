package com.example.andrometrixlite;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.andrometrixlite.Courses.MainActivity;

import com.example.andrometrixlite.CreateProject.ProjectCreationActivity;
import com.example.andrometrixlite.Documentation.DocActivity;
import com.example.andrometrixlite.ImageRes.ImageResActivity;
import com.example.andrometrixlite.Learning.LearningActivity;
import com.example.andrometrixlite.Profile.ProfileActivity;
import com.example.andrometrixlite.Query.QueryActivity;
import com.example.andrometrixlite.SampleCode.SampleCodeActivity;
import com.example.andrometrixlite.SpinWheel.SpinWheelActivity;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    RelativeLayout geek,stackoverflow,udemy,github;
    AppCompatButton gift_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.BlueCard));
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        geek =findViewById(R.id.geek_item);
        gift_btn =findViewById(R.id.gift_btn);
        stackoverflow =findViewById(R.id.stackover_flow_item);
        udemy =findViewById(R.id.udemy_item);
        github =findViewById(R.id.github_item);
        CardView project_create=findViewById(R.id.project_create_btn);
        project_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this, ProjectCreationActivity.class);
                //Intent intent =new Intent(HomeActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });
        ImageView learning = findViewById(R.id.learning);
//        if(Build.VERSION.SDK_INT>=21){
//            Window window=this.getWindow();
//            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
//        }
        learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this, LearningActivity.class);
                startActivity(intent);
            }
        });
        gift_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent(HomeActivity.this, SpinWheelActivity.class);
               startActivity(intent);
            }
        });
        geek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this, DocActivity.class);
                intent.putExtra("webId",1);
                startActivity(intent);
            }
        });
        stackoverflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this,DocActivity.class);
                intent.putExtra("webId",2);
                startActivity(intent);
            }
        });
        udemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this,DocActivity.class);
                intent.putExtra("webId",3);
                startActivity(intent);
            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this,DocActivity.class);
                intent.putExtra("webId",4);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.Courses){
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(id==R.id.Img_rersource){
            Intent intent=new Intent(this, ImageResActivity.class);
            startActivity(intent);
        }
       if (id==R.id.Buy_app){
           Toast.makeText(this,"buy Activity",Toast.LENGTH_SHORT).show();
       }
       if(id==R.id.Sample_Code){
           Intent intent=new Intent(HomeActivity.this, SampleCodeActivity.class);
           startActivity(intent);
       }
       if (id==R.id.Documentation){
           Intent intent1=new Intent(HomeActivity.this, DocActivity.class);
           startActivity(intent1);
       }
       if (id==R.id.Query){
           Intent intent =new Intent(HomeActivity.this, QueryActivity.class);
           startActivity(intent);
       }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem= menu.findItem(R.id.android_studio_btn);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //Toast.makeText(MainActivity2.this,"Done",Toast.LENGTH_SHORT).show();
                final Dialog dialog=new Dialog(HomeActivity.this);
                dialog.setContentView(R.layout.popup);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                ImageView closebtn=dialog.findViewById(R.id.close_btn);
                TextView instruction=dialog.findViewById(R.id.instru1);
                TextView instruction1=dialog.findViewById(R.id.instru);
                instruction1.setMovementMethod(LinkMovementMethod.getInstance());
                instruction.setMovementMethod(LinkMovementMethod.getInstance());
//
                closebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                return false;
            }
        });
        MenuItem menuItem1=menu.findItem(R.id.Setting_btn);
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent =new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}