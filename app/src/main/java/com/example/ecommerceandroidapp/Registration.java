package com.example.ecommerceandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText name,phone,email,password, bankaccount;
    Button b1;

    public static final String MyPREFERENCES = "registrationpreference" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";
    public static final String Bankaccount = "bankaccountKey";
    public static final String Firstlogin = "firstlogin";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name=(EditText)findViewById(R.id.editText);
        phone=(EditText)findViewById(R.id.editText2);
        email=(EditText)findViewById(R.id.editText3);
        password=(EditText)findViewById(R.id.editText4);
        bankaccount=(EditText)findViewById(R.id.editText4);

        b1=(Button)findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameuser  = name.getText().toString();
                String phoneuser  = phone.getText().toString();
                String emailuser  = email.getText().toString();
                String passworduser  = password.getText().toString();
                String bancaccountuser  = bankaccount.getText().toString();
                if (isEmailValid(emailuser) && isNamevalid(nameuser) && isBankAccountalid(bancaccountuser) && isPasswordValid(passworduser) && isPhonevalid(phoneuser)) {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Name, nameuser);
                    editor.putString(Phone, phoneuser);
                    editor.putString(Email, emailuser);
                    editor.putString(Password, passworduser);
                    editor.putString(Bankaccount, bancaccountuser);
                    editor.putString(Firstlogin, "false");
                    editor.commit();
                    Toast.makeText(Registration.this, "Welcome", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(Registration.this, "please check your parameters", Toast.LENGTH_LONG).show();

            }
        });
    }

    private boolean isEmailValid(String mail) {
        return mail.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private boolean isBankAccountalid(String bankaccount) {
        return bankaccount.length() == 14;
    }

    private boolean isNamevalid(String name) {
        return name.length() > 4;
    }

    private boolean isPhonevalid(String phone) {
        return name.length() == 8;
    }


}