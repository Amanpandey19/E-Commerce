package com.loginandsignup.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.loginandsignup.account.MyAccountFragment;
import com.loginandsignup.R;
import com.loginandsignup.account.CartActivity;
import com.loginandsignup.account.EditProfileFragment;
import com.loginandsignup.account.MyOrdersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.loginandsignup.models.BottomNavigationViewBehavior;
import com.loginandsignup.wishlist.FavouriteFragment;


public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    FloatingActionButton scanBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        scanBtn              = findViewById(R.id.scan_to_pay);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


        //Side navigation
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                DrawerLayout drawer = findViewById(R.id.drawerLayout);
                switch (item.getItemId()) {
                    case R.id.option_home:
                        drawer.closeDrawer(GravityCompat.START);
                        bottomNavigationView.setSelectedItemId(R.id.home);
                        return true;

                    case R.id.option_my_profile:
                        drawer.closeDrawer(GravityCompat.START);
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new EditProfileFragment()).commit();
                        return true;

                    case R.id.option_my_orders:
                        drawer.closeDrawer(GravityCompat.START);
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new MyOrdersFragment()).commit();
                        return true;

                    case R.id.option_my_cart:
                        drawer.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.option_customer_support:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "Providing Support", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.option_logout:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "Logging out now", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.option_english:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "Changing Language", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.option_privacy_policy:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "Privacy Policy", Toast.LENGTH_SHORT).show();
                        return true;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //Scan to pay (Floating Action Button)
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Scan to Pay", Toast.LENGTH_SHORT).show();
            }
        });

    }


    //Bottom Navigation
    HomeFragment homeFragment = new HomeFragment();
    MyAccountFragment myAccountFragment = new MyAccountFragment();
    FavouriteFragment favouriteFragment = new FavouriteFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                return true;

            case R.id.account:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, myAccountFragment).commit();
                return true;

            case R.id.services:
                Toast.makeText(HomeActivity.this, "Working on it", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.favourite:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, favouriteFragment).commit();
                return true;
        }
        return false;
    }


}