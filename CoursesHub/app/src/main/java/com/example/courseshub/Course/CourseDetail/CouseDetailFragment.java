package com.example.courseshub.Course.CourseDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.courseshub.R;

public class CouseDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coursedetail, container, false);
        RelativeLayout syllabus = view.findViewById(R.id.coursedetail_syllabus);
        RelativeLayout quiz = view.findViewById(R.id.coursedetail_quiz);
        RelativeLayout discussion = view.findViewById(R.id.coursedetail_discussion);
        RelativeLayout nofitication = view.findViewById(R.id.coursedetail_notification);
        ImageView profile = view.findViewById(R.id.profile);

        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_couseDetailFragment_to_couseDetail_SyllabusFragment);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_couseDetailFragment_to_courseDetail_QuizFragment);
            }
        });

        discussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_couseDetailFragment_to_courseDetail_DiscussionFragment);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_couseDetailFragment_to_profileFragment);
            }
        });

        return view;
    }

}
