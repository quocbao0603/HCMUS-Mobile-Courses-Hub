package com.example.courseshub.Login_Register;


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

import com.example.courseshub.R;

public class ForgetPasswordFragment extends Fragment implements View.OnClickListener{

    Button btn_send;
    EditText et_email, et_phone;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forget_password, container, false);

        btn_send = (Button) view.findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);

        et_email = (EditText)view.findViewById(R.id.editText_input_email);
        et_phone = (EditText)view.findViewById(R.id.editText_input_phone);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        String _email = et_email.getText().toString().trim();
        String _phone = et_phone.getText().toString().trim();

        if (v.getId() == R.id.btn_send){
            //check validation of email or phone
            if (!checkVailate(_email,_phone))
                return;

            //send code to user's mail or user's phone
            sendCode(_email,_phone);

            //navigation to verification code
            Navigation.findNavController(v).navigate(R.id.action_forgetPasswordFragment_to_verificationCodeFragment);
        }
    }

    private boolean checkVailate(String _email, String _phone) {
        Boolean check_email = null, check_phone = null;
        if (_email.equals("") && _phone.equals("")) {
            Toast.makeText(getContext().getApplicationContext(), "You must type your email or phone", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            if (_email.length() > 0){
                check_email = true;
                if (!_email.equals("abc@xyz.com")){
                    Toast.makeText(getContext().getApplicationContext(), "Email doesn't exist", Toast.LENGTH_LONG).show();
                    check_email = false;
                }
            }

            if (_phone.length() > 0){
                check_phone = true;
                if (_phone.length() != 10 || _phone.charAt(0) != '0'){
                    Toast.makeText(getContext().getApplicationContext(), "You phone is not correct", Toast.LENGTH_LONG).show();
                    check_phone = false;
                }
            }


            return (check_email || check_phone);
        }
    }

    private void sendCode(String _email, String _phone) {
        //do something...
    }

}
