package com.example.courseshub.Course.CourseDetail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Discussion.CourseDetail_DiscussionFragment;

public class    CourseInfoAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments;
    int tabCount = 3;

    public CourseInfoAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) return "QUIZ";
        if(position == 1) return "NOTIFICATIONS";
        return "DISCUSSION";
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}



