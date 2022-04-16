package com.example.andrometrixlite.Learning;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.andrometrixlite.R;

import de.blox.treeview.BaseTreeAdapter;
import de.blox.treeview.TreeNode;
import de.blox.treeview.TreeView;


public class RoadMapFragment extends Fragment {


    public RoadMapFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_road_map, container, false);
        TreeView treeView =view.findViewById(R.id.treeview);
        SharedPreferences setting = getActivity().getSharedPreferences("Cardviewcolor",Context.MODE_PRIVATE);
        int colorId=setting.getInt("ColorId",0);
        BaseTreeAdapter<treeViewHolder> adapter =new BaseTreeAdapter<treeViewHolder>(getContext(),R.layout.node){

            @NonNull
            @Override
            public treeViewHolder onCreateViewHolder(View view) {
                return new treeViewHolder(view);
            }

            @Override
            public void onBindViewHolder(treeViewHolder viewHolder, Object data, int position) {
                viewHolder.textView.setText(data.toString());
                viewHolder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        viewHolder.cardView.setCardBackgroundColor(ContextCompat.getColor(LearningActivity.getInstance(),R.color.colorPrimary));
                        return false;
                    }
                });
                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog dialog =new Dialog(LearningActivity.getInstance());
                        dialog.setContentView(R.layout.roadmap_popup);
//                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        TextView documentation =dialog.findViewById(R.id.Topic_Documentation);
                        ImageView youtube_video =dialog.findViewById(R.id.Topic_video);
                        TextView Topic_name=dialog.findViewById(R.id.RoadMap_Topic);
                        youtube_video.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent =new Intent(LearningActivity.getInstance(),YoutubeVideoActivity.class);
                                startActivity(intent);
                            }
                        });

                        Topic_name.setText(data.toString());
                        dialog.show();
                    }
                });
            }
        };
        treeView.setAdapter(adapter);
        TreeNode rootnode =new TreeNode("Programming");
        TreeNode child1 =new TreeNode("Java");
        TreeNode child5 =new TreeNode("Kotlin");
        TreeNode child2 =new TreeNode("▼");
        TreeNode child3 =new TreeNode("Android Studio");
        TreeNode child4 =new TreeNode("Android Studio IDE overview");
        TreeNode child6 =new TreeNode("Project Structure");
        TreeNode child7 =new TreeNode("Java/kotin");
        TreeNode child8 =new TreeNode("xml");
        TreeNode child9 =new TreeNode(".gradle files");
        TreeNode child10 =new TreeNode("▼");
        TreeNode child14 =new TreeNode("Android components");
        TreeNode child11 =new TreeNode("Service");
        TreeNode child12 =new TreeNode("Broad cast receiver");
        TreeNode child13 =new TreeNode("content provider");
        TreeNode child15 =new TreeNode("Activity");
        TreeNode child16 =new TreeNode("Activity LifeCycle");
        TreeNode child17 =new TreeNode("Task & back stack");
        TreeNode child18 =new TreeNode("▼");
        TreeNode Intent =new TreeNode("Intent");
        TreeNode Intent1 =new TreeNode("Types of Intent");
        TreeNode IntentType1 =new TreeNode("Implicit");
        TreeNode IntentType2 =new TreeNode("Explicit");
        TreeNode Intent2 =new TreeNode("Intent filters");
        TreeNode Intent_next =new TreeNode("▼");
        TreeNode Static_user =new TreeNode("Static User Interface");
        child2.addChild(child3);
        child3.addChild(child4);
        child3.addChild(child10);
        child3.addChild(child6);
        child6.addChild(child7);
        child6.addChild(child8);
        child6.addChild(child9);
        Intent.addChild(Intent1);
        Intent.addChild(Intent_next);
        Intent1.addChild(IntentType1);
        Intent1.addChild(IntentType2);
        Intent.addChild(Intent2);
        Intent_next.addChild(Static_user);


        child15.addChild(child16);
        child15.addChild(child17);
        child10.addChild(child14);
        child14.addChild(child15);
        child14.addChild(child18);
        child14.addChild(child11);
        child14.addChild(child12);
        child14.addChild(child13);
        child18.addChild(Intent);


        rootnode.addChild(child1);
        rootnode.addChild(child2);
        rootnode.addChild(child5);
        adapter.setRootNode(rootnode);
        return view;
    }
}