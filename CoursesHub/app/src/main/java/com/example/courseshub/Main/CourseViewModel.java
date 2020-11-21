package com.example.courseshub.Main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.courseshub.Course.CourseInfo.Course;

public class CourseViewModel extends ViewModel {
    private MutableLiveData<Course> selected = new MutableLiveData<Course>();

    public void select(Course course){
        selected.setValue(course);
    }

    public Course getSelected(){
        return selected.getValue();
    }
}
