package com.example.andrometrixlite.Learning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andrometrixlite.R;

import java.util.List;

public class CourseInstruction_RecyclerAdapter extends RecyclerView.Adapter<CourseInstruction_RecyclerAdapter.MyViewHolder> {
    private List<InstructionDataModel> list;

    public CourseInstruction_RecyclerAdapter(List<InstructionDataModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.beginner_course_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.instructions.setText(list.get(position).getInstruction());
        holder.checkBox.isChecked();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView instructions;
        CheckBox checkBox;

        public MyViewHolder(View view) {
            super(view);
           instructions =view.findViewById(R.id.course_instruction);
           checkBox =view.findViewById(R.id.checkBox);
        }

    }
}
