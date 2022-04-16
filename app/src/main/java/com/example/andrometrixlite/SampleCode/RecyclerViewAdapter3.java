package com.example.andrometrixlite.SampleCode;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.andrometrixlite.Courses.DataModel;
import com.example.andrometrixlite.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewAdapter3.MyViewHolder> {
    private List<CodeDataModel> list;
    private ItemClickListener clickListener;


    public RecyclerViewAdapter3(List<CodeDataModel> list) {
        this.list = list;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_code, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.imageView.setImageResource(list.get(position).getPic());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CircleImageView download_btn,imageView;
        public MyViewHolder(View view) {
            super(view);
            download_btn=view.findViewById(R.id.download_btn);
            imageView=view.findViewById(R.id.code_image);
            title = view.findViewById(R.id.item_name7);
        }

    }

    public interface ItemClickListener {

        public void onItemClick(DataModel dataModel);
    }


    public Uri gotoUrl(int i){
        Uri uri3;
        if(i==0){
            final String Url1="https://www.udemy.com/course/the-complete-android-oreo-developer-course/";
            uri3 = Uri.parse(Url1);
            return uri3;
        }
        if (i==1){
            final String Url2="https://www.udemy.com/course/master-android-7-nougat-java-app-development-step-by-step/";
            uri3 = Uri.parse(Url2);
            return uri3;
        }
        if (i==2){
            final String Url3="https://www.udemy.com/course/android-oreo-kotlin-app-masterclass/";
            uri3 =Uri.parse(Url3);
            return uri3;
        }
        if (i==3){
            final String Url4="https://www.udemy.com/course/java-android-complete-guide/";
            uri3 =Uri.parse(Url4);
            return uri3;
        }
        if (i==4){
            final String Url5="https://www.udacity.com/course/android-basics-data-storage--ud845";
            uri3=Uri.parse(Url5);
            return uri3;
        }
        if (i==5){
            final String Url6="https://www.udacity.com/course/new-android-fundamentals--ud851";
            uri3=Uri.parse(Url6);
            return uri3;
        }
        if (i==6){
            final String Url7="https://www.udacity.com/course/advanced-android-app-development--ud855";
            uri3=Uri.parse(Url7);
            return uri3;
        }
        if (i==7){
            final String Url8="https://www.udacity.com/course/firebase-in-a-weekend-by-google-android--ud0352";
            uri3=Uri.parse(Url8);
            return uri3;
        }
        if (i==8){
            final String Url9="https://www.udacity.com/course/material-design-for-android-developers--ud862";
            uri3=Uri.parse(Url9);
            return uri3;
        }
        else {
            return null;
        }

    }
}
