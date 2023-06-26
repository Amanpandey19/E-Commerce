package com.loginandsignup.models;

import android.graphics.drawable.Drawable;

public class productItemList {
    String name;
    Drawable image;
    String seller;
    Boolean isFavourite;
    String discounted_price;
    String actual_price;
    Float rating;
    String discount;
    String deliveryText;

    public productItemList(String name, Drawable image, String seller, Boolean isFavourite, String discounted_price, String actual_price, Float rating, String discount, String deliveryText) {
        this.name = name;
        this.image = image;
        this.seller = seller;
        this.isFavourite = isFavourite;
        this.discounted_price = discounted_price;
        this.actual_price = actual_price;
        this.rating = rating;
        this.discount = discount;
        this.deliveryText = deliveryText;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDeliveryText() {
        return deliveryText;
    }

    public void setDeliveryText(String deliveryText) {
        this.deliveryText = deliveryText;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public productItemList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
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


}
