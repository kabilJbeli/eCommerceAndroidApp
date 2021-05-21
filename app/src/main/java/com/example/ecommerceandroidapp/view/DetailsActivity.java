package com.example.ecommerceandroidapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.ecommerceandroidapp.R;
import com.example.ecommerceandroidapp.ViewModel.ToCartViewModel;
import com.example.ecommerceandroidapp.databinding.ActivityDetailsBinding;
import com.example.ecommerceandroidapp.model.Cart;
import com.example.ecommerceandroidapp.model.Product;
import com.example.ecommerceandroidapp.storage.LoginUtils;
import com.example.ecommerceandroidapp.utils.RequestCallback;

import static com.example.ecommerceandroidapp.utils.Constant.LOCALHOST;
import static com.example.ecommerceandroidapp.utils.Constant.PRODUCT;
import static com.example.ecommerceandroidapp.utils.Constant.PRODUCTID;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DetailsActivity";

    private ActivityDetailsBinding binding;
    private ToCartViewModel toCartViewModel;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        toCartViewModel = ViewModelProviders.of(this).get(ToCartViewModel.class);
        binding.addToCart.setOnClickListener(this);
        binding.buy.setOnClickListener(this);
        getProductDetails();
    }

    private void getProductDetails() {
        // Receive the product object
        product = getIntent().getParcelableExtra(PRODUCT);

        Log.d(TAG,"isFavourite " + product.isFavourite() + " isInCart " + product.isInCart());

        // Set Custom ActionBar Layout
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.action_bar_title_layout);
        ((TextView) findViewById(R.id.action_bar_title)).setText(product.getProductName());

        binding.nameOfProduct.setText(product.getProductName());
        binding.priceOfProduct.setText(String.valueOf(product.getProductPrice()));

        String imageUrl = LOCALHOST + product.getProductImage().replaceAll("\\\\", "/");
        Glide.with(this)
                .load(imageUrl)
                .into(binding.imageOfProduct);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.addToCart){
            insertToCart(() -> {
                product.setIsInCart(true);
            });
            Intent cartIntent = new Intent(DetailsActivity.this, CartActivity.class);
            startActivity(cartIntent);
        }else if(view.getId() == R.id.buy){
            Intent shippingIntent = new Intent(DetailsActivity.this, ShippingAddressActivity.class);
            shippingIntent.putExtra(PRODUCTID, product.getProductId());
            startActivity(shippingIntent);
        }
    }

    private void insertToCart(RequestCallback callback) {
        Cart cart = new Cart(LoginUtils.getInstance(this).getUserInfo().getId(), product.getProductId());
        toCartViewModel.addToCart(cart, callback);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
