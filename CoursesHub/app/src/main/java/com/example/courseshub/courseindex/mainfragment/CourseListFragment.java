package com.example.courseshub.courseindex.mainfragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.R;
import com.example.courseshub.courseindex.course.CourseInfo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class CourseListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.courselist_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.home_courses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<CourseInfo> holders = new ArrayList<CourseInfo>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.course_avt);
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        Log.d("DBG", "Setting courses");
        CourseAdapter courselist_adapter = new CourseAdapter(getContext(), holders);
        recyclerView.setAdapter(courselist_adapter);
        return view;
    }

    public static CourseListFragment newInstance() {
        Bundle args = new Bundle();
        CourseListFragment fragment = new CourseListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}


