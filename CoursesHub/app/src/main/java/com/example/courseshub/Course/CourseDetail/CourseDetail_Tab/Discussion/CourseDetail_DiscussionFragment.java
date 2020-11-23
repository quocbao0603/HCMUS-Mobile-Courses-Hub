package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Discussion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.courseshub.R;

import java.util.ArrayList;

public class CourseDetail_DiscussionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.coursedetail_tab_discussion, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.coursedetail_list);
        ArrayList<Discussion> data = new ArrayList<Discussion>();
        Bitmap avt = BitmapFactory.decodeResource(getResources(), R.drawable.discussion_avt);
        data.add(new Discussion(avt, 5, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 10, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 15, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 25, "Discussion 3", "Lorem ipsumipsumipsumipsumipsumipsumipsumipsumipsum dolor.........."));
        data.add(new Discussion(avt, 0, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 1, "Discussion 1", "Lorem ipsum dolor.........."));data.add(new Discussion(avt, 5, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 10, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 15, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 25, "Discussion 3", "Lorem ipsumipsumipsumipsumipsumipsumipsumipsumipsum dolor.........."));
        data.add(new Discussion(avt, 0, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 1, "Discussion 1", "Lorem ipsum dolor.........."));data.add(new Discussion(avt, 5, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 10, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 15, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 25, "Discussion 3", "Lorem ipsumipsumipsumipsumipsumipsumipsumipsumipsum dolor.........."));
        data.add(new Discussion(avt, 0, "Discussion 1", "Lorem ipsum dolor.........."));
        data.add(new Discussion(avt, 1, "Discussion 1", "Lorem ipsum dolor.........."));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseDetail_DicussionAdapter adapter = new CourseDetail_DicussionAdapter( data, getContext());
        recyclerView.setAdapter(adapter);
        return view;

    }

    public static CourseDetail_DiscussionFragment newInstance() {

        Bundle args = new Bundle();

        CourseDetail_DiscussionFragment fragment = new CourseDetail_DiscussionFragment();
        fragment.setArguments(args);
        return fragment;
    }
}