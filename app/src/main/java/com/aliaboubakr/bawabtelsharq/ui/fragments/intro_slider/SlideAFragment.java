package com.aliaboubakr.bawabtelsharq.ui.fragments.intro_slider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.ui.activities.IntroActivity;
import com.aliaboubakr.bawabtelsharq.ui.activities.main_activity.MainActivity;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.NavHomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SlideAFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_slide_a,container,false);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        Window window = this.getActivity().getWindow();

        ((IntroActivity)getActivity()).updateStatusBarColor(R.color.status_color1);
        v.findViewById(R.id.skip_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });

        return v;
    }
}
