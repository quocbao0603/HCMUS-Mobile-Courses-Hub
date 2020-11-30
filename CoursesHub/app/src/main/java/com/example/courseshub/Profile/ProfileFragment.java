package com.example.courseshub.Profile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.Course.Course;
import com.example.courseshub.Main.Fragment.CourseListFragment;
import com.example.courseshub.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container,  false);
        RecyclerView recyclerView = view.findViewById(R.id.profile_course_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<String> courses = new ArrayList<String>();
        FetchCourseList runner = new FetchCourseList();
        try {
            courses = runner.execute(new Integer(3)).get();
        }
        catch (Exception e){

        }
        ProfileCourseAdapter adapter = new ProfileCourseAdapter(courses, getContext());
        recyclerView.setAdapter(adapter);
        return view;

    }

    public class FetchCourseList extends AsyncTask<Integer, Integer, ArrayList<String>> {
        @Override
        protected ArrayList<String> doInBackground(Integer... integers) {

            //Fetch data from DB

            ArrayList<String> courses = new ArrayList<String>();
            courses.add(new String("Introduction to mobile"));
            courses.add(new String("Programming Technique"));
            courses.add(new String("Introduction to IT 1"));
            courses.add(new String("Introduction to IT 2"));
            courses.add(new String("Data structures and Algorithms"));
            courses.add(new String("Introduction to mobile"));
            courses.add(new String("Introduction to mobile"));
            courses.add(new String("Introduction to mobile"));


            return courses;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<String> courses) {
            super.onPostExecute(courses);
        }
    }
}
