package com.example.courseshub.CourseInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.courseshub.R;

public class CourseinfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.courseinfo, container, false);
    }

    public static CourseinfoFragment newInstance() {

        Bundle args = new Bundle();
        CourseinfoFragment fragment = new CourseinfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
