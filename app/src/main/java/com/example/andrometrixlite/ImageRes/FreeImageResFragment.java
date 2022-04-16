package com.example.andrometrixlite.ImageRes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.andrometrixlite.R;

import java.util.ArrayList;


public class FreeImageResFragment extends Fragment {
    private ArrayList<ImageDataModel> list = new ArrayList<>();


    public FreeImageResFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_free_image_res, container, false);
        buildListData();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview1);
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
       list.add(new ImageDataModel("Unsplash",R.drawable.unsplash_img,"Pictures",4.0f));
        list.add(new ImageDataModel("Flaticon",R.drawable.flaticon_res,"Icons",4.0f));
        list.add(new ImageDataModel("Icon8",R.drawable.icon8_res,"Icons",3.5f));
        list.add(new ImageDataModel("pixabay",R.drawable.pixabay_res,"Pictures",3.5f));
        list.add(new ImageDataModel("canva",R.drawable.canva_res,"Pictures & Icons",3.0f));
        list.add(new ImageDataModel("pexel",R.drawable.pixels,"Pictures",3.0f));

    }
}