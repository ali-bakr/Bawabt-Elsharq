package com.aliaboubakr.bawabtelsharq.ui.fragments.intro_slider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aliaboubakr.bawabtelsharq.ui.activities.IntroActivity;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.about_us.AboutUsFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.questions.QuestionsFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.ship_address_setting.ShipAddressSettingFragment;

public class LiquidViewPager extends FragmentPagerAdapter  {
    public LiquidViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new SlideAFragment();
            case 1: return new SlideBFragment();
            case 2: return new SlideCFragment();
            case 3: return new SlideDFragment();

        }
    return null;
    }
    @Override
    public int getCount() {
        return 4;
    }

}
