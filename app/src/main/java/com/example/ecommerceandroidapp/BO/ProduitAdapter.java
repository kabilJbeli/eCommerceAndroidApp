package com.example.ecommerceandroidapp.BO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceandroidapp.R;
import com.example.ecommerceandroidapp.entities.Produit;

import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder> {

    List<Produit> listeProduit;
    Context context;

    public ProduitAdapter(List<Produit> listeProduit, Context context) {
        this.listeProduit = listeProduit;
        this.context = context;
    }

    @NonNull
    @Override
    public ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlist, parent, false);
        ProduitViewHolder produitViewHolder = new ProduitViewHolder(view);
        return produitViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitViewHolder holder, int position) {
        Produit produit = listeProduit.get(position);
        holder.name.setText(produit.getLabel());
        holder.quantity.setText(produit.getQuantity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listeProduit.get(position).getLabel(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listeProduit.size();
    }

    public static class ProduitViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView quantity;

        public ProduitViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.textView);
            this.quantity = itemView.findViewById(R.id.textView2);
        }
    }

}


