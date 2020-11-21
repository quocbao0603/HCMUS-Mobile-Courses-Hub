package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.courseshub.Course.CourseDetail.CourseInfoAdapter;
import com.example.courseshub.R;

import java.util.ArrayList;

public class CourseDetail_QuizFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.coursedetail_tab_quiz, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.coursedetail_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<Quiz> data = new ArrayList<Quiz>();
        data.add(new Quiz(1, "Midterm Project", "Submission 10", "14 days remained", 0));
        data.add(new Quiz(2, "Project 1", "Submission 9", "14 days remained", 1));
        data.add(new Quiz(3, "Project 2", "Submission 8", "14 days remained", 2));
        data.add(new Quiz(4, "Midterm Project", "Submission 7", "14 days remained", 1));
        data.add(new Quiz(5, "Midterm Project", "Submission 6", "14 days remained", 2));
        data.add(new Quiz(6, "Midterm Project", "Submission 5", "14 days remained", 0));
        data.add(new Quiz(7, "Midterm Project", "Submission 4", "14 days remained", 0));
        CourseDetail_QuizAdapter adapter = new CourseDetail_QuizAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public static CourseDetail_QuizFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CourseDetail_QuizFragment fragment = new CourseDetail_QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

}