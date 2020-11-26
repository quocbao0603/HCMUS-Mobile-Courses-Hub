package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Quiz.Submission;

public class Submission {
    private int quiz_id;



    //state:
    // = 0: haven't submit.
    // = 1: submitted.
    // = 2: overdue submission.
    private int state;

    private String description;
    private String info;


    public Submission(int quiz_id, int state, String description, String info) {
        this.quiz_id = quiz_id;
        this.state = state;
        this.description = description;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getQuiz_id() {
        return quiz_id;
    }



    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
