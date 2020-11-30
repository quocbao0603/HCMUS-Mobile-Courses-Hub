package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Quiz;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Syllabus.Syllabus;
import com.example.courseshub.R;

import java.util.ArrayList;

public class CourseDetail_QuizFragment extends Fragment {
    RecyclerView recyclerView;
    int course_id = 0;
    ArrayList<Quiz> quizzes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.coursedetail_tab_quiz, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.coursedetail_list);
        ImageView profile = view.findViewById(R.id.profile);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        try {
            quizzes = new FetchQuizList().execute(course_id).get();
        }
        catch (Exception e){

        }

        CourseDetail_QuizAdapter adapter = new CourseDetail_QuizAdapter(getContext(), quizzes);
        recyclerView.setAdapter(adapter);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_courseDetail_QuizFragment_to_profileFragment);
            }
        });
        return view;
    }

    public static CourseDetail_QuizFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CourseDetail_QuizFragment fragment = new CourseDetail_QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public class FetchQuizList extends AsyncTask<Integer, Integer, ArrayList<Quiz>> {
        @Override
        protected ArrayList<Quiz> doInBackground(Integer... integers) {

            //Fetch data from DB

            ArrayList<Quiz> quizzess = new ArrayList<Quiz>();

            quizzess.add(new Quiz(1, "Midterm Project", "Submission 10", "14 days remained", 0));
            quizzess.add(new Quiz(2, "Project 1", "Submission 9", "14 days remained", 1));
            quizzess.add(new Quiz(3, "Project 2", "Submission 8", "14 days remained", 2));
            quizzess.add(new Quiz(4, "Midterm Project", "Submission 7", "14 days remained", 1));
            quizzess.add(new Quiz(5, "Midterm Project", "Submission 6", "14 days remained", 2));
            quizzess.add(new Quiz(6, "Midterm Project", "Submission 5", "14 days remained", 0));
            quizzess.add(new Quiz(7, "Midterm Project", "Submission 4", "14 days remained", 0));
            return quizzess;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Quiz> courses) {
            super.onPostExecute(courses);
        }
    }

}