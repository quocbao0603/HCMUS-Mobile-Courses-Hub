package com.example.courseshub.CourseInfo;

import android.graphics.Bitmap;

public class CourseInfo {
    private Bitmap _avt;
    private String _title;
    private String _teacher;
    private String _ta1, _ta2;

    public CourseInfo(Bitmap avt, String _title, String _teacher, String _ta1, String _ta2) {
        _avt = avt;
        this._title = _title;
        this._teacher = _teacher;
        this._ta1 = _ta1;
        this._ta2 = _ta2;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_teacher() {
        return _teacher;
    }

    public void set_teacher(String _teacher) {
        this._teacher = _teacher;
    }

    public String get_ta1() {
        return _ta1;
    }

    public void set_ta1(String _ta1) {
        this._ta1 = _ta1;
    }

    public String get_ta2() {
        return _ta2;
    }

    public void set_ta2(String _ta2) {
        this._ta2 = _ta2;
    }

    public Bitmap get_avt() {
        return _avt;
    }

    public void set_avt(Bitmap _avt) {
        this._avt = _avt;
    }
}
