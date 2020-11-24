package com.example.courseshub.Course.CourseDetail.CourseDetail_Tab.Quiz.Submission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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

    String[] permissionArray = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
    private final int PICKFILE_RESULT_CODE = 123;
    private final int ACTIVITY_CHOOSE_FILE = 12;
    private Uri fileuri;
    private String filepath;
    private boolean PERMISSION_FLAG;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.coursedetail_tab_quiz_submit, container, false);
        View click = view.findViewById(R.id.coursedetail_submission_submit);
        click.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkandgetPermission();
                if(PERMISSION_FLAG == true)
                    onBrowse();

            }
        });
        return view;
    }

    public void onBrowse() {
        Intent chooseFile;
        Intent intent;
        chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.addCategory(Intent.CATEGORY_OPENABLE);
        chooseFile.setType("*/*");
        intent = Intent.createChooser(chooseFile, "Choose a file");
        startActivityForResult(intent, ACTIVITY_CHOOSE_FILE);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case ACTIVITY_CHOOSE_FILE:{
                if(resultCode == -1){
                    fileuri = data.getData();
                    filepath = fileuri.getPath();
                    Toast.makeText(getContext(), "Selected", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void checkandgetPermission(){
        if(ContextCompat.checkSelfPermission(getContext(), permissionArray[0]) == PackageManager.PERMISSION_GRANTED){
            PERMISSION_FLAG = true;
        }
        else if(shouldShowRequestPermissionRationale(permissionArray[0])){
            PERMISSION_FLAG = true;
        }
        else{
            requestPermissions(permissionArray, PICKFILE_RESULT_CODE);
        }

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("DBG", Integer.toString(requestCode));

        if(requestCode == PICKFILE_RESULT_CODE){
            if(grantResults.length > 0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Granted", Toast.LENGTH_SHORT).show();
                    Log.d("DBG", "Granted read file");
                    PERMISSION_FLAG = true;
                }
                else{
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                    Log.d("DBG", "Failed read file");
                    PERMISSION_FLAG = false;
                }

            }
        }

    }

}