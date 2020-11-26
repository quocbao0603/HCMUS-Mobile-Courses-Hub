package com.example.courseshub.AsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.courseshub.Course.CourseInfo.Course;

public class AsyncTaskFetchSyllabusDB extends AsyncTask<Integer, Integer, Integer> {

    @Override
    protected Integer doInBackground(Integer... integers) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("DBG", "Pre execute");

    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if(integer.intValue() == 1){
            Log.d("DBG", "Execute done");
        }
        else{
            Log.d("DBG", "False to asynctask")
        }
    }
}
