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

public class SignUpFragment extends Fragment implements View.OnClickListener{

    Button btn_register;
    EditText et_email, et_name, et_password, et_confirm_password;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up, container, false);

        btn_register = (Button)view.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);

        et_name = (EditText)view.findViewById(R.id.editText_input_full_name);
        et_email = (EditText)view.findViewById(R.id.editText_input_email);
        et_password = (EditText)view.findViewById(R.id.editText_input_password);
        et_confirm_password = (EditText)view.findViewById(R.id.editText_input_confirm_password);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register){
            signUpHandle();
            //Navigation.findNavController(v).navigate(R.id.action_signUpFragment_to_userFragment);
        }
    }

    private void signUpHandle() {
        String _name = et_name.getText().toString().trim();
        String _email = et_email.getText().toString().trim();
        String _password = et_password.getText().toString().trim();
        String _confirmPassword = et_confirm_password.getText().toString().trim();
        //check validation of input
        if (!checkValidate(_email, _password, _confirmPassword))
            return;

        //Add database...

        //Intent to MainActivity class
        Toast.makeText(getContext().getApplicationContext(), "Sign in success", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        intent.putExtra("isLogined", true);
        startActivity(intent);
        getActivity().finish();
    }

    private boolean checkValidate(String _email, String _password, String _confirmPassword) {
        //check email input
        if (_email.equals("")) {
            Toast.makeText(getContext().getApplicationContext(), "You must type email", Toast.LENGTH_LONG).show();
            return false;
        }
        //length of password is more 6 characters
        if (_password.length() < 6){
            Toast.makeText(getContext().getApplicationContext(), "Password must have at least 6 characters", Toast.LENGTH_LONG).show();
            return false;
        }

        //check password match confirm password
        if (!_password.equals(_confirmPassword)){
            Toast.makeText(getContext().getApplicationContext(), "Confirm password doesn't match", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}