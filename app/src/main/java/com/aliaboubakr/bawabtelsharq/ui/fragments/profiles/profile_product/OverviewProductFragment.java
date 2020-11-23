package com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product;

import android.os.Bundle;
import android.util.Log;
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
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OverviewProductFragment extends Fragment {
    ImageSlider imageSlider;
    TextView mProdctPrice,mProductShortDesc,mProductMinQ,mProductMaxQ,mProductAmount;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_product_overview,container,false);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // mProdctName=view.findViewById(R.id.tv_name_product_overview);
        callProductOverView(getArguments().getString("11111"),view);
    }

    private void sliderInitialization(View view,String imag_path,String product_name) {
        imageSlider=view.findViewById(R.id.image_slider);
        mProductShortDesc=view.findViewById(R.id.tv_short_des_product_overview);
        mProductMinQ=view.findViewById(R.id.tv_min_q_product_overview);
        mProductMaxQ=view.findViewById(R.id.tv_max_q_product_overview);
        mProductAmount=view.findViewById(R.id.tv_items_count_product_overview);
        mProdctPrice=view.findViewById(R.id.tv_price_product_overview);
        List<SlideModel> sliderModelsArrayList = new ArrayList<>();
        sliderModelsArrayList.add(new SlideModel(imag_path,product_name, ScaleTypes.FIT));
        //   rvSlider.setAdapter(sliderAdapterExample);
        imageSlider.setImageList(sliderModelsArrayList);

    }


    private void callProductOverView(String id,View view) {

        //int x=b.getInt("key");
        Retrofit retrofit= RetrofitClient.getInstance();
        Api api=retrofit.create(Api.class);
        Call<ProductData> productCall=api.getProductsDetails(RetrofitClient.decodingBasicAuth(),id);
        productCall.enqueue(new Callback<ProductData>() {
            @Override
            public void onResponse(Call<ProductData> call, Response<ProductData> response) {
               // Log.e("hi","response.body().getProductId()");

                if (response.isSuccessful()){
               //     Log.e("hihi",String.valueOf(x));
                    String img_path=response.body().getProductMainPair().getDetailedProduct().getImagePath();

                   // String img_path="https://www.bawabtalsharq.com/images/promo/2/Medicine_and_Health__.jpg";


                    if (img_path.equals(null)||img_path.equals("")){
                        img_path="https://www.bawabtalsharq.com/images/promo/2/Medicine_and_Health__.jpg";

                       // Log.e("img_____nul______",response.body().().getImagePath());
                    }
                    String product_name=response.body().getProduct();
                    if ((product_name!=null)&&(img_path!=null)) {
                        sliderInitialization(view, img_path, product_name);
                    }
                mProductShortDesc.setText("Short Description : "+response.body().getShortDescription());
                    mProductAmount.setText(response.body().getAmount()+"  items");
                    mProductMaxQ.setText("max Quantity : "+response.body().getMaxQty());
                    mProductMinQ.setText("min Quantity : "+response.body().getMaxQty());

                    double amount =Double.parseDouble(response.body().getPrice());
                    String final_price = NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                            .format(amount);

                    mProdctPrice.setText("Price : "+final_price);
                }

                Log.e("hi",response.body().getBasePrice());
            }

            @Override
            public void onFailure(Call<ProductData> call, Throwable t) {
                Log.e("fuck overview call",t.getMessage());
            }
        });

    }
}
