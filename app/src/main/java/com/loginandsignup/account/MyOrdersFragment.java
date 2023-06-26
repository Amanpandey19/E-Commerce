package com.loginandsignup.account;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.loginandsignup.models.ModelMyOrders;
import com.loginandsignup.R;

import java.util.ArrayList;

public class MyOrdersFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ModelMyOrders> myOrdersArrayList;
    MyOrdersAdapter myOrdersAdapter;
    Toolbar toolbar;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_orders, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_my_orders);
        toolbar.inflateMenu(R.menu.toolbar_menu);

       


        recyclerView=view.findViewById(R.id.my_orders_recycler_view);

        myOrdersArrayList=new ArrayList<>();

        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));

        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.denimjacket),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));
        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));
        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.product_2),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));


        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));

        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.denimjacket),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));
        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.cartproduct),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));
        myOrdersArrayList.add(new ModelMyOrders("Men Regular Fit Printed Cut Away Collar Casual Shirt",
                getResources().getDrawable(R.drawable.product_2),
                "By Denim ",
                "5600","7600","20","Delivered on 16th March"));


        myOrdersAdapter=new MyOrdersAdapter(getActivity(),myOrdersArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(myOrdersAdapter);

    }

}