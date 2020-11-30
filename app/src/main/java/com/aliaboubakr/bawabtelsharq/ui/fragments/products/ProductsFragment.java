package com.aliaboubakr.bawabtelsharq.ui.fragments.products;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
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
import com.aliaboubakr.bawabtelsharq.models.Products.product.ProductData;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.adapters.AllProductsAdapter;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.ProfileProductFragment;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductsFragment extends Fragment {
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

        View v = inflater.inflate(R.layout.fragment_products,container,false);
        controller= AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_slide_up);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initiate(view);
        getAllProducts();

    }

    private void initiate(View view) {

       Bundle bundle =this.getArguments();

        progressBar = (ProgressBar)view.findViewById(R.id.spin_kit);
        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        recyclerViewProducts=view.findViewById(R.id.rv_products);
        noProductImg=view.findViewById(R.id.no_product_img);

      /*
        if(bundle.getString("category_product_count").equals("0")){

            Log.e("ttt","t");
            noProductImg.setVisibility(View.VISIBLE);
        }


       */

        categoryName=view.findViewById(R.id.tv_ctegory_name_product_fragment);
        linearLayoutManager=new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false);
        recyclerViewProducts.setHasFixedSize(true);
      //  recyclerViewProducts.setLayoutManager(linearLayoutManager);



    }

    private void getAllProducts() {


        Bundle bundle=this.getArguments();
        String id="8";
      //  String name;
        id=bundle.getString("category_id");
    String  name=bundle.getString("category_name");
    Log.e("name",name);

    categoryName.setText(name);
    Retrofit retrofit=RetrofitClient.getInstance();
        Api api =retrofit.create(Api.class);
        Call<ProductsData> productsDataCall=api.getCategoryProducts(RetrofitClient.decodingBasicAuth(),id);
        productsDataCall.enqueue(new Callback<ProductsData>() {
            @Override
            public void onResponse(Call<ProductsData> call, Response<ProductsData> response) {

                if (response.isSuccessful()) {

                    progressBar.setVisibility(View.GONE);
                    productsList = response.body().getProducts();

                    if (response.body().getProducts()==null){
                        Log.e("ttt","t");
                        noProductImg.setVisibility(View.VISIBLE);
                    }
                    if (productsList.size()==0){
                        noProductImg.setVisibility(View.VISIBLE);
                    }
                    else {
                        noProductImg.setVisibility(View.INVISIBLE);
                    }

                    for (int i = 0; i <productsList.size() ; i++) {
                        if (response.body().getProducts().get(i).getMainPair()==null){
                            Log.e("___null object",String.valueOf(i));
                            productsList.remove(i);
                        }else { Log.e("___not null object",String.valueOf(i));

                        }
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
