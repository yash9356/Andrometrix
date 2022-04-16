package com.example.andrometrixlite.SampleCode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.andrometrixlite.R;

import java.util.ArrayList;


public class SampleCodeFragment extends Fragment {
    private ArrayList<CodeDataModel> list = new ArrayList<>();

    public SampleCodeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sample_code, container, false);
        buildListData();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview8);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter3 adapter = new RecyclerViewAdapter3(list);
        recyclerView.setAdapter(adapter);
    }

    private void buildListData() {
        list.add(new CodeDataModel("Webview",R.drawable.www));
        list.add(new CodeDataModel("Textbox",R.drawable.text));
        list.add(new CodeDataModel("Password",R.drawable.password));
        list.add(new CodeDataModel("Checkbox",R.drawable.checkbox));
        list.add(new CodeDataModel("Listview",R.drawable.list));

    }


}