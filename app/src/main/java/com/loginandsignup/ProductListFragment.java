package com.loginandsignup;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loginandsignup.models.productItemList;

import java.util.ArrayList;


public class ProductListFragment extends Fragment {

    ArrayList<productItemList> productItemListArrayList;
    RecyclerView recyclerView;
    ProductListAdapter productListAdapter;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.product_list_recycler_view);
        toolbar = view.findViewById(R.id.toolbar_product_list);
        toolbar.inflateMenu(R.menu.toolbar_menu);

        productItemListArrayList=new ArrayList<>();
        productItemListArrayList.add(new productItemList("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                false,"₹5600","₹7600",4.5f,"15% Off","Free Delivery in 2 days"));


        productItemListArrayList.add(new productItemList("PunnkFunnk Y20 GT Bluetooth Calling Smart watch with 1.7” Touch Display Smartwatch  (Black Strap, Free)",
                getResources().getDrawable(R.drawable.watches),
                "By PunnkFunnk", true,"₹2,999","₹5,999",3.5f,"50% Off","Free Delivery by tomorrow"));

        productItemListArrayList.add(new productItemList("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.black_shirt),
                "By Dennis Lingo  ",
                false,"₹500","₹1849",4.1f,"70% Off","Free Delivery by Sunday"));

        productItemListArrayList.add(new productItemList("RC2381 Men Brown Boots For Men  (Brown)",
                getResources().getDrawable(R.drawable.shoes),
                "By RED CHIEF  ",
                true,"₹2,650","₹2,945",3.5f,"10% Off","Delivery by 5 Jul, Tuesday"));


        productItemListArrayList.add(new productItemList("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.product_2),
                "By Denim ",
                false,"7600","20",4.5f,"15% Off","Free Delivery in 2 days"));
        productItemListArrayList.add(new productItemList("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                false,"7600","20",4.5f,"15% Off","Free Delivery in 2 days"));
        productItemListArrayList.add(new productItemList("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                false,"7600","20",4.5f,"15% Off","Free Delivery in 2 days"));
        productItemListArrayList.add(new productItemList("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                false,"7600","20",4.5f,"15% Off","Free Delivery in 2 days"));
        productItemListArrayList.add(new productItemList("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                false,"7600","20",4.5f,"15% Off","Free Delivery in 2 days"));


        productListAdapter = new ProductListAdapter(getContext(), productItemListArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(productListAdapter);
    }
}