package com.loginandsignup.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.loginandsignup.R;
import com.loginandsignup.account.CartActivity;
import com.loginandsignup.models.Categories;
import com.loginandsignup.models.Deals;
import com.loginandsignup.models.Recentproduct;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment {

    ArrayList<Categories> categoriesArrayList;
    CategoriesAdapter categoriesAdapter;

    ArrayList<Deals> dealsArrayList;
    DealsAdapter      dealsAdapter;

    ArrayList<Recentproduct> recentproductArrayList;
    RecentlyViewedAdapterAdapter recentlyViewedAdapterAdapter;

    RecyclerView recyclerView;
    RecyclerView recentlyViewedRV, dealRV,dealsOfTheDayRV;
    ImageSlider mainslider;

    ScrollView scrollView;
    private Handler handler1;
    ImageView view_cart;
    Animation from_bottom,to_bottom;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility"})
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        from_bottom= AnimationUtils.loadAnimation(getActivity(),R.anim.front_bottom_anim);
        to_bottom= AnimationUtils.loadAnimation(getActivity(),R.anim.to_bottom_anim);
        //handler for image slider in home screen
        handler1=new Handler(Looper.getMainLooper());
        //////////////////

        //Finding all ids here
        recyclerView             = view.findViewById(R.id.recycler_View_categories);
        dealRV                   = view.findViewById(R.id.recycler_View_offers_of_the_day);
        recentlyViewedRV         = view.findViewById(R.id.recycler_View_recently_viewed);
        dealsOfTheDayRV          = view.findViewById(R.id.recycler_View_deals);
        mainslider               = view.findViewById(R.id.image_slider);
        view_cart                = view.findViewById(R.id.view_cart);
        scrollView               = view.findViewById(R.id.home_scroll_view);
        BottomAppBar bottomAppBar=(getActivity().findViewById(R.id.bottom_app_bar));
        FloatingActionButton fab= (getActivity().findViewById(R.id.scan_to_pay));

        ///////////////////////////////



        //Cart icon on top right corner
        //cart activity opening on click of button
        view_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CartActivity.class);
                startActivity(intent);

            }
        });
        /////////////////////////////////


        //Categories below the search view in home screen
        //Add items in your list here.
        categoriesArrayList=new ArrayList<>();

        categoriesArrayList.add(new Categories("Fashion",getResources().getDrawable( R.drawable.fashion)));
        categoriesArrayList.add(new Categories("Furniture",getResources().getDrawable( R.drawable.furniture)));
        categoriesArrayList.add(new Categories("Grocery",getResources().getDrawable( R.drawable.groceries)));
        categoriesArrayList.add(new Categories("Mobile",getResources().getDrawable( R.drawable.mobile)));
        categoriesArrayList.add(new Categories("Tech",getResources().getDrawable( R.drawable.tech)));
        categoriesArrayList.add(new Categories("Sports",getResources().getDrawable( R.drawable.sports)));
        categoriesArrayList.add(new Categories("Toys",getResources().getDrawable( R.drawable.toys)));
        categoriesArrayList.add(new Categories("Home",getResources().getDrawable( R.drawable.appliances)));
        categoriesArrayList.add(new Categories("Watches",getResources().getDrawable( R.drawable.watches)));
        categoriesAdapter=new CategoriesAdapter(getContext(), categoriesArrayList,"Categories");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(categoriesAdapter);
        /////////////////////////////////



        //Recently viewed recycler view
        //Add only 4-6 items so the UI looks good
        recentproductArrayList = new ArrayList<>();
        recentproductArrayList.add(new Recentproduct("BRITISH TAN FULL GRAIN LEATHER SHOE","₹580",getResources().getDrawable(R.drawable.product_3)));
        recentproductArrayList.add(new Recentproduct("Solid Slim Fit Shirt","₹1,080",getResources().getDrawable(R.drawable.product_2)));
        recentproductArrayList.add(new Recentproduct("Vu Premium TV 4K 50inch (1.26 Mtr)","₹1,400",getResources().getDrawable(R.drawable.product_1)));
        recentproductArrayList.add(new Recentproduct("Ugaoo Air Purifier Indoor Plants for Home with Pots- Areca Palm & ZZ Plant","₹1,100",getResources().getDrawable(R.drawable.product_4)));

        recentlyViewedAdapterAdapter = new RecentlyViewedAdapterAdapter(getContext(), recentproductArrayList);
        recentlyViewedRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recentlyViewedRV.setAdapter(recentlyViewedAdapterAdapter);
        //////////////////////////////


        //Deals of the day recycler view
        //array list and the adapter is used from above recycler view
        // you can create a separate list and new instance of same adapter (since both "deals of the day" and "Recently viewed" UI look same)
        dealsOfTheDayRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        dealsOfTheDayRV.setAdapter(recentlyViewedAdapterAdapter);
        ////////////////////////////



        //Slider in home page
        //Third party library used for this, 'com.github.denzcoskun:ImageSlideshow:0.0.7'
        //Add images to slider here.
        List<SlideModel> slideList = new ArrayList<>();
        slideList.add(new SlideModel(R.drawable.online_shopping_poster_one,ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.online_shopping_poster_four,ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.online_shopping_poster_two,ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.banner_image_1,ScaleTypes.FIT));

        mainslider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {

            }
        });
        mainslider.setImageList(slideList, ScaleTypes.CENTER_INSIDE);
        ///////////////////////////////


       scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
           @Override
           public void onScrollChange(View view, int i, int i1, int i2, int i3) {
              if(i1<i3){
                   bottomAppBar.performShow(true);
                   fab.show();
               }else {
                   bottomAppBar.performHide(true);
                   fab.hide();
               }
           }
       });


        //Offers Ending Recycler View
        //Add items in array list from here
        dealsArrayList=new ArrayList<>();

        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.poster2)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.poster3)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.poster2)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.poster3)));
        dealsArrayList.add(new Deals(getResources().getDrawable( R.drawable.poster2)));
        dealsAdapter=new DealsAdapter(getContext(),dealsArrayList);

        dealRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        dealRV.setAdapter(dealsAdapter);
        /////////////////////////////////




        //Timer in Offers Ending Section
        //Time remaining is calculated as (today at 9 pm) - (current time)
        Thread t=new Thread(){
            @Override
            public void run() {
                try{
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        handler1.post(new Runnable() {
                            @Override
                            public void run() {
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
                            }
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