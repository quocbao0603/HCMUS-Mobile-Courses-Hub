package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Quiz.Submission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.courseshub.Main.MainActivity;
import com.example.courseshub.R;

public class CourseDetial_SubmissionFragment extends Fragment {
    public int PICKFILE_RESULT_CODE = 1;
    String[] permissionArray = {Manifest.permission.MANAGE_EXTERNAL_STORAGE};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.coursedetail_tab_quiz_submit, container, false);
        View click = view.findViewById(R.id.coursedetail_submission_submit);
        click.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkandgetPermission();

            }
        });
        return view;
    }

    public void checkandgetPermission(){
        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.MANAGE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), permissionArray, PICKFILE_RESULT_CODE);
            Log.d("DBG", "Granting");
        }

        Log.d("DBG", "Was Granted");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d("DBG", Integer.toString(requestCode));

        if(requestCode == PICKFILE_RESULT_CODE){
            if(grantResults.length > 0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Granted", Toast.LENGTH_SHORT).show();
                    Log.d("DBG", "Granted");

                    return;
                }
            }
            Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            Log.d("DBG", "Failed");
        }
        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
        Log.d("DBG", "Failed");

    }
}