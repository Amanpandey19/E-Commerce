package com.loginandsignup.home.fashion;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.loginandsignup.R;
import com.loginandsignup.home.CategoriesAdapter;
import com.loginandsignup.home.DealsAdapter;
import com.loginandsignup.home.RecentlyViewedAdapterAdapter;
import com.loginandsignup.models.Categories;
import com.loginandsignup.models.Deals;
import com.loginandsignup.models.Recentproduct;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FashionFragment extends Fragment {

    ArrayList<Categories> categoriesArrayList;
    CategoriesAdapter categoriesAdapter;
    RecyclerView recyclerView;
    ImageSlider mainslider;

    ArrayList<Recentproduct> bestDeals;
    RecyclerView bestDealsRecyclerView;
    RecentlyViewedAdapterAdapter bestDealsAdapter;

    ArrayList<Deals> dealsArrayList;
    RecyclerView bestOffersRecyclerView;
    DealsAdapter      dealsAdapter;


    private Handler handler1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fashion, container, false);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //handler for clock  in best offers Section
        handler1=new Handler(Looper.getMainLooper());
        //////////////////

        recyclerView             = view.findViewById(R.id.recycler_View_fashion_categories);
        bestDealsRecyclerView    = view.findViewById(R.id.recycler_View_best_deals);
        bestOffersRecyclerView   = view.findViewById(R.id.recycler_View_fashion_offers_of_the_day);
        mainslider               = view.findViewById(R.id.image_slider);

        //Categories below the search view in home screen
        //Add items in your list here.
        categoriesArrayList=new ArrayList<>();

        categoriesArrayList.add(new Categories("Men",getResources().getDrawable( R.drawable.cartproduct)));
        categoriesArrayList.add(new Categories("Women",getResources().getDrawable( R.drawable.women)));
        categoriesArrayList.add(new Categories("Boys",getResources().getDrawable( R.drawable.boys)));
        categoriesArrayList.add(new Categories("Girls",getResources().getDrawable( R.drawable.girls)));
        categoriesArrayList.add(new Categories("Add-on",getResources().getDrawable( R.drawable.watches)));
        categoriesArrayList.add(new Categories("Shoes",getResources().getDrawable( R.drawable.shoes)));
        categoriesAdapter=new CategoriesAdapter(getContext(), categoriesArrayList,"Fashion");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(categoriesAdapter);
        /////////////////////////////////





        //Slider in home page
        //Third party library used for this, 'com.github.denzcoskun:ImageSlideshow:0.0.7'
        //Add images to slider here.
        List<SlideModel> slideList = new ArrayList<>();
        slideList.add(new SlideModel(R.drawable.fashion_banner_four, ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.fashion_banner_two,ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.fashion_banner_three,ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.fashion_banner_one,ScaleTypes.FIT));

        mainslider.setItemClickListener(i -> {

        });
        mainslider.setImageList(slideList, ScaleTypes.CENTER_INSIDE);
        ///////////////////////////////



        //Best deals recycler view
        //Add only 4-6 items so the UI looks good
        bestDeals = new ArrayList<>();
        bestDeals.add(new Recentproduct("PunnkFunnk Y20 GT Bluetooth Calling Smart watch with 1.7” Touch Display Smartwatch  (Black Strap, Free)","₹2,999",getResources().getDrawable(R.drawable.watches)));
        bestDeals.add(new Recentproduct("Solid Slim Fit Shirt","₹1,080",getResources().getDrawable(R.drawable.product_2)));
        bestDeals.add(new Recentproduct("Men Slim Fit Solid Cut Away Collar Casual Shirt","₹1,399",getResources().getDrawable(R.drawable.black_shirt)));
        bestDeals.add(new Recentproduct("RC2381 Men Brown Boots For Men  (Brown)","₹2,650",getResources().getDrawable(R.drawable.shoes)));

        bestDealsAdapter = new RecentlyViewedAdapterAdapter(getContext(), bestDeals);
        bestDealsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        bestDealsRecyclerView.setAdapter(bestDealsAdapter);
        //////////////////////////////



        //Offers Ending Recycler View
        //Add items in array list from here
        dealsArrayList=new ArrayList<>();

        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.fashion_offer_one)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.fashion_offer_three)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.fashion_offer_two)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.poster3)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.fashion_offer_three)));
        dealsAdapter=new DealsAdapter(getContext(),dealsArrayList);

        bestOffersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        bestOffersRecyclerView.setAdapter(dealsAdapter);
        /////////////////////////////////




        //Timer in Offers Ending Section
        //Time remaining is calculated as (today at 9 pm) - (current time)
        Thread t=new Thread(){
            @Override
            public void run() {
                try{
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        handler1.post(() -> {
                            TextView tv=view.findViewById(R.id.date);
                            TextView tv1=view.findViewById(R.id.date2);
                            TextView tv2=view.findViewById(R.id.date4);
                            Calendar calendar=Calendar.getInstance();
                            int hour=calendar.get(Calendar.HOUR_OF_DAY);
                            if(hour>12 && hour<21)
                            {
                                hour=8-calendar.get(Calendar.HOUR);
                            }
                            else
                            if(hour<=12)
                            {
                                hour=8-hour+12;
                            }
                            else
                            if(hour>=21)
                            {
                                hour=23-hour+21;
                            }
                            int min=calendar.get(Calendar.MINUTE);
                            int Sec=calendar.get(Calendar.SECOND);
                            min=59-min;
                            Sec=59-Sec;
                            String h=" "+hour;
                            String m=" "+min;
                            String s=" "+Sec;
                            tv.setText(h);
                            tv1.setText(m);
                            tv2.setText(s);
                        });
                    }
                }catch (InterruptedException e){

                }
            }
        };
        t.start();
        //////////////////////////////////

    }
}