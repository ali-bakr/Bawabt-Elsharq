package com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.aliaboubakr.bawabtelsharq.R;
import com.google.android.material.tabs.TabLayout;

public class ProfileProductFragment extends Fragment {
    View v;
    ViewPager viewPager;
    TabLayout tabLayout;

    public ProfileProductFragment(){
        // empty constructor "required"
    }

    public static ProfileProductFragment getInstance(){

        return new ProfileProductFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_profile_product,container,false);
        viewPager=v.findViewById(R.id.pager_product_profile);
        tabLayout=v.findViewById(R.id.tabs_product_profile);

        Log.e("arg", getArguments().getString("123"));
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        //viewpager
        setUpViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void setUpViewPager(ViewPager viewPager) {
        SectionsPagerAdapter pagerAdapter=new SectionsPagerAdapter(getChildFragmentManager());


        Bundle b =new Bundle();
        b.putString("11111",getArguments().getString("123"));

//        Log.e("message",String.valueOf(b.getInt("key",0)));

        OverviewProductFragment overviewProductFragment=new OverviewProductFragment();
        DetailsProductFragment detailsProductFragment=new DetailsProductFragment();

        overviewProductFragment.setArguments(b);
        detailsProductFragment.setArguments(b);

        pagerAdapter.addFragment(overviewProductFragment,"overview");
        pagerAdapter.addFragment(detailsProductFragment,"details");

        viewPager.setAdapter(pagerAdapter);


    }



}
