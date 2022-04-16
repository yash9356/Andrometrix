package com.example.andrometrixlite.Courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.andrometrixlite.R;

import java.util.ArrayList;


public class PaidCoursesFragment extends Fragment {

    static RecyclerAdapterClone1 adapter;
    private ArrayList<DataModel> list = new ArrayList<>();

    public PaidCoursesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view= inflater.inflate(R.layout.fragment_paidcourses, container, false);
        buildListData();
        initRecyclerView(view);
        return view;
    }



    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapterClone1(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void buildListData() {
        list.add(new DataModel("The Complete Android Oreo Developer Course - Build 23 Apps!",R.drawable.android_course1));
        list.add(new DataModel("Android Java Masterclass - Become an App Developer",R.drawable.android_course2));
        list.add(new DataModel("Android App Development Masterclass using Kotlin",R.drawable.android_course3));
        list.add(new DataModel("The Complete Android R + Java Developer Course™ : 2021",R.drawable.android_course4));

    }
    public static RecyclerAdapterClone1 getAdapterClone1(){
        return adapter;
    }
}