package com.loginandsignup.home;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.loginandsignup.ProductActivity;
import com.loginandsignup.R;
import com.loginandsignup.models.Recentproduct;

import java.util.ArrayList;

public class RecentlyViewedAdapterAdapter extends RecyclerView.Adapter<RecentlyViewedAdapterAdapter.RecyclerviewHolder> {
    private ArrayList<Recentproduct> recentproductArrayList = new ArrayList<>();
    Context context;


    public RecentlyViewedAdapterAdapter(Context context, ArrayList<Recentproduct> recentproductArrayList) {
        this.context           = context;
        this.recentproductArrayList = recentproductArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recentrly_viewed_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.img.setImageDrawable(recentproductArrayList.get(position).getImage());
        holder.Name.setText(recentproductArrayList.get(position).getName());
        holder.price.setText(recentproductArrayList.get(position).getPrice());

        holder.item_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return recentproductArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView  Name;
        ImageView img;
        TextView  price;
        CardView  item_card;


        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            Name           =   itemView.findViewById(R.id.recent_name);
            img            =   itemView.findViewById(R.id.recent_image);
            price          =   itemView.findViewById(R.id.recent_price);
            item_card      =   itemView.findViewById(R.id.product_item_cart);
        }

    }

}
