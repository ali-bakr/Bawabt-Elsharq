package com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.about_us.AboutUsFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.help_center.HelpCenterFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.polices_terms.PolicesTermsFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.questions.QuestionsFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.ship_address_setting.ShipAddressSettingFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.social.SocialFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.ship_address.ShipAddressFragment;

public class NavProfileFragment extends Fragment {
    Fragment clicked_Fragment=null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_nav_profile,container,false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        view.findViewById(R.id.profile_click_question_answers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicked_Fragment =new QuestionsFragment();
                openFragment(clicked_Fragment);
            }
        });

        view.findViewById(R.id.profile_click_ship_address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_Fragment =new ShipAddressFragment();
                openFragment(clicked_Fragment);
            }
        });
        view.findViewById(R.id.profile_click_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicked_Fragment =new SettingsFragment();
                openFragment(clicked_Fragment);
            }
        });

        view.findViewById(R.id.profile_click_social_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicked_Fragment =new SocialFragment();
                openFragment(clicked_Fragment);
            }
        });
        view.findViewById(R.id.profile_click_help_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_Fragment =new HelpCenterFragment();
                openFragment(clicked_Fragment);
            }
        });
        view.findViewById(R.id.profile_click_about_us).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_Fragment =new AboutUsFragment();
                openFragment(clicked_Fragment);
            }
        });

        view.findViewById(R.id.profile_click_polices_terms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_Fragment =new PolicesTermsFragment();
                openFragment(clicked_Fragment);
            }
        });


    }
     void openFragment(Fragment fragment){
         getActivity().getSupportFragmentManager().beginTransaction()
                 .replace(R.id.fragment_container, fragment, "findThisFragment")
                 .addToBackStack(null)
                 .commit();
     }

}
