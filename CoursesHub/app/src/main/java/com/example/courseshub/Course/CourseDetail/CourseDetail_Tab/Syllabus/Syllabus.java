package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Syllabus;

import java.net.URL;

public class Syllabus {
    private int _number;
    private String _title;
    private String _des;
    private int _type;
    private String _url;

    public Syllabus(int number, String _title, String _des, int _type, String _url) {
        this._title = _title;
        _number = number;
        this._des = _des;
        this._type = _type;
        this._url = _url;
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

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
    public int get_number() {
        return _number;
    }

    public void set_number(int _number) {
        this._number = _number;
    }
}
