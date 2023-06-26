package com.loginandsignup.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.loginandsignup.R;
import com.loginandsignup.models.product_item_cart;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    ArrayList<product_item_cart> product_item_cartArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=findViewById(R.id.cart_RV);

        product_item_cartArrayList=new ArrayList<>();

        product_item_cartArrayList.add(new product_item_cart
                ("Men Slim Fit Solid Casual Shirt",getResources().getDrawable(R.drawable.cartproduct),
                        "By Louis Philippe Jeans", true,"5600",
                        "7000","4.6","15","1178"));
        product_item_cartArrayList.add(new product_item_cart
                ("SONY Xperia XA1 Plus (Black, 32 GB) (4 GB RAM)",getResources().getDrawable(R.drawable.xperia),
                        "By Croma Gallery", false,"14000",
                        "18000","4.7","23","1203"));
        product_item_cartArrayList.add(new product_item_cart
                ("Full Sleeve Solid Men Denim Jacket",getResources().getDrawable(R.drawable.denimjacket),
                        "By Denim ", false,"3600",
                        "5000","4.8","28","185"));
        product_item_cartArrayList.add(new product_item_cart
                ("Apple Royal Gala (Regular)",getResources().getDrawable(R.drawable.apples),
                        "By Rajesh Fruit Shop", true,"140",
                        "160","4.1","15","16"));




        cartAdapter=new CartAdapter(CartActivity.this,product_item_cartArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(cartAdapter);

    }
}