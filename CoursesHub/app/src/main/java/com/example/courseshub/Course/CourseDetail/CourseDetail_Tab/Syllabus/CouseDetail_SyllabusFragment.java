package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Syllabus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.R;

import java.net.URL;
import java.util.ArrayList;

public class CouseDetail_SyllabusFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.coursedetail_tab_syllabus, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.coursedetail_syllabus_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<Syllabus> data = new ArrayList<Syllabus>();

        data.add(new Syllabus(1, "List View", "2.3 MB", 0, "https://www.google.com/"));
        data.add(new Syllabus(2, "Recycler View", "2.3 MB", 1, "https://www.google.com/"));
        data.add(new Syllabus(3, "List View", "2.3 MB", 0, "https://www.google.com/"));
        data.add(new Syllabus(4, "List View", "2.3 MB", 0, "https://www.google.com/"));
        data.add(new Syllabus(5, "List View", "2.3 MB", 1, "https://www.google.com/"));
        data.add(new Syllabus(6, "List View", "2.3 MB", 0, "https://www.google.com/"));
        data.add(new Syllabus(7, "List View", "2.3 MB", 1, "https://www.google.com/"));
        CourseDetail_SyllabusAdapter adapter = new CourseDetail_SyllabusAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public static CouseDetail_SyllabusFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CouseDetail_SyllabusFragment fragment = new CouseDetail_SyllabusFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
