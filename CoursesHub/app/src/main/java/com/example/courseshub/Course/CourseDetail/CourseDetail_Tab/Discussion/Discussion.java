package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Discussion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Discussion {
    Bitmap _avt;
    int _new;
    String _title;
    String _des;

    public Bitmap get_avt() {
        return _avt;
    }

    public void set_avt(Bitmap _avt) {
        this._avt = _avt;
    }

    public int get_new() {
        return _new;
    }

    public void set_new(int _new) {
        this._new = _new;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_des() {
        return _des;
    }

    public void set_des(String _des) {
        this._des = _des;
    }

    public Discussion(Bitmap _avt, int _new, String _title, String _des) {
        this._avt = _avt;
        this._new = _new;
        this._title = _title;
        this._des = _des;
    }
}
