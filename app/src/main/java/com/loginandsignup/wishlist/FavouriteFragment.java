package com.loginandsignup.wishlist;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loginandsignup.R;
import com.loginandsignup.models.product_item_cart;

import java.util.ArrayList;


public class FavouriteFragment extends Fragment {

    RecyclerView recyclerView;
    FavouritesAdapter favouritesAdapter;
    ArrayList<product_item_cart> product_item_cartArrayList;
    Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_my_wishlist);
        toolbar.inflateMenu(R.menu.toolbar_menu_wishlist);

        Drawable yourDrawable = toolbar.getMenu().getItem(0).getIcon();
        yourDrawable.mutate();
        yourDrawable.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);
        recyclerView=view.findViewById(R.id.favourites_recycler_view);

        product_item_cartArrayList=new ArrayList<>();

        product_item_cartArrayList.add(new product_item_cart
                ("Men Slim Fit Solid Casual Shirt",getResources().getDrawable(R.drawable.cartproduct),
                        "By Louis Philippe Jeans", true,"5600",
                        "7000","4.6","15","1178"));
        product_item_cartArrayList.add(new product_item_cart
                ("Yesto Activated Charcoal Bar Soap",getResources().getDrawable(R.drawable.soap),
                        "By Sharma General Store", true,"132",
                        "180","4.4","30","673"));
        product_item_cartArrayList.add(new product_item_cart
                ("SONY Xperia XA1 Plus (Black, 32 GB) (4 GB RAM)",getResources().getDrawable(R.drawable.xperia),
                        "By Croma Gallery", true,"14000",
                        "18000","4.7","23","1203"));
        product_item_cartArrayList.add(new product_item_cart
                ("Full Sleeve Solid Men Denim Jacket",getResources().getDrawable(R.drawable.denimjacket),
                        "By Denim ", true,"3600",
                        "5000","4.8","28","185"));
        product_item_cartArrayList.add(new product_item_cart
                ("Apple Royal Gala (Regular)",getResources().getDrawable(R.drawable.apples),
                        "By Rajesh Fruit Shop", true,"140",
                        "160","4.1","15","16"));

        product_item_cartArrayList.add(new product_item_cart
                ("Men Slim Fit Solid Casual Shirt",getResources().getDrawable(R.drawable.cartproduct),
                        "By Louis Philippe Jeans", true,"5600",
                        "7000","4.6","15","1178"));
        product_item_cartArrayList.add(new product_item_cart
                ("Yesto Activated Charcoal Bar Soap",getResources().getDrawable(R.drawable.soap),
                        "By Sharma General Store", true,"132",
                        "180","4.4","30","673"));
        product_item_cartArrayList.add(new product_item_cart
                ("SONY Xperia XA1 Plus (Black, 32 GB) (4 GB RAM)",getResources().getDrawable(R.drawable.xperia),
                        "By Croma Gallery", true,"14000",
                        "18000","4.7","23","1203"));
        product_item_cartArrayList.add(new product_item_cart
                ("Full Sleeve Solid Men Denim Jacket",getResources().getDrawable(R.drawable.denimjacket),
                        "By Denim ", true,"3600",
                        "5000","4.8","28","185"));
        product_item_cartArrayList.add(new product_item_cart
                ("Apple Royal Gala (Regular)",getResources().getDrawable(R.drawable.apples),
                        "By Rajesh Fruit Shop", true,"140",
                        "160","4.1","15","16"));

        product_item_cartArrayList.add(new product_item_cart
                ("Men Slim Fit Solid Casual Shirt",getResources().getDrawable(R.drawable.cartproduct),
                        "By Louis Philippe Jeans", true,"5600",
                        "7000","4.6","15","1178"));
        product_item_cartArrayList.add(new product_item_cart
                ("Yesto Activated Charcoal Bar Soap",getResources().getDrawable(R.drawable.soap),
                        "By Sharma General Store", true,"132",
                        "180","4.4","30","673"));
        product_item_cartArrayList.add(new product_item_cart
                ("SONY Xperia XA1 Plus (Black, 32 GB) (4 GB RAM)",getResources().getDrawable(R.drawable.xperia),
                        "By Croma Gallery", true,"14000",
                        "18000","4.7","23","1203"));
        product_item_cartArrayList.add(new product_item_cart
                ("Full Sleeve Solid Men Denim Jacket",getResources().getDrawable(R.drawable.denimjacket),
                        "By Denim ", true,"3600",
                        "5000","4.8","28","185"));
        product_item_cartArrayList.add(new product_item_cart
                ("Apple Royal Gala (Regular)",getResources().getDrawable(R.drawable.apples),
                        "By Rajesh Fruit Shop", true,"140",
                        "160","4.1","15","16"));



        favouritesAdapter=new FavouritesAdapter(getContext(),product_item_cartArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(favouritesAdapter);

    }
}