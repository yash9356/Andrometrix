package com.example.andrometrixlite.Learning;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.andrometrixlite.R;


public class treeViewHolder {
    TextView textView;
    CardView cardView ;



    public treeViewHolder(View view) {
        textView =view.findViewById(R.id.textview);
        cardView =view.findViewById(R.id.cardview4);
    }
}
