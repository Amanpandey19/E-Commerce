package com.loginandsignup.home;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loginandsignup.R;
import com.loginandsignup.models.Deals;

import java.util.ArrayList;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.RecyclerviewHolder> {
    private ArrayList<Deals> deals = new ArrayList<>();
    Context context;


    public DealsAdapter(Context context, ArrayList<Deals> categoriesArrayList) {
        this.context           = context;
        this.deals = categoriesArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_of_the_day_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.img.setImageDrawable(deals.get(position).getImage());



    }

    @Override
    public int getItemCount() {
        return deals.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        ImageView img;


        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            img          =   itemView.findViewById(R.id.deal_image);

        }

    }

}
