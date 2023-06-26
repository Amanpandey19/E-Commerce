package com.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.loginandsignup.models.productItemList;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    ArrayList<productItemList> productItemListArrayList;
    RecyclerView recyclerView;
    ProductListAdapter productListAdapter;
    Toolbar toolbar;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerView=findViewById(R.id.product_list_recycler_view);
        toolbar = findViewById(R.id.toolbar_product_list);
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


        productListAdapter = new ProductListAdapter(ProductListActivity.this, productItemListArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(ProductListActivity.this, 2));
        recyclerView.setAdapter(productListAdapter);
    }
}