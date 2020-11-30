package com.example.courseshub.Login_Register;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.courseshub.Main.MainActivity;
import com.example.courseshub.R;

public class change_password_forget_fragment extends Fragment implements View.OnClickListener {
    Button btn_save;
    EditText et_new_password, et_confirm_new_password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_password_forget, container,false);

        btn_save = (Button) view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        et_new_password = (EditText) view.findViewById(R.id.editText_input_new_password);
        et_confirm_new_password = (EditText) view.findViewById(R.id.editText_input_confirm_new_password);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save){
            String new_password = et_new_password.getText().toString().trim();
            String confirm_new_password = et_confirm_new_password.getText().toString().trim();

            // check validate new password
            if (!checkValdidatePassword(new_password))
                return;

            // check new password match confirm new password
            if (!checkMatchingPassword(new_password, confirm_new_password))
                    return;

            //intent to hompage
            Toast.makeText(getContext().getApplicationContext(), "Change password success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
            intent.putExtra("isLogined", true);
            startActivity(intent);
            getActivity().finish();

        }
    }

    private boolean checkMatchingPassword(String new_password, String confirm_new_password) {
        if (new_password.equals(confirm_new_password))
            return true;

        Toast.makeText(getContext().getApplicationContext(), "Confirm password doesn't match", Toast.LENGTH_LONG).show();
        return false;
    }

    private boolean checkValdidatePassword(String new_password) {
        if (new_password.length() < 6){
            Toast.makeText(getContext().getApplicationContext(), "Your new password must have at least 6 characters", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
