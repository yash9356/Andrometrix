package com.example.andrometrixlite.CreateProject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.andrometrixlite.ImageRes.ImageDataModel;
import com.example.andrometrixlite.ImageRes.RecyclerViewAdapter1;
import com.example.andrometrixlite.R;
import com.example.andrometrixlite.SampleCode.CodeDataModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProjectCreationActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private String[] items;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> lstTitle;
    RecyclerView recyclerView;
    private ArrayList<CodeDataModel> list = new ArrayList<>();
    private Map<String,List<String>> lstChild;
    private FragmentNavigationManager navigationManager;
    private static ProjectCreationActivity Instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_creation);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.projectBlue));
        Toolbar toolbar=findViewById(R.id.toolbar9);
        setSupportActionBar(toolbar);
        Instance =this;
        list.add(new CodeDataModel("title",R.drawable.www));
        list.add(new CodeDataModel("title1",R.drawable.www));
        //RecyclerViewAdapter71 adapter1=new RecyclerViewAdapter71(this,list);
        RecyclerViewAdapter7 adapter1=new RecyclerViewAdapter7(list);
        recyclerView = findViewById(R.id.create_project_recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter1);
        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle =getTitle().toString();
        expandableListView=(ExpandableListView) findViewById(R.id.navList);
        //navigationManager =FragmentNavigationManager.getInstance(this);
        initItems();
         //
        View listHeaderView = getLayoutInflater().inflate(R.layout.expandablelist_nav_header,null,false);
        expandableListView.addHeaderView(listHeaderView);
        genData();

        addDrawerItem();
        setupDrawer();

        if (savedInstanceState == null)
            selectFirstItemAsDefault();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Android Dev");
    }

    private void selectFirstItemAsDefault() {
        String firstItem =lstTitle.get(0);
        getSupportActionBar().setTitle(firstItem);

//        if (navigationManager !=null){
//            String firstItem =lstTitle.get(0);
//            navigationManager.showFragment(firstItem);
//            getSupportActionBar().setTitle(firstItem);
//        }
    }

    private void setupDrawer() {
        mDrawerToggle =new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Android Dev");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void addDrawerItem() {
        adapter= new CustomExpandableListAdapter(this,lstTitle,lstChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                getSupportActionBar().setTitle(lstTitle.get(groupPosition).toString());

            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                getSupportActionBar().setTitle("Android Dev");
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String selectedItem =((List)(lstChild.get(lstTitle.get(groupPosition))))
                        .get(childPosition).toString();
                getSupportActionBar().setTitle(selectedItem);
                Toast.makeText(ProjectCreationActivity.this, selectedItem+" is added in your project.", Toast.LENGTH_SHORT).show();
                //Recyclerview operation
                list = addprojectcomponent(selectedItem,list);
                RecyclerViewAdapter7 adapter1=new RecyclerViewAdapter7(list);
                adapter1.notifyDataSetChanged();
                recyclerView.setAdapter(adapter1);

                mDrawerLayout.closeDrawer(GravityCompat.START);


                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    public static ProjectCreationActivity getInstance(){
        return Instance;
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void genData() {
        List<String> title= Arrays.asList("Android UI widgets","Android Toast","Android Intent","Android Fragment","Android Containers");
        List<String> childitem1 =Arrays.asList("ProgressBar","RatingBar","Spinner","SeekBar","TextSwitcher","ImageSwitcher","AdapterViewFlipper");
        List<String> childitem2 =Arrays.asList("Simple Toast","Custom Toast","Positioning Toast");
        List<String> childitem3 =Arrays.asList("Change Activity","Launch whatsapp","Launch Email","Launch PlayStore","Launch Maps");
        List<String> childitem4 =Arrays.asList("List Fragment","Change Fragment","Dialog Fragment","Passbetween Fragment");
        List<String> childitem5 =Arrays.asList("ListView","GridView","Webview","SearchView");
        lstChild =new TreeMap<>();
        lstChild.put(title.get(0),childitem5);
        lstChild.put(title.get(1),childitem4);
        lstChild.put(title.get(2),childitem3);
        lstChild.put(title.get(3),childitem2);
        lstChild.put(title.get(4),childitem1);

        lstTitle =new ArrayList<>(lstChild.keySet());
    }

    private void initItems() {
        items =new String[]{"Android UI widgets","Android Toast","Android Intent","Android Fragment","Android Containers"};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_normal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        if (mDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<CodeDataModel> addprojectcomponent(String title,ArrayList<CodeDataModel> list){
        list.add(new CodeDataModel(title,R.drawable.www));
        return list;

    }
}