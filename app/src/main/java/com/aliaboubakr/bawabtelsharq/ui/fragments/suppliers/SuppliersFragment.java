package com.aliaboubakr.bawabtelsharq.ui.fragments.suppliers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.client.Api;
import com.aliaboubakr.bawabtelsharq.client.RetrofitClient;
import com.aliaboubakr.bawabtelsharq.models.Vendors.Vendor;
import com.aliaboubakr.bawabtelsharq.models.Vendors.VendorsData;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.ProfileProductFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_supplier.ProfileSupplierFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SuppliersFragment extends Fragment {
   RecyclerView recyclerView;
   SuppliersAdapters suppliersAdapter;
   LinearLayoutManager linearLayoutManager;
   List<Vendor> suppliersList;
   ProgressBar progressBar;
    private LayoutAnimationController controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_suppliers,container,false);
        controller= AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_slide_right);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setIds(view);


    }

    private void setIds(View view) {
    recyclerView=view.findViewById(R.id.rv_suppilers);
    linearLayoutManager=new LinearLayoutManager(getActivity());
    recyclerView.setHasFixedSize(true);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(linearLayoutManager);
    progressBar=view.findViewById(R.id.all_suppliers_progress);

    getAllSuppllers();
    }

    private void getAllSuppllers() {
        Retrofit retrofit=RetrofitClient.getInstance();
        Api api=retrofit.create(Api.class);
        Call<VendorsData> vendorsDataCall=api.getAllVendors(RetrofitClient.decodingBasicAuth());
        vendorsDataCall.enqueue(new Callback<VendorsData>() {
            @Override
            public void onResponse(Call<VendorsData> call, Response<VendorsData> response) {
                suppliersList=response.body().getVendors();
                if (response.body().getVendors()==null){
                    Log.e("null vendor","nul");
                }
                suppliersAdapter=new SuppliersAdapters(getActivity(),suppliersList);
                recyclerView.setAdapter(suppliersAdapter);


                recyclerView.setLayoutAnimation(controller);
                if (controller!=null) {
                    recyclerView.scheduleLayoutAnimation();
                }


                progressBar.setVisibility(View.GONE);

            suppliersAdapter.setOnClickSuppliers(new SuppliersAdapters.AllSuppliersClickListener() {
                @Override
                public void setOnClick(int position) {
                    vendorClick(position);
                    Log.e("clicked suppliers","yes");
                }
            });


            }



            @Override
            public void onFailure(Call<VendorsData> call, Throwable t) {

                Log.e("failll",t.getMessage());
            }
        });

    }

    private void vendorClick(int position) {
        Log.e("click fun","clicked");
        String supplier_id=suppliersList.get(position).getCompanyId();
        Bundle bundle=new Bundle();
        bundle.putString("vendor_id",supplier_id);
        ProfileSupplierFragment profileSupplierFragment=new ProfileSupplierFragment();
        profileSupplierFragment.setArguments(bundle);
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, profileSupplierFragment, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }
}
