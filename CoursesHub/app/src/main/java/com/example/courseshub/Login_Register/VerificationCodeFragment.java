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
import androidx.navigation.Navigation;

import com.example.courseshub.Main.MainActivity;
import com.example.courseshub.R;

public class VerificationCodeFragment extends Fragment implements View.OnClickListener {
    Button btn_verify;
    EditText et_code;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.verification_code, container, false);

        btn_verify = (Button)view.findViewById(R.id.btn_verify_code);
        btn_verify.setOnClickListener(this);

        et_code = (EditText)view.findViewById(R.id.editText_input_code_verification);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_verify_code){
            String _code = et_code.getText().toString().trim();

            if (!checkCodeValidation(_code)){
                Toast.makeText(getContext().getApplicationContext(), "Your code is not correct", Toast.LENGTH_LONG).show();
                return;
            }

            //navigation to change password fragment
            Navigation.findNavController(v).navigate(R.id.action_verificationCodeFragment_to_change_password_forget_fragment);
        }
    }

    private Boolean checkCodeValidation(String code) {
        if (code.equals("1234"))
            return true;
        return false;
    }
}
