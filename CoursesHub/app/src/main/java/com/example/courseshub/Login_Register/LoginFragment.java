package com.example.courseshub.Login_Register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.courseshub.Main.MainActivity;
import com.example.courseshub.R;

public class LoginFragment extends Fragment implements  View.OnClickListener{

    Button btn_login;
    TextView tv_sign_up, tv_forget_pass;
    EditText et_email, et_password;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container,false);

        btn_login = (Button) view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        tv_sign_up = (TextView) view.findViewById(R.id.tv_sign_up);
        tv_sign_up.setOnClickListener(this);

        tv_forget_pass = (TextView) view.findViewById(R.id.tv_forget_password);
        tv_forget_pass.setOnClickListener(this);

        et_email = (EditText)view.findViewById(R.id.editText_input_email);
        et_password = (EditText)view.findViewById(R.id.editText_input_password);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login:
                //check email and password
                loginHandle();
                break;

            case R.id.tv_sign_up:
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_signUpFragment);
                break;

            case R.id.tv_forget_password:
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_forgetPasswordFragment);
                break;
        }
    }

    private void loginHandle() {
        String _email = et_email.getText().toString().trim();
        String _password = et_password.getText().toString().trim();

        if (checkUser(_email,_password)){
            Toast.makeText(getContext().getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
            //Intent to Homepage (MainActivity)
            Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
            intent.putExtra("isLogined", true);
            startActivity(intent);
            getActivity().finish();
        }
        else {
            Toast.makeText(getActivity().getApplicationContext(),"Email or password is wrong!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkUser(String _email, String _password) {
        if (_email.equals("abc@xyz.com") && _password.equals("1234"))
            return true;
        return false;
    }
}