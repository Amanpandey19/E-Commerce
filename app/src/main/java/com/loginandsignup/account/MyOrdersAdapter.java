package com.loginandsignup.account;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.loginandsignup.models.ModelMyOrders;
import com.loginandsignup.R;

import java.util.ArrayList;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.RecyclerviewHolder> {
    private ArrayList<ModelMyOrders> myOrdersArrayList = new ArrayList<>();
    Context context;


    public MyOrdersAdapter(Context context, ArrayList<ModelMyOrders> myOrdersArrayList) {
        this.context           = context;
        this.myOrdersArrayList = myOrdersArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_orders_item_layout, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.img.setImageDrawable(myOrdersArrayList.get(position).getImage());
        holder.Name.setText(myOrdersArrayList.get(position).getName());
        holder.seller.setText(myOrdersArrayList.get(position).getSeller());
        holder.discounted_price.setText("₹"+myOrdersArrayList.get(position).getDiscounted_price());
        holder.discount.setText("%"+myOrdersArrayList.get(position).getDiscount()+" OFF");
        holder.actual_price.setText("₹"+myOrdersArrayList.get(position).getActual_price());
        holder.delivery_text.setText(myOrdersArrayList.get(position).getDelivery_text());

        holder.my_order_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TrackMyOrderFragment myOrderFragment=new TrackMyOrderFragment();
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,myOrderFragment).addToBackStack("").commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return myOrdersArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView Name,seller;
        TextView discounted_price;
        TextView actual_price;
        TextView discount;
        ImageView img;
        TextView delivery_text;
        CardView my_order_Card;


        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            Name               =   itemView.findViewById(R.id.product_name_my_orders);
            img                =   itemView.findViewById(R.id.my_orders_item_image);
            seller             =   itemView.findViewById(R.id.seller_name_my_orders);
            discount           =   itemView.findViewById(R.id.product_discount_label_my_orders);
            discounted_price   =   itemView.findViewById(R.id.product_discount_price_my_orders);
            actual_price       =   itemView.findViewById(R.id.product_actual_price_my_orders);
            delivery_text      =   itemView.findViewById(R.id.delivery_text);
            my_order_Card      =   itemView.findViewById(R.id.my_orders_card);

        }

    }

}
