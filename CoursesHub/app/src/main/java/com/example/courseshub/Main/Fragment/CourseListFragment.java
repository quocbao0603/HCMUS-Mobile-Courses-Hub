package com.example.courseshub.Main.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.Main.Adapter.CourseListAdapter;
import com.example.courseshub.Main.CourseViewModel;
import com.example.courseshub.R;
import com.example.courseshub.Course.CourseInfo.Course;

import java.util.ArrayList;

public class CourseListFragment extends Fragment implements CourseListAdapter.ListItemClickListener{
    private CourseViewModel viewModel;
    private ArrayList<Course> holders = new ArrayList<Course>();
    private CourseListAdapter adapter;
    private FragmentManager homefragmentManager;


    public CourseListFragment(FragmentManager homefragmentManager) {
        this.homefragmentManager = homefragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_courselist, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.home_courses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.course_avt);
        holders.add(new Course(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile1", "By Dr. Tran Minh Triet1", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile2", "By Dr. Tran Minh Triet2", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile3", "By Dr. Tran Minh Triet3", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile4", "By Dr. Tran Minh Triet4", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile1", "By Dr. Tran Minh Triet1", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile2", "By Dr. Tran Minh Triet2", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile3", "By Dr. Tran Minh Triet3", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new Course(bitmap, "Introudction to mobile4", "By Dr. Tran Minh Triet4", "TA. Nguyen Thanh An", "TA. Do Trong Le"));

        Log.d("DBG", "Setting courses");
        adapter = new CourseListAdapter(getContext(), holders, getChildFragmentManager(), this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public static CourseListFragment newInstance(FragmentManager fragmentManager) {
        Bundle args = new Bundle();
        CourseListFragment fragment = new CourseListFragment(fragmentManager);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);
    }


    @Override
    public void onListItemClick(int position, View view) {
        Course course = holders.get(position);
        viewModel.select(course);
        if(false){
            Navigation.findNavController(view).navigate(R.id.action_homepageFagment_to_courseinfoFragment);
        }
        else{
            Toast.makeText(getContext(), "DDD", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view).navigate(R.id.action_homepageFagment_to_couseDetailFragment);
        }



    }
}


