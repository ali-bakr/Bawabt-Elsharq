package com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.client.Api;
import com.aliaboubakr.bawabtelsharq.client.RetrofitClient;
import com.aliaboubakr.bawabtelsharq.models.Products.product.ProductData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsProductFragment extends Fragment {
    TextView fullDescription;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_product_details,container,false);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fullDescription=view.findViewById(R.id.tv_description_fragment_detailes);

        callProductDescription(getArguments().getString("11111"));
    }

    private void callProductDescription(String id) {


        Retrofit retrofit = RetrofitClient.getInstance();
        Api api=retrofit.create(Api.class);
       Call<ProductData> productCall = api.getProductsDetails(RetrofitClient.decodingBasicAuth(),id);
       productCall.enqueue(new Callback<ProductData>() {
           @Override
           public void onResponse(Call<ProductData> call, Response<ProductData> response) {

               if (response.isSuccessful()){

                  // fullDescription.setText(response.body().getFullDescription());

                   String strippedText = response.body().getFullDescription().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ");
                  fullDescription.setText(strippedText);
               }

           }

           @Override
           public void onFailure(Call<ProductData> call, Throwable t) {

           }
       });
    }
}
