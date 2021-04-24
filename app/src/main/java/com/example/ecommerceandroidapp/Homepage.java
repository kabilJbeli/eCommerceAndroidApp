package com.example.ecommerceandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ecommerceandroidapp.BO.ProduitAdapter;
import com.example.ecommerceandroidapp.entities.Produit;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
    private RecyclerView recycleviewProduit;
    private RecyclerView.LayoutManager layoutmanager;
    private ProduitAdapter produitAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        List<Produit> listproduit = new ArrayList<>();
        //list of product to be consumed from rest
        recycleviewProduit = findViewById(R.id.recycleview);
        layoutmanager = new LinearLayoutManager(this);
        recycleviewProduit.setLayoutManager(layoutmanager);
        produitAdapter =  new ProduitAdapter(listproduit, getApplicationContext());
        recycleviewProduit.setAdapter(produitAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycleviewProduit.getContext(),DividerItemDecoration.VERTICAL);
        recycleviewProduit.addItemDecoration(dividerItemDecoration);
    }
}