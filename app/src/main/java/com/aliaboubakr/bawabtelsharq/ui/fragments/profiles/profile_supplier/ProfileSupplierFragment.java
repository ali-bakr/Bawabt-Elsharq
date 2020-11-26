package com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_supplier;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.client.Api;
import com.aliaboubakr.bawabtelsharq.client.RetrofitClient;
import com.aliaboubakr.bawabtelsharq.models.Products.Product;
import com.aliaboubakr.bawabtelsharq.models.Products.ProductsData;
import com.aliaboubakr.bawabtelsharq.models.Vendors.Vendor;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.adapters.AllProductsAdapter;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.ProfileProductFragment;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileSupplierFragment extends Fragment {

    TextView vendorName,vendorEmail;
    RecyclerView recyclerViewProducts;
    AllProductsAdapter allProductsAdapter;
    LinearLayoutManager linearLayoutManager;
    TextView categoryName;
    List<Product> productsList=null;
    private LayoutAnimationController controller;
    ImageView noProductImg;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile_supplier,container,false);

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    initiate(view);

      //Log.e("id profile supp",id);

    }

    private void initiate(View view) {

        vendorName=view.findViewById(R.id.tv_name_supplier_profile);
        vendorEmail=view.findViewById(R.id.tv_email_supplier_profile);


        progressBar = (ProgressBar)view.findViewById(R.id.spin_kit_supplier_product);
        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        recyclerViewProducts=view.findViewById(R.id.rv_products_supplier_products);
        noProductImg=view.findViewById(R.id.no_product_img_supplier);


        //
     //   categoryName=view.findViewById(R.id.tv_ctegory_name_product_fragment);
        linearLayoutManager=new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false);
        recyclerViewProducts.setHasFixedSize(true);

        getSupplierData();
        getAllProducts();
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


    private void getAllProducts() {


        Bundle bundle=this.getArguments();
        String id="8";
        id=bundle.getString("vendor_id");
        Retrofit retrofit=RetrofitClient.getInstance();
        Api api =retrofit.create(Api.class);
        Call<ProductsData> productsDataCall=api.getVendorsProducts(RetrofitClient.decodingBasicAuth(),id);
        productsDataCall.enqueue(new Callback<ProductsData>() {
            @Override
            public void onResponse(Call<ProductsData> call, Response<ProductsData> response) {

                if (response.isSuccessful()) {

                    progressBar.setVisibility(View.GONE);
                    productsList = response.body().getProducts();

                    if (productsList.size()==0){
                        noProductImg.setVisibility(View.VISIBLE);
                    }
                    else {
                        noProductImg.setVisibility(View.INVISIBLE);
                    }


                    allProductsAdapter = new AllProductsAdapter(getActivity(), productsList,productsList.size());


                    recyclerViewProducts.setLayoutManager(linearLayoutManager);
                    recyclerViewProducts.setLayoutAnimation(controller);
                    if (controller!=null) {
                        recyclerViewProducts.scheduleLayoutAnimation();
                    }


                    allProductsAdapter.setOnClickProduct(new AllProductsAdapter.AllProductClickListener() {
                        @Override
                        public void setOnClick(int position) {
                            productClick(position);
                            Log.e("click2","clicked");
                        }
                    });
                    recyclerViewProducts.setAdapter(allProductsAdapter);
                    //   progressBarAllCategories.setVisibility(View.GONE);
                    Log.e("response", "not null response");
                }

            }

            @Override
            public void onFailure(Call<ProductsData> call, Throwable t) {
                Log.e("failure", t.getMessage());
            }
        });

    }
    private void productClick(int position) {

        Log.e("click fun","clicked");
        String product_id=productsList.get(position).getProductId();
        Bundle b=new Bundle();
        b.putString("123",product_id);
        ProfileProductFragment profileProductFragment=new ProfileProductFragment();
        profileProductFragment.setArguments(b);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, profileProductFragment, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }
}
