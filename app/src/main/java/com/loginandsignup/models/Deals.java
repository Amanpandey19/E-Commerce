package com.loginandsignup.models;

import android.graphics.drawable.Drawable;

public class Deals {
    Drawable image;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Deals( Drawable image) {
        this.image = image;
    }

    public Deals() {
    }
}
