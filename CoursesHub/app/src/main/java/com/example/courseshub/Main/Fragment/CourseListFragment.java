package com.example.courseshub.Main.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseshub.CourseInfo.CourseinfoFragment;
import com.example.courseshub.Main.Adapter.CourseAdapter;
import com.example.courseshub.R;
import com.example.courseshub.CourseInfo.CourseInfo;

import java.util.ArrayList;

public class CourseListFragment extends Fragment implements  View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.courselist_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.home_courses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<CourseInfo> holders = new ArrayList<CourseInfo>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.course_avt);
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        holders.add(new CourseInfo(bitmap, "Introudction to mobile", "By Dr. Tran Minh Triet", "TA. Nguyen Thanh An", "TA. Do Trong Le"));
        Log.d("DBG", "Setting courses");
        CourseAdapter courselist_adapter = new CourseAdapter(getContext(), holders, getChildFragmentManager());
        recyclerView.setAdapter(courselist_adapter);
        return view;
    }

    public static CourseListFragment newInstance() {
        Bundle args = new Bundle();
        CourseListFragment fragment = new CourseListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment courseInfo = CourseinfoFragment.newInstance();
        Log.d("DBG", "11111111111111");
        fragmentTransaction.replace(R.id.mainViewPager, courseInfo);
        fragmentTransaction.addToBackStack(null);
        Log.d("DBG", "22222222222222222");
        fragmentTransaction.commit();
    }

}


