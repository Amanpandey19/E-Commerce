package com.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.loginandsignup.home.RecentlyViewedAdapterAdapter;
import com.loginandsignup.models.Recentproduct;
import com.loginandsignup.models.ReviewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {


    ImageSlider mainSlider;
    CardView increment, decrement;
    int count = 1;
    TextView qty;
    RecyclerView recyclerView;
    ReviewAdapter reviewAdapter;
    ArrayList<ReviewModel> reviewModels;
    ArrayList<Recentproduct> recentproductArrayList;
    RecentlyViewedAdapterAdapter recentlyViewedAdapterAdapter;
    RecyclerView recentlyViewedRV;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mainSlider        = findViewById(R.id.product_image_slider);
        increment         = findViewById(R.id.increment);
        recyclerView      = findViewById(R.id.review_recycler_view);
        decrement         = findViewById(R.id.decrement);
        recentlyViewedRV  = findViewById(R.id.recycler_View_recently_viewed);
        qty               = findViewById(R.id.qty);





        //Recycler view for reviews of a product
        //add item to your list here
        reviewModels = new ArrayList<>();
        reviewModels.add(new ReviewModel("Aman",getDrawable(R.drawable.user_one),"12/03/2022",
                        "Got my t-shirt the other day - absolutely love it, " +
                        "feels so thick and good quality, so will hopefully " +
                        "stand the test of time. Really like the ethos and " +
                        "focus of the company on quality, and although its" +
                        " quite a bit more than I would usually pay for a " +
                        "t-shirt I'm more than happy to do so for the quality and ethos",4.5f));
        reviewModels.add(new ReviewModel("Rohan",getDrawable(R.drawable.user_three),"01/07/2021",
                        "Everything was great, from ordering to wearing!! And my " +
                        "previous t-shirt washes and irons beautifully and is a " +
                        "pleasure to wear. The ordering system is easy, delivery " +
                        "is speedy and the parcel is beautifully and sustainably " +
                        "wrapped. Thank you! Tessa",3.5f));
        reviewModels.add(new ReviewModel("Anushka",getDrawable(R.drawable.user_four),"23/07/2021",
                        "I am so glad to have discovered your company and your items " +
                        "have formed the starting point of a capsule wardrobe that I " +
                        "am building, which is all about buying key pieces that are" +
                        " good quality and will wash well and last longer. Keep doing" +
                        " what you are doing, your products are lovely and great quality",4.0f));
        reviewModels.add(new ReviewModel("Ayushi",getDrawable(R.drawable.user_five),"19/09/2020",
                        "I bought three, fitted white T-shirts for my tall, slim, " +
                        "athletic teenage son and they look great on him. The fit" +
                        " is superb and I love that they are organic. We are delighted " +
                        "customers, so thank you.",4.0f));
        reviewModels.add(new ReviewModel("Ramit",getDrawable(R.drawable.user_two),"12/03/2022",
                        "I am so sorry to hear you are going and hope that the right person" +
                        " comes along soon – I hope that you will let us know! I wear the " +
                        "“white sleeveless cotton vest” 24/7 and found yours to be the best. " +
                        "Despite searching, I am unable to find anything comparable.",3.5f));
        reviewAdapter = new ReviewAdapter(ProductActivity.this,reviewModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(ProductActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(reviewAdapter);
        //////////////////////////////////





        //Quantity increment and decrement
        increment.setOnClickListener(view -> setIncrement());
        decrement.setOnClickListener(view -> setDecrement());
        ///////////////////////





        //Slider
        //Add images to slider here
        List<SlideModel> slideList = new ArrayList<>();
        slideList.add(new SlideModel(R.drawable.black_shirt, ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.balck_shirt_two, ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.black_shirt, ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.balck_shirt_two, ScaleTypes.FIT));
        slideList.add(new SlideModel(R.drawable.black_shirt, ScaleTypes.FIT));
        mainSlider.setImageList(slideList, ScaleTypes.CENTER_INSIDE);


        //on clicking of an image in slider
        mainSlider.setItemClickListener(i -> {
            //Todo
            //Zoom image effect
            //or open a new screen with image
        });
        /////////////////////////////



        //Recently viewed products recycler view on product page
        //add items to your list here
        recentproductArrayList = new ArrayList<>();
        recentproductArrayList.add(new Recentproduct("BRITISH TAN FULL GRAIN LEATHER SHOE","₹580",getResources().getDrawable(R.drawable.product_3)));
        recentproductArrayList.add(new Recentproduct("Solid Slim Fit Shirt","₹1080",getResources().getDrawable(R.drawable.product_2)));
        recentproductArrayList.add(new Recentproduct("Vu Premium TV 4K 50inch (1.26 Mtr)","₹1400",getResources().getDrawable(R.drawable.product_1)));
        recentproductArrayList.add(new Recentproduct("Ugaoo Air Purifier Indoor Plants for Home with Pots- Areca Palm & ZZ Plant","₹1100",getResources().getDrawable(R.drawable.product_4)));

        recentlyViewedAdapterAdapter = new RecentlyViewedAdapterAdapter(ProductActivity.this, recentproductArrayList);
        recentlyViewedRV.setLayoutManager(new GridLayoutManager(ProductActivity.this, 2));
        recentlyViewedRV.setAdapter(recentlyViewedAdapterAdapter);
        //////////////////////////////////////

    }

    @SuppressLint("SetTextI18n")
    public void setIncrement() {
        count++;
        qty.setText("" + count);
    }

    @SuppressLint("SetTextI18n")
    public void setDecrement() {
        if (count > 1)
        {
            count--;
            qty.setText(""+count);
        }
}
}