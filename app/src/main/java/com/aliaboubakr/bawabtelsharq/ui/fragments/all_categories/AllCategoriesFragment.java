package com.aliaboubakr.bawabtelsharq.ui.fragments.all_categories;

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
import com.aliaboubakr.bawabtelsharq.models.Categories.CategoriesData;
import com.aliaboubakr.bawabtelsharq.models.Categories.Category;
import com.aliaboubakr.bawabtelsharq.ui.fragments.products.ProductsFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_supplier.ProfileSupplierFragment;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public  class AllCategoriesFragment  extends Fragment {

    private RecyclerView mAllCategoriesRecyclerView;
    private AllCategoriesAdapter allCategoriesAdapter;
    LinearLayoutManager vLinearLayoutManager;
    List categoriesList=null;
    ProgressBar progressBarAllCategories;
    ArrayList<Integer> main=new ArrayList<>();
    private LayoutAnimationController controller;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_categories,container,false);
      //  getAllCategories();
        controller= AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_slide_right);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAllCategoriesRecyclerView=view.findViewById(R.id.rv_all_categories);
        progressBarAllCategories= (ProgressBar)view.findViewById(R.id.spin_kit_categories);
        Sprite doubleBounce = new Circle();
        progressBarAllCategories.setIndeterminateDrawable(doubleBounce);
        vLinearLayoutManager = new LinearLayoutManager(getActivity());
        vLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAllCategoriesRecyclerView.setHasFixedSize(true);
        mAllCategoriesRecyclerView.setLayoutManager(vLinearLayoutManager);
       // progressBarAllCategories=view.findViewById(R.id.all_categories_progress);

        getAllCategories();
    }
    void getAllCategories(){

       Retrofit retrofit=RetrofitClient.getInstance();
       Api api= retrofit.create(Api.class);
       Call<CategoriesData> allCategoriesCall=api.getAllCategories(RetrofitClient.decodingBasicAuth());
       allCategoriesCall.enqueue(new Callback<CategoriesData>() {
            @Override
            public void onResponse(Call<CategoriesData> call, Response<CategoriesData> response) {

                categoriesList = response.body().getCategories();


                //list > data for  spcefice category
                mAllCategoriesRecyclerView.setLayoutAnimation(controller);
                if (controller!=null) {
                    mAllCategoriesRecyclerView.scheduleLayoutAnimation();
                }
                List<Category> categoryList= response.body().getCategories();
                for (int i = 0; i < categoriesList.size(); i++) {
                    if (categoryList.get(i).getParentId().equals("0")){
                        main.add(Integer.parseInt(categoryList.get(i).getCategoryId()));
                    }
                }

                Log.e ("main",main.toString());
                allCategoriesAdapter = new AllCategoriesAdapter(getActivity(), categoriesList);

                allCategoriesAdapter.AllCategoriesAdapter(new AllCategoriesAdapter.AllCategoriesClickListener() {
                    @Override
                    public void onClick(int position) {
                        Log.e("response", "click");
                        viewCategoryProducts(position,categoryList);
                    }
                });

                mAllCategoriesRecyclerView.setLayoutManager(vLinearLayoutManager);
                mAllCategoriesRecyclerView.setAdapter(allCategoriesAdapter);
                progressBarAllCategories.setVisibility(View.INVISIBLE);
                Log.e("response", "not null response");
                Log.e("response", response.message());
                       }

            @Override
            public void onFailure(Call<CategoriesData> call, Throwable t) {
                Log.e("failure", t.getMessage());
            }
        });


    }

    private void viewCategoryProducts(int position, List<Category> categoriesList) {


            Log.e("click category",categoriesList.get(position).getCategory());
            String category_id=categoriesList.get(position).getCategoryId();
            String category_name=categoriesList.get(position).getCategory();
            String category_product_count=categoriesList.get(position).getProductCount();

        Bundle bundle=new Bundle();
            bundle.putString("category_id",category_id);
            bundle.putString("category_name",category_name);
            bundle.putString("category_product_count",category_product_count);
            ProductsFragment productsFragment=new ProductsFragment();
            productsFragment.setArguments(bundle);

            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, productsFragment, "findThisFragment")
                    .addToBackStack(null)
                    .commit();


    }
}

