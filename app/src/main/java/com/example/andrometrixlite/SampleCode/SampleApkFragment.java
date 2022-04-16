package com.example.andrometrixlite.SampleCode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrometrixlite.R;

import java.util.ArrayList;


public class SampleApkFragment extends Fragment {
    private ArrayList<CodeDataModel> list = new ArrayList<>();


    public SampleApkFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sample_apk, container, false);
        return view;
    }
}