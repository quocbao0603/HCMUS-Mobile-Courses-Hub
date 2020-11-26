package com.example.courseshub.Main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.courseshub.Main.Adapter.HomePageAdapter;
import com.example.courseshub.R;
import com.google.android.material.tabs.TabLayout;

public class HomepageFagment extends Fragment {
    ViewPager _viewPager;
    TabLayout _tabLayout;

    CourseViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.homepage, container, false);
        _viewPager = view.findViewById(R.id.mainViewPager);
        _viewPager.setCurrentItem(0);
        FragmentPagerAdapter adapter = new HomePageAdapter(getChildFragmentManager(), getContext());
        _viewPager.setAdapter(adapter);
        _tabLayout = view.findViewById(R.id.bottomBar);
        _tabLayout.setupWithViewPager(_viewPager);
        setBottomBar_Items();
        return view;
    }

    public static HomepageFagment newInstance() {
        Bundle args = new Bundle();
        HomepageFagment fragment = new HomepageFagment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setBottomBar_Items(){
        setBottomBar_Item(0,R.layout.homepage_bottombar_item, "Home", R.drawable.ic_icon_home_blue_24px);
        setBottomBar_Item(1, R.layout.homepage_bottombar_item, "Chat", R.drawable.ic_icon_chat_gray_24px);
        setBottomBar_Item(2, R.layout.homepage_bottombar_item, "Search", R.drawable.ic_icon_search_gray_24px);
        setBottomBar_Item(3, R.layout.homepage_bottombar_item, "More", R.drawable.ic_icon_more_gray_24px);
    }

    public void setBottomBar_Item(int position, int layout, String text, int drawable){
        TextView tab = (TextView)LayoutInflater.from(getContext()).inflate(layout, null);
        tab.setText(text);
        tab.setCompoundDrawablesWithIntrinsicBounds(0, drawable, 0, 0);
        _tabLayout.getTabAt(position).setCustomView(tab);
    }
}
