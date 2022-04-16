package com.example.andrometrixlite.ImageRes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.andrometrixlite.Courses.DataModel;
import com.example.andrometrixlite.Documentation.DocActivity;
import com.example.andrometrixlite.R;
import com.example.andrometrixlite.SampleCode.CodeDataModel;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.MyViewHolder> {
    private List<ImageDataModel> list;
    private ItemClickListener clickListener;


    public RecyclerViewAdapter1(ArrayList<ImageDataModel> list) {
        this.list = list;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_img_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.item_name.setText(list.get(position).getTitle());

        holder.item_info.setText(list.get(position).getInfo());
        holder.item_image.setImageResource(list.get(position).getPic());
        holder.website_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = gotoUrl(position);
                ImageResActivity.getInstance().startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
        holder.item_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri uri = gotoUrl(position);
//                ImageResActivity.getInstance().startActivity(new Intent(Intent.ACTION_VIEW, uri));
                Intent intent =new Intent(ImageResActivity.getInstance(), DocActivity.class);
                intent.putExtra("webId",position+10);
                ImageResActivity.getInstance().startActivity(intent);
            }
        });
        holder.ratingBar.setRating(list.get(position).getRating());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickListener.onItemClick(list.get(position));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
       TextView item_name,item_info;
       RatingBar ratingBar;
       ImageView item_image,website_btn;

        public MyViewHolder(View view) {
            super(view);
            website_btn =view.findViewById(R.id.website);
            ratingBar=view.findViewById(R.id.ratingBar);
           item_image=view.findViewById(R.id.item_image);
           item_name=view.findViewById(R.id.image_item_name);
           item_info=view.findViewById(R.id.image_item_info);
        }

    }

    public interface ItemClickListener {

        public void onItemClick(DataModel dataModel);
    }


    public Uri gotoUrl(int i){
        Uri uri3;
        if(i==0){
            final String Url1="https://unsplash.com/";
            uri3 = Uri.parse(Url1);
            return uri3;
        }
        if (i==1){
            final String Url2="https://www.flaticon.com/";
            uri3 = Uri.parse(Url2);
            return uri3;
        }
        if (i==2){
            final String Url3="https://icons8.com/";
            uri3 =Uri.parse(Url3);
            return uri3;
        }
        if (i==3){
            final String Url4="https://pixabay.com/";
            uri3 =Uri.parse(Url4);
            return uri3;
        }
        if (i==4){
            final String Url5="https://www.canva.com/";
            uri3=Uri.parse(Url5);
            return uri3;
        }
        if (i==5){
            final String Url6="https://www.pexels.com/";
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
