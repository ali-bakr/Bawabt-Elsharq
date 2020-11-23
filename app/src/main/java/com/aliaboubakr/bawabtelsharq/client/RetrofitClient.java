package com.aliaboubakr.bawabtelsharq.client;
import android.util.Base64;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASEURL="https://www.gatetoeast.com/demo4/api/";
    private static Retrofit retrofit=null ;
    private static String header;


    public static String decodingBasicAuth(){

        String base = "support@bawabtalsharq.com:C16in4QukO5536UCe7R483ugvH903NVm";
        header = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

        return header;
    }
    public static Retrofit getInstance(){
        if (retrofit ==null) {
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            String base = "support@bawabtalsharq.com:C16in4QukO5536UCe7R483ugvH903NVm";
            header = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);


        }

        return  retrofit;
    }



}
