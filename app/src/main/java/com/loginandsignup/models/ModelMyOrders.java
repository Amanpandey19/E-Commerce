package com.loginandsignup.models;

import android.graphics.drawable.Drawable;

public class ModelMyOrders {
    String name;
    Drawable image;
    String seller;
    String discounted_price;
    String actual_price;
    String discount;
    String delivery_text;

    public ModelMyOrders(String name, Drawable image, String seller, String discounted_price, String actual_price, String discount, String delivery_text) {
        this.name = name;
        this.image = image;
        this.seller = seller;
        this.discounted_price = discounted_price;
        this.actual_price = actual_price;
        this.discount = discount;
        this.delivery_text = delivery_text;
    }


    public ModelMyOrders() {
    }

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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(String discounted_price) {
        this.discounted_price = discounted_price;
    }

    public String getActual_price() {
        return actual_price;
    }

    public void setActual_price(String actual_price) {
        this.actual_price = actual_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDelivery_text() {
        return delivery_text;
    }

    public void setDelivery_text(String delivery_text) {
        this.delivery_text = delivery_text;
    }
}
