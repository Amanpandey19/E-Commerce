package com.loginandsignup.account;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loginandsignup.R;
import com.loginandsignup.account.CartActivity;
import com.loginandsignup.account.EditProfileFragment;
import com.loginandsignup.account.MyAddressFragment;
import com.loginandsignup.account.MyOrdersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MyAccountFragment extends Fragment {

    CardView my_orders,edit_profile,my_cart,my_wishlist,my_address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        my_orders=view.findViewById(R.id.card_my_orders);
        edit_profile=view.findViewById(R.id.card_edit_profile);
        my_cart=view.findViewById(R.id.card_my_cart);
        my_wishlist=view.findViewById(R.id.card_my_wishlist);
        my_address = view.findViewById(R.id.card_my_addresses);

        edit_profile.setOnClickListener(view1 -> getFragmentManager().beginTransaction().replace(R.id.flFragment, new EditProfileFragment()).addToBackStack(" ").commit());

        my_wishlist.setOnClickListener(view13 -> ((BottomNavigationView)getActivity().findViewById(R.id.bottom_navigation)).setSelectedItemId(R.id.favourite));

        my_cart.setOnClickListener(view12 -> {
            Intent intent = new Intent(getActivity(), CartActivity.class);
            startActivity(intent);
        });

        my_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.flFragment, new MyOrdersFragment()).addToBackStack(" ").commit();

            }
        });

        my_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.flFragment, new MyAddressFragment()).addToBackStack(" ").commit();
            }
        });
    }
}