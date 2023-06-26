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
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.loginandsignup.ProductListActivity;
import com.loginandsignup.ProductListAdapter;
import com.loginandsignup.ProductListFragment;
import com.loginandsignup.R;
import com.loginandsignup.account.CartActivity;
import com.loginandsignup.account.TrackMyOrderFragment;
import com.loginandsignup.home.fashion.FashionFragment;
import com.loginandsignup.home.furniture.FurnitureFragment;
import com.loginandsignup.home.homeAppliances.HomeAppliancesFragment;
import com.loginandsignup.models.Categories;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.RecyclerviewHolder> {
    private ArrayList<Categories> categoriesArrayList = new ArrayList<>();
    Context context;
    String type="";


    public CategoriesAdapter(Context context, ArrayList<Categories> categoriesArrayList,String type) {
        this.context             = context;
        this.categoriesArrayList = categoriesArrayList;
        this.type                = type;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.img.setImageDrawable(categoriesArrayList.get(position).getImage());
        holder.Name.setText(categoriesArrayList.get(position).getName());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type.equals("Categories")){
                    switch (holder.getAdapterPosition()){
                        case 0:
                            FashionFragment fashionFragment=new FashionFragment();
                            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,fashionFragment).addToBackStack("").commit();
                            break;
                        case 1:
                            FurnitureFragment furnitureFragment=new FurnitureFragment();
                            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,furnitureFragment).addToBackStack("").commit();
                            break;
                        case 7:
                            HomeAppliancesFragment homeAppliancesFragment=new HomeAppliancesFragment();
                            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,homeAppliancesFragment).addToBackStack("").commit();
                            break;
                    }
                }else if(type.equals("Fashion")){
                    switch (holder.getAdapterPosition()){
                        case 0:
                            Intent intent = new Intent(context, ProductListActivity.class);
                            context.startActivity(intent);
                            break;

                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView img;
        CardView  cardView;


        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            Name              =   itemView.findViewById(R.id.categoryName);
            img               =   itemView.findViewById(R.id.categoryImage);
            cardView          =   itemView.findViewById(R.id.category_card);

        }

    }

}
