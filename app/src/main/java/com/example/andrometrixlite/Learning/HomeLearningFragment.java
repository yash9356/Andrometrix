package com.example.andrometrixlite.Learning;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


import com.example.andrometrixlite.ImageRes.ImageDataModel;
import com.example.andrometrixlite.R;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeLearningFragment extends Fragment {
    ExpandableListView expandableListView;
    ArrayList<String> listGroup =new ArrayList<>();
    HashMap<String,ArrayList<String>> listchild =new HashMap<>();
    AppCompatButton beginner_btn,Intermediate_btn,pro_btn;
    RecyclerView recyclerView;
    private ArrayList<InstructionDataModel> list = new ArrayList<>();

    public HomeLearningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home_learning, container, false);
//       expandableListView = view.findViewById(R.id.expandable_listView);
//       for (int j=0;j<=10;j++){
//           listGroup.add("Group"+Integer.toString(j));
//       }
        recyclerView =view.findViewById(R.id.recyclerview_course_Instr);
        beginner_btn = view.findViewById(R.id.beginner_coursebtn);
        Intermediate_btn = view.findViewById(R.id.intermediate_coursebtn);
        pro_btn = view.findViewById(R.id.pro_coursebtn);

        list.add(new InstructionDataModel("Install Android Studio",true));
        list.add(new InstructionDataModel("Open Android Studio",true));
        list.add(new InstructionDataModel("Close Android Studio",true));
        list.add(new InstructionDataModel("Close Android Studio",true));
        list.add(new InstructionDataModel("Close Android Studio",true));
        list.add(new InstructionDataModel("Close Android Studio",true));
        list.add(new InstructionDataModel("Close Android Studio",true));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseInstruction_RecyclerAdapter adapter =new CourseInstruction_RecyclerAdapter(list);
        beginner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(adapter);
            }
        });

       return view;
    }
}