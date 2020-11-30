package com.aliaboubakr.bawabtelsharq.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.NavHomeFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.intro_slider.LiquidViewPager;
import com.aliaboubakr.bawabtelsharq.ui.fragments.intro_slider.SlideAFragment;
import com.cuberto.liquid_swipe.LiquidPager;

public class IntroActivity extends AppCompatActivity {

    LiquidPager pager;
    LiquidViewPager viewPager;
    public static int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.intro_container,
                    new SlideAFragment()).commit();
        }


 */

        pager=findViewById(R.id.pager);
        viewPager=new LiquidViewPager(getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);

        String a=""+pager.getCurrentItem();

        Log.e("current",a);
    }

    public void updateStatusBarColor(int color){// Color must be in hexadecimal fromat
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }
}