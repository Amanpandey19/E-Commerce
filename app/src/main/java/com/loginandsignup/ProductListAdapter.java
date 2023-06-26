package com.loginandsignup;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.loginandsignup.models.ModelMyOrders;
import com.loginandsignup.models.productItemList;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.RecyclerviewHolder> {
    private ArrayList<productItemList> productItemListArrayList = new ArrayList<>();
    Context context;


    public ProductListAdapter(Context context, ArrayList<productItemList> productItemListArrayList) {
        this.context           = context;
        this.productItemListArrayList = productItemListArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.Name.setText(productItemListArrayList.get(position).getName());
        holder.delivery_text.setText(productItemListArrayList.get(position).getDeliveryText());
        holder.actual_price.setText(productItemListArrayList.get(position).getActual_price());
        holder.discounted_price.setText(productItemListArrayList.get(position).getDiscounted_price());
        holder.discount.setText(productItemListArrayList.get(position).getDiscount());
        holder.isFavourite.setChecked(productItemListArrayList.get(position).getFavourite());
        holder.seller.setText(productItemListArrayList.get(position).getSeller());
        holder.ratingBar.setRating(productItemListArrayList.get(position).getRating());
        holder.img.setImageDrawable(productItemListArrayList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return productItemListArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView Name,seller;
        TextView discounted_price;
        TextView actual_price;
        TextView discount;
        ImageView img;
        TextView delivery_text;
        RatingBar ratingBar;
        CheckBox isFavourite;
        CardView product_list_item_card;



        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            Name                   =   itemView.findViewById(R.id.product_list_name);
            img                    =   itemView.findViewById(R.id.product_list_image);
            seller                 =   itemView.findViewById(R.id.product_list_seller_name);
            discount               =   itemView.findViewById(R.id.product_list_discount);
            discounted_price       =   itemView.findViewById(R.id.product_list_price);
            actual_price           =   itemView.findViewById(R.id.product_list_striked_price);
            delivery_text          =   itemView.findViewById(R.id.product_list_delivery_details);
            product_list_item_card =   itemView.findViewById(R.id.product_item_list);
            ratingBar              =   itemView.findViewById(R.id.ratingBar_product_list);
            isFavourite            =   itemView.findViewById(R.id.isfavourite);


        }

    }

}
