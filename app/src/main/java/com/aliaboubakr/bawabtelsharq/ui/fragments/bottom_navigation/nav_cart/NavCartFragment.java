package com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aliaboubakr.bawabtelsharq.ui.fragments.intro_slider.LiquidViewPager;
import com.aliaboubakr.bawabtelsharq.R;
import com.cuberto.liquid_swipe.LiquidPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public  class NavCartFragment extends Fragment {
    LiquidPager pager;
    LiquidViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_nav_cart,container,false);

        return v;
    }
}
