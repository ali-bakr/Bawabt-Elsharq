package com.aliaboubakr.bawabtelsharq.ui.fragments.intro_slider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.ui.activities.IntroActivity;
import com.aliaboubakr.bawabtelsharq.ui.activities.main_activity.MainActivity;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.NavHomeFragment;
import com.cuberto.liquid_swipe.LiquidPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SlideDFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_slide_d,container,false);

        Intent intent1 = new Intent(getActivity(), MainActivity.class);
        Window windowD = this.getActivity().getWindow();
        ((IntroActivity)getActivity()).updateStatusBarColor(R.color.status_color4);
         v.findViewById(R.id.skip_d).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(intent1);
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent i = new Intent(getActivity(), MainActivity.class);

             //   startActivity(intent1);
                // finish();
            }
        },300);


        return v;
    }

}
