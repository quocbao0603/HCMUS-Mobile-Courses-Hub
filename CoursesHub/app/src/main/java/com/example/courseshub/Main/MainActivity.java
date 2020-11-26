package com.example.courseshub.Main;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
//import class database helper

import com.example.courseshub.DB.DatabaseHelper;
import com.example.courseshub.R;
import com.google.android.material.tabs.TabLayout;



public class MainActivity extends AppCompatActivity{
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        databaseHelper.createDataBase();
        databaseHelper.openDataBase();
        databaseHelper.getAllDiscussion();
        databaseHelper.close();
    }

}