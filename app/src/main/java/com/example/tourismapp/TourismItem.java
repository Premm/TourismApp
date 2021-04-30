package com.example.tourismapp;

import android.graphics.drawable.Drawable;

public class TourismItem {
    private String description, title;
    private int image;

    public TourismItem(String title, String description, int image){
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage(){
        return image;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

}
