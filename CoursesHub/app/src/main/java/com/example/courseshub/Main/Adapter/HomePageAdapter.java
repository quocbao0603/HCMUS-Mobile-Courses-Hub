package com.example.courseshub.Main.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.courseshub.Main.Fragment.ChatFragment;
import com.example.courseshub.Main.Fragment.CourseListFragment;
import com.example.courseshub.Main.Fragment.MoreFragment;
import com.example.courseshub.Main.Fragment.SearchFragment;

public class HomePageAdapter extends FragmentPagerAdapter {
    int _tabCount = 4;
    Context _context;

    public HomePageAdapter(@NonNull FragmentManager fm, Context context) {
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

