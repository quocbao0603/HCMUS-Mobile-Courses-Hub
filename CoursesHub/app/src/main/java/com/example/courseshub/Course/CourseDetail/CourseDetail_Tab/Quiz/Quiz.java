package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Quiz;

public class Quiz {
    private int _number;
    private String _title;
    private String _des;
    private String _count;
    private int _type;


    public Quiz(int _number, String _title, String _des, String _count, int _type) {
        this._number = _number;
        this._title = _title;
        this._des = _des;
        this._count = _count;
        this._type = _type;
    }

    public int get_number() {
        return _number;
    }

    public void set_number(int _number) {
        this._number = _number;
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

    public String get_count() {
        return _count;
    }

    public void set_count(String _count) {
        this._count = _count;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }
}
