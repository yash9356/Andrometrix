package com.example.andrometrixlite.Learning;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
//
//import com.example.andrometrixlite.Learning.Todo.UserListAdapter;
//import com.example.andrometrixlite.Learning.Todo.db.AppDatabase;
//import com.example.andrometrixlite.Learning.Todo.db.User;
import com.example.andrometrixlite.R;

import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class AboutLearningFragment extends Fragment {
    //private UserListAdapter userListAdapter;
    private Button addTodoBtn;
    public AboutLearningFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_about_learning, container, false);
        /* starts before 1 month from now */
        addTodoBtn=view.findViewById(R.id.addTodoButton);
        addTodoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);
//       initRecyclerView(view);
//       loadUserList();
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }
        });
        return view;
    }
//    private void initRecyclerView(View view) {
//        RecyclerView recyclerView = view.findViewById(R.id.todoRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);
//        userListAdapter = new UserListAdapter(getContext());
//        recyclerView.setAdapter(userListAdapter);
//    }
//    public void loadUserList() {
//        AppDatabase db = AppDatabase.getDbInstance(this.getContext());
//        List<User> userList =db.userDao().getAllUsers();
//        userListAdapter.setUserList(userList);
//    }
}