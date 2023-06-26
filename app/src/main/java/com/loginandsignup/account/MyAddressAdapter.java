package com.loginandsignup.account;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loginandsignup.models.Address;
import com.loginandsignup.R;

import java.util.ArrayList;

public class MyAddressAdapter extends RecyclerView.Adapter<MyAddressAdapter.RecyclerviewHolder> {
    private ArrayList<Address> addressArrayList = new ArrayList<>();
    Context context;

    public MyAddressAdapter(Context context, ArrayList<Address> addressArrayList) {
        this.context           = context;
        this.addressArrayList = addressArrayList;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item_layout, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        int addressNumber=position+1;
        holder.Name.setText(addressArrayList.get(position).getName());
        holder.address.setText(addressArrayList.get(position).getAddress());
        holder.city.setText(addressArrayList.get(position).getCity());
        holder.pinCode.setText(addressArrayList.get(position).getPinCode());
        holder.phone_number.setText("Phone Number : "+addressArrayList.get(position).getPhone_number());
        holder.address_number.setText("Address "+addressNumber);

    }

    @Override
    public int getItemCount() {
        return addressArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView address;
        TextView city;
        TextView pinCode;
        TextView phone_number;
        TextView address_number;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            Name                  =   itemView.findViewById(R.id.name_of_person);
            address               =   itemView.findViewById(R.id.complete_address);
            city                  =   itemView.findViewById(R.id.city_name);
            pinCode               =   itemView.findViewById(R.id.pincode);
            phone_number          =   itemView.findViewById(R.id.contact_number);
            address_number        =   itemView.findViewById(R.id.address_number);
        }

    }

}
