package com.example.courseshub.Course.CourseInfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.courseshub.Course.Course;
import com.example.courseshub.Main.CourseViewModel;
import com.example.courseshub.R;

import java.util.ArrayList;

public class CourseInfoFragment extends Fragment {
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

    public static CourseInfoFragment newInstance() {
        Bundle args = new Bundle();
        CourseInfoFragment fragment = new CourseInfoFragment();
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

    public class FetchCourseInfo extends AsyncTask<Integer, Integer, CourseInfo> {
        @Override
        protected CourseInfo doInBackground(Integer... integers) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(CourseInfo course) {
            super.onPostExecute(course);
        }
    }


}
