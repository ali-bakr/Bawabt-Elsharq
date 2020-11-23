package com.aliaboubakr.bawabtelsharq.ui.activities.main_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_cart.NavCartFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.NavHomeFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_messenger.NavMessengerFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.NavProfileFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.OverviewProductFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.ProfileProductFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new NavHomeFragment()).commit();
        }
    }





    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new NavHomeFragment();
                            break;
                        case R.id.nav_messenger:
                            selectedFragment = new NavMessengerFragment();
                            break;
                        case R.id.nav_cart:
                            selectedFragment = new NavCartFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new NavProfileFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

}