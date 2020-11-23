package com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_supplier;

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
import com.aliaboubakr.bawabtelsharq.models.Vendors.Vendor;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileSupplierFragment extends Fragment {

    CircleImageView circleImageView;
    TextView vendorName,vendorEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile_supplier,container,false);

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    setIds(view);

      //Log.e("id profile supp",id);

    }

    private void setIds(View view) {

        vendorName=view.findViewById(R.id.tv_name_supplier_profile);
        vendorEmail=view.findViewById(R.id.tv_email_supplier_profile);
    getSupplierData();
    }

    private void getSupplierData() {

        Bundle b=this.getArguments();

        String id=b.getString("vendor_id");

       //  String id="12";
        Retrofit retrofit= RetrofitClient.getInstance();
        Api api=retrofit.create(Api.class);

        Call<Vendor> vendorCall=api.getVendorsDetails(RetrofitClient.decodingBasicAuth(),id);
        vendorCall.enqueue(new Callback<Vendor>() {
            @Override
            public void onResponse(Call<Vendor> call, Response<Vendor> response) {
                if (response.isSuccessful()){
                    vendorName.setText(response.body().getCompany());
                    vendorEmail.setText(response.body().getEmail());
                }
            }

            @Override
            public void onFailure(Call<Vendor> call, Throwable t) {
                Log.e("fail supplier profile",t.getMessage());
            }
        });


    }
}
