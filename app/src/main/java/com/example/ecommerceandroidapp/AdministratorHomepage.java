package com.example.ecommerceandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdministratorHomepage extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_homepage);
        ((Button)findViewById(R.id.gestioncommand)).setOnClickListener(this);
        ((Button)findViewById(R.id.gestionproduit)).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.gestioncommand:
                intent = new Intent(this, AdministratorHomepage.class);
                startActivity(intent);
                break;

            case R.id.gestionproduit:
                intent = new Intent(this, AdministratorHomepage.class);
                startActivity(intent);
                break;
        }
    }
}