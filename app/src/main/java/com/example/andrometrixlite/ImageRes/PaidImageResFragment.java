package com.example.andrometrixlite.ImageRes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.andrometrixlite.R;

import java.util.ArrayList;


public class PaidImageResFragment extends Fragment {
    private ArrayList<ImageDataModel> list = new ArrayList<>();

    public PaidImageResFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_paid_image_res, container, false);
        buildListData();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview2);
//        GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),2);
//        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//
//        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter1 adapter1=new RecyclerViewAdapter1(list);
        recyclerView.setAdapter(adapter1);
    }

    private void buildListData() {
        list.add(new ImageDataModel("shutterstock",R.drawable.shutterstock_res,"Pictures & Icons",4.0f));
        list.add(new ImageDataModel("Shopify",R.drawable.shopify,"Pictures",2.5f));
    }
}