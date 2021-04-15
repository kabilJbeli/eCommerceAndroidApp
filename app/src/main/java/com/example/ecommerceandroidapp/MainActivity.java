package com.example.ecommerceandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences shp;
    SharedPreferences.Editor shpEditor;
    EditText edtUserId, edtPassword;
    Button btnLogin;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!(getEmail().equals("") || getPassword().equals("")) && getFirstlogin().equals("true")){
            startHomeActivity();
        }
        edtUserId = findViewById(R.id.log);
        edtPassword = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.connect);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }
    private void attemptLogin() {
        String email = edtUserId.getText().toString();
        String password = edtPassword.getText().toString();
        boolean cancel = false;
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password) && password.equals(getPassword())) {
            Toast.makeText(MainActivity.this, "please check your password", Toast.LENGTH_LONG).show();
            cancel = true;
        }
        if (TextUtils.isEmpty(email) && !isEmailValid(email) && email.toLowerCase().equals(getEmail().toLowerCase())) {
            Toast.makeText(MainActivity.this, "please check your email", Toast.LENGTH_LONG).show();
            cancel = true;
        }
        if (!cancel){
            shpEditor.putString(Registration.Firstlogin, "true");
            shpEditor.apply();
            startHomeActivity();
        }
    }

    private void startHomeActivity() {
        //Intent intent = new Intent(this, HomeActivity.class);
       // startActivity(intent);
      //  finish();
    }


    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Registration.MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Registration.Email, "");
    }

    public String getPassword() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Registration.MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Registration.Password, "");
    }

    public String getFirstlogin() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Registration.MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Registration.Firstlogin, "false");
    }

    private boolean isEmailValid(String mail) {
        return mail.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}