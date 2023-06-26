package com.loginandsignup.models;

import android.graphics.drawable.Drawable;

public class Categories {
    String name;
    Drawable image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Categories(String name, Drawable image) {
        this.name = name;
        this.image = image;
    }

    public Categories() {
    }
}
