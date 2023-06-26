package com.loginandsignup.models;

import android.graphics.drawable.Drawable;

public class product_item_cart {
    String name;
    Drawable image;
    String seller;
    Boolean isFavourite;
    String discounted_price;
    String actual_price;
    String rating;
    String discount;
    String noOfReviews;

    public product_item_cart(String name, Drawable image, String seller, Boolean isFavourite, String discounted_price, String actual_price, String rating, String discount, String noOfReviews) {
        this.name = name;
        this.image = image;
        this.seller = seller;
        this.isFavourite = isFavourite;
        this.discounted_price = discounted_price;
        this.actual_price = actual_price;
        this.rating = rating;
        this.discount = discount;
        this.noOfReviews = noOfReviews;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public product_item_cart() {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getNoOfReviews() {
        return noOfReviews;
    }

    public void setNoOfReviews(String noOfReviews) {
        this.noOfReviews = noOfReviews;
    }
}
