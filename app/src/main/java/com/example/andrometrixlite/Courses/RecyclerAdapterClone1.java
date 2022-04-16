package com.example.andrometrixlite.Courses;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.andrometrixlite.R;

import java.util.ArrayList;

public class RecyclerAdapterClone1 extends RecyclerView.Adapter<RecyclerAdapterClone1.MyViewHolder> implements Filterable  {


    ArrayList<DataModel> newsArrayList;
    ArrayList<DataModel> newsArrayListFull;

    public RecyclerAdapterClone1(ArrayList<DataModel> newsArrayList) {

        this.newsArrayListFull = newsArrayList;
        this.newsArrayList = new ArrayList<>(newsArrayListFull);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        DataModel news = newsArrayList.get(position);
        holder.titleTextView.setText(news.getTitle());
        holder.imageView.setImageResource(news.getPic());
        holder.infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(MainActivity.getINSTANCE());
                dialog.setContentView(R.layout.popup_info);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                ImageView closebtn=dialog.findViewById(R.id.close_btn);
                TextView course_name=dialog.findViewById(R.id.course_item_name);
                TextView course_info=dialog.findViewById(R.id.course_item_info);
                TextView course_mode=dialog.findViewById(R.id.course_item_type);
                TextView course_source=dialog.findViewById(R.id.course_item_source);
                course_source.setText("Google");
                course_mode.setText("Beginner");
                course_info.setText("This course is designed for students who are new to programming, and want to learn how to build Android apps." +
                        " You don’t need any programming experience to take this course. ");
                ImageView course_img=dialog.findViewById(R.id.course_item_img);
                course_img.setImageResource(news.getPic());
                course_name.setText(news.getTitle());
                course_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = gotoUrl(position);
                        MainActivity.getINSTANCE().startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                });

                closebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = gotoUrl(position);
                MainActivity.getINSTANCE().startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return newsFilter;
    }

    private final Filter newsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<DataModel> filteredNewsList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){

                filteredNewsList.addAll(newsArrayListFull);

            }else {

                String filterPattern = constraint.toString().toLowerCase().trim();

                for (DataModel news : newsArrayListFull){

                    if (news.getTitle().toLowerCase().contains(filterPattern))
                        filteredNewsList.add(news);

                }

            }

            FilterResults results = new FilterResults();
            results.values = filteredNewsList;
            results.count = filteredNewsList.size();
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {


            newsArrayList.clear();
            newsArrayList.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        ImageButton infobtn;
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            infobtn=view.findViewById(R.id.infobtn);
            imageView=view.findViewById(R.id.course_image);
            titleTextView = view.findViewById(R.id.course_name);
        }
    }

    public Uri gotoUrl(int i){
        Uri uri3;
        if(i==0){
            final String Url1="https://www.udacity.com/course/android-basics-user-interface--ud834";
            uri3 = Uri.parse(Url1);
            return uri3;
        }
        if (i==1){
            final String Url2="https://www.udacity.com/course/android-basics-user-input--ud836";
            uri3 = Uri.parse(Url2);
            return uri3;
        }
        if (i==2){
            final String Url3="https://www.udacity.com/course/android-basics-multiscreen-apps--ud839";
            uri3 =Uri.parse(Url3);
            return uri3;
        }
        if (i==3){
            final String Url4="https://www.udacity.com/course/android-basics-networking--ud843";
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
