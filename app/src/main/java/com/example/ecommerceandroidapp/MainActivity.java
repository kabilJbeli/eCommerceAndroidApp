package com.example.ecommerceandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences shp;
    SharedPreferences.Editor shpEditor;
    EditText edtUserId, edtPassword;
    Button btnLogin;
    TextView txtInfo;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserId = findViewById(R.id.log);
        edtPassword = findViewById(R.id.pass);
        edtUserId.setText("");
        edtPassword.setText("");
        btnLogin = findViewById(R.id.connect);

        shp = getSharedPreferences(Registration.MyPREFERENCES, MODE_PRIVATE);
        CheckLogin();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUserId.getText().toString().equals("") || edtPassword.getText().toString().equals("")) {
                    //txtInfo.setText("Please insert userid and password");
                }
                else{
                    DoLogin(edtUserId.getText().toString(), edtPassword.getText().toString());
                }
            }
        });
    }

    public void CheckLogin() {
        if (shp == null)
            shp = getSharedPreferences(Registration.MyPREFERENCES, MODE_PRIVATE);

        String userName = shp.getString(Registration.Email, "");

        if (userName != null && !userName.equals("")) {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }



    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Registration.MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Registration.Email, "");
    }

    public String getPassword() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Registration.MyPREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Registration.Password, "");
    }

    public void DoLogin(String username, String password) {
        try {
            if (username.equals(getEmail()) && password.equals(getPassword())) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
                //txtInfo.setText("Invalid Credentails");
            }
        } catch (Exception ex) {
            txtInfo.setText(ex.getMessage().toString());
        }
    }

}