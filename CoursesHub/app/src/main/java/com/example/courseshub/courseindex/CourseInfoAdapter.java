package com.example.courseshub.courseindex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CourseInfoAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments;
    int tabCount = 3;

    public CourseInfoAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0) return FragmentQuiz.newInstance("a", "b");
        if(position == 1) return FragmentNoti.newInstance("a", "b");
        return FragmentDiscus.newInstance("a", "b");
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



