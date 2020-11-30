package com.aliaboubakr.bawabtelsharq.ui.fragments.intro_slider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.NavHomeFragment;
import com.cuberto.liquid_swipe.LiquidPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SlideContainerFragment extends Fragment {
    LiquidPager pager;
    LiquidViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.slide_container_fragment,container,false);

        pager=v.findViewById(R.id.pager);
        viewPager=new LiquidViewPager(this.getActivity().getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
        navBar.setVisibility(View.INVISIBLE);


        return v;

    }
}
