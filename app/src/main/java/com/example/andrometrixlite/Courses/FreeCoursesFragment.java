package com.example.andrometrixlite.Courses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.example.andrometrixlite.R;

import java.util.ArrayList;


public class FreeCoursesFragment extends Fragment {

    private ArrayList<DataModel> list = new ArrayList<>();

    static RecyclerAdapterClone1 adapterClone1;
    public FreeCoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //setHasOptionsMenu(true);
        View view= inflater.inflate(R.layout.fragment_freecourses, container, false);
        buildListData();
        initRecyclerView(view);
        return view;
    }




    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        //RecyclerViewAdapterClone adapter = new RecyclerViewAdapter(list);
//        recyclerView.setAdapter(adapter);
        adapterClone1 =new RecyclerAdapterClone1(list);
        recyclerView.setAdapter(adapterClone1);
        adapterClone1.notifyDataSetChanged();
    }

    private void buildListData() {
        list.add(new DataModel("User Interface",R.drawable.course_user_interface));
        list.add(new DataModel("User Input",R.drawable.courses_img10));
//        list.add(new DataModel("Multiscreen Apps",R.drawable.img6));
        list.add(new DataModel("Multiscreen Apps",R.drawable.multiscreen_img));
//        list.add(new DataModel("Networking course",R.drawable.courses_img14));
        list.add(new DataModel("Networking course",R.drawable.web_networking));
        list.add(new DataModel("Data Storage course",R.drawable.course_data_storage));
        list.add(new DataModel("Developing Android Apps course",R.drawable.app_img));
        list.add(new DataModel("Advanced Android App Development",R.drawable.courses_img16));
        list.add(new DataModel("Firebase in a weekend",R.drawable.firebase_img));
        list.add(new DataModel("Material Design Course",R.drawable.image14));
    }

    public static RecyclerAdapterClone1 getAdapterClone1(){
        return adapterClone1;
    }



}