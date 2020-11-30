package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Syllabus;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.Course.Course;
import com.example.courseshub.R;

import java.net.URL;
import java.util.ArrayList;

public class CouseDetail_SyllabusFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Syllabus> syllabuses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.coursedetail_tab_syllabus, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.coursedetail_syllabus_list);
        ImageView profile = view.findViewById(R.id.profile);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        try {
            syllabuses = new FetchSyllabusList().execute(new Integer(3)).get();
        }
        catch (Exception e){

        }
        CourseDetail_SyllabusAdapter adapter = new CourseDetail_SyllabusAdapter(getContext(), syllabuses);
        recyclerView.setAdapter(adapter);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_couseDetail_SyllabusFragment_to_profileFragment);
            }
        });
        return view;
    }

    public static CouseDetail_SyllabusFragment newInstance() {
        
        Bundle args = new Bundle();
        
        CouseDetail_SyllabusFragment fragment = new CouseDetail_SyllabusFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public class FetchSyllabusList extends AsyncTask<Integer, Integer, ArrayList<Syllabus>> {
        @Override
        protected ArrayList<Syllabus> doInBackground(Integer... integers) {

            //Fetch data from DB

            ArrayList<Syllabus> syllabuses = new ArrayList<Syllabus>();

            syllabuses.add(new Syllabus(1, "List View", "2.3 MB", 0, "https://www.google.com/"));
            syllabuses.add(new Syllabus(2, "Recycler View", "2.3 MB", 1, "https://www.google.com/"));
            syllabuses.add(new Syllabus(3, "List View", "2.3 MB", 0, "https://www.google.com/"));
            syllabuses.add(new Syllabus(4, "List View", "2.3 MB", 0, "https://www.google.com/"));
            syllabuses.add(new Syllabus(5, "List View", "2.3 MB", 1, "https://www.google.com/"));
            syllabuses.add(new Syllabus(6, "List View", "2.3 MB", 0, "https://www.google.com/"));
            syllabuses.add(new Syllabus(7, "List View", "2.3 MB", 1, "https://www.google.com/"));
            return syllabuses;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Syllabus> courses) {
            super.onPostExecute(courses);
        }
    }
}
