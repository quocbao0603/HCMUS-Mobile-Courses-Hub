package com.example.courseshub.courseindex;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.courseshub.courseindex.mainfragment.ChatFragment;
import com.example.courseshub.courseindex.mainfragment.CourseListFragment;
import com.example.courseshub.courseindex.mainfragment.MoreFragment;
import com.example.courseshub.courseindex.mainfragment.SearchFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {
    int _tabCount = 4;
    Context _context;

    public MainPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        _context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return CourseListFragment.newInstance();
            }
            case 1: return ChatFragment.newInstance();
            case 2: return SearchFragment.newInstance();
            default: return MoreFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return _tabCount;
    }
}

