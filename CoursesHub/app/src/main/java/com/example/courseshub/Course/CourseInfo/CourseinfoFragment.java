package com.example.courseshub.Course.CourseInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.courseshub.Main.CourseViewModel;
import com.example.courseshub.R;

public class CourseinfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.courseinfo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CourseViewModel model = new ViewModelProvider(getActivity()).get(CourseViewModel.class);
        Course course = model.getSelected();
        setCourseInfo(course, view);
    }

    public static CourseinfoFragment newInstance() {
        Bundle args = new Bundle();
        CourseinfoFragment fragment = new CourseinfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void setCourseInfo(Course course, View view){
        TextView title = view.findViewById(R.id.courseinfo_title);
        TextView teacher = view.findViewById(R.id.courseinfo_teacher);
        TextView ta1 = view.findViewById(R.id.courseinfo_ta1);
        TextView ta2 = view.findViewById(R.id.courseinfo_ta2);

        title.setText(course.get_title());
        teacher.setText(course.get_teacher());
        ta1.setText(course.get_ta1());
        ta2.setText(course.get_ta2());
    }
}
