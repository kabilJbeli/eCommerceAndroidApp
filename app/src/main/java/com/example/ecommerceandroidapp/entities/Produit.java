package com.example.ecommerceandroidapp.entities;

import android.accessibilityservice.GestureDescription;

public class Produit {
    private String label;
    private String quantity;
    private String description;
    private String nomVendeur;
    private double prix;
    private boolean disponibilte;

    public Produit(String label, String quantity, String description, String nomVendeur, double prix, boolean disponibilte) {
        this.label = label;
        this.quantity = quantity;
        this.description=description;
        this.nomVendeur =nomVendeur;
        this.prix=prix;
        this.disponibilte = disponibilte;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDisponibilte(boolean disponibilte) {
        this.disponibilte = disponibilte;
    }

    public String getDescription() {
        return description;
    }

    public String getNomVendeur() {
        return nomVendeur;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isDisponibilte() {
        return disponibilte;
    }

    public String getQuantity() {
        return quantity;
    }
}
