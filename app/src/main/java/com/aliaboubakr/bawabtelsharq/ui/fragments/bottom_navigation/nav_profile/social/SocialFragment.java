package com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_profile.social;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aliaboubakr.bawabtelsharq.R;

public class SocialFragment extends Fragment {

    private String instaPackage="com.instagram.android",instaLink="https://www.instagram.com/bawabtalsharq_b2b";
    private String facePackage="com.facebook.katana",faceLink="https://www.facebook.com/Bawabtalsharqegypt/";
    private String twitterPackage="com.twitter.android",twitterLink="https://twitter.com/AlsharqBawabt";
    private String linkedinPackage="com.linkedin.android",linkedinLink="https://www.linkedin.com/company/bawabtalsharq";
    private String youtubePackage="com.youtube.android",youtubeLink="https://www.youtube.com/channel/UCrxsSE1877L5p9pPrb1VHsQ";
    private String whatsappPackage="com.whatsapp",whatsappLink="https://api.whatsapp.com/send?phone=+201111526888";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_social,container,false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.social_click_face).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openSocialApp(facePackage,faceLink);
            }
        });
        view.findViewById(R.id.social_click_insta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("click","insta");
                openSocialApp(instaPackage,instaLink);
            }
        });
        view.findViewById(R.id.social_click_twitter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSocialApp(twitterPackage,twitterLink);
            }
        });
        view.findViewById(R.id.social_click_linkedin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSocialApp(linkedinPackage,linkedinLink);
            }
        });
        view.findViewById(R.id.social_click_youtube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSocialApp(youtubePackage,youtubeLink);
            }
        });
        view.findViewById(R.id.social_click_whatsapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSocialApp(whatsappPackage,whatsappLink);
            }
        });


    }

    void openSocialApp(String appPackage , String appLink){

        Uri uri= Uri.parse(appLink);
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage(appPackage);
        try {
            startActivity(intent);
            Toast.makeText(this.getActivity(), "We Will Direct You Now", Toast.LENGTH_SHORT).show();
        }catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,uri));

        }

    }
}
