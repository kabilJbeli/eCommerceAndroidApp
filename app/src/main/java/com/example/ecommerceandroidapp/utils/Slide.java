package com.example.ecommerceandroidapp.utils;

import com.example.ecommerceandroidapp.R;

import java.util.ArrayList;

public class Slide {

    private static final ArrayList<Integer> slides = new ArrayList<Integer>() {{
        add(R.drawable.slide6);
        add(R.drawable.slide7);
    }};

    public static ArrayList<Integer> getSlides() {
        return slides;
    }
}
