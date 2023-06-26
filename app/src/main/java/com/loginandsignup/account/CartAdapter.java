package com.loginandsignup.account;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loginandsignup.R;
import com.loginandsignup.models.product_item_cart;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.RecyclerviewHolder> {
    private ArrayList<product_item_cart> product_item_cartArrayList = new ArrayList<>();
    Context context;


    public CartAdapter(Context context, ArrayList<product_item_cart> product_item_cartArrayList) {
        this.context           = context;
        this.product_item_cartArrayList = product_item_cartArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.img.setImageDrawable(product_item_cartArrayList.get(position).getImage());
        holder.Name.setText(product_item_cartArrayList.get(position).getName());
        holder.seller.setText(product_item_cartArrayList.get(position).getSeller());
        holder.discounted_price.setText("₹"+product_item_cartArrayList.get(position).getDiscounted_price());
        holder.discount.setText("%"+product_item_cartArrayList.get(position).getDiscount()+" OFF");
        holder.actual_price.setText("₹"+product_item_cartArrayList.get(position).getActual_price());
        holder.rating.setText(product_item_cartArrayList.get(position).getRating());
        holder.noOfReviews.setText("("+product_item_cartArrayList.get(position).getNoOfReviews()+" reviews)");
        holder.fav_icon.setChecked(product_item_cartArrayList.get(position).getFavourite());




    }

    @Override
    public int getItemCount() {
        return product_item_cartArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView Name,seller;
        CheckBox fav_icon;
        TextView discounted_price;
        TextView actual_price;
        TextView discount;
        TextView rating;
        TextView noOfReviews;
        ImageView img;


        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            Name               =   itemView.findViewById(R.id.product_name_cart);
            img                =   itemView.findViewById(R.id.cart_item_image);
            seller             =   itemView.findViewById(R.id.seller_name_cart);
            fav_icon           =   itemView.findViewById(R.id.fav_icon_cart);
            discount           =   itemView.findViewById(R.id.product_discount_label_cart);
            discounted_price   =   itemView.findViewById(R.id.product_discount_price_cart);
            actual_price       =   itemView.findViewById(R.id.product_actual_price_cart);
            rating             =   itemView.findViewById(R.id.product_rating_cart);
            noOfReviews        =   itemView.findViewById(R.id.number_of_ratings_cart);


        }

    }

}
