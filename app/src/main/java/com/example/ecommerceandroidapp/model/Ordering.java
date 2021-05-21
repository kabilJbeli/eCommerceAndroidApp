package com.example.ecommerceandroidapp.model;

import com.google.gson.annotations.SerializedName;

public class Ordering {

    @SerializedName("name_on_card")
    private String nameOnCard;
    @SerializedName("card_number")
    private String cardNumber;
    private int userId;
    private int productId;

    public Ordering(String nameOnCard, String cardNumber, int userId, int productId) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.userId = userId;
        this.productId = productId;
    }
}
