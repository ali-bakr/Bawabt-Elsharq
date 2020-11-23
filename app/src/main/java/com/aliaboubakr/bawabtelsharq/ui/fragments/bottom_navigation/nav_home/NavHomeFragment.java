 package com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.client.Api;
import com.aliaboubakr.bawabtelsharq.client.RetrofitClient;
import com.aliaboubakr.bawabtelsharq.models.Products.Product;
import com.aliaboubakr.bawabtelsharq.models.Products.ProductsData;
import com.aliaboubakr.bawabtelsharq.ui.fragments.all_categories.AllCategoriesFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.adapters.AllProductsAdapter;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.ProfileProductFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.suppliers.SuppliersFragment;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public  class NavHomeFragment extends Fragment {

    ImageSlider imageSlider;
    List <Product> productsList=null;
    List <Product> productItems=new ArrayList<>();
    ProgressBar progressBar;

    AllProductsAdapter allProductsAdapter;
    RecyclerView recyclerViewProducts;
    LinearLayoutManager layoutManager;
    Retrofit retrofit = RetrofitClient.getInstance();
    Api api = retrofit.create(Api.class);
    private LayoutAnimationController controller;


    NestedScrollView nestedScrollView;

    Boolean isLoading=false;
    int visibleItemCount=0, totalItemCount=0,pastVisibleItem=0,previousTotal=0,page=1;
    int viewThreshold = 10;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_nav_home,container,false);
        setHasOptionsMenu(true);


        controller= AnimationUtils.loadLayoutAnimation(getActivity(),R.anim.layout_slide_up);
        progressBar = (ProgressBar)v.findViewById(R.id.spin_kit);
        Sprite doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        progressBar.setVisibility(View.INVISIBLE);


        return v;

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutManager=new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false);
        recyclerViewProducts=view.findViewById(R.id.rv_all_products_home);
        nestedScrollView=view.findViewById(R.id.nestedScrollView);
        recyclerViewProducts.setHasFixedSize(true);
        recyclerViewProducts.setLayoutManager(layoutManager);
        getAllProducts(page);




        nestedScrollView.setOnScrollChangeListener(((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {

            visibleItemCount = layoutManager.getChildCount();
            totalItemCount = layoutManager.getItemCount();
            pastVisibleItem = layoutManager.findFirstVisibleItemPosition();
            Log.e("TAG", "dy " + scrollY);
            Log.e("TAG", "dy " + oldScrollY);
            // dy = dy+1;
            if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                if (isLoading) {
                    if (totalItemCount > previousTotal) {
                        isLoading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!isLoading && (totalItemCount - visibleItemCount) <= (pastVisibleItem + viewThreshold)) {
                    Log.e("TAG", "performPagination()");
                   // progressBar.setVisibility(View.VISIBLE);
                    page++;
                    //avi.smoothToShow();
                   if (page>1) {
                       progressBar.setVisibility(View.VISIBLE);
                   }

                    getAllProducts(page);
                }
            }
        }));







        sliderInitialization(view);
        view.findViewById(R.id.view_all_categories_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAllCategories();

            }
        });
        view.findViewById(R.id.view_all_all_suppliers_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAllSuppilers();
            }
        });


}


    // menue onCreateOptionsMenu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_option, menu);
        MenuItem menuItem=menu.findItem(R.id.search_itme);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //   usersAdapter.getFilter().filter(newText);

                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }


    // menue  onOptionsItemSelected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


       if (item.getItemId() == R.id.search_itme) {
            Log.e("too","too");


        }
        return super.onOptionsItemSelected(item);
    }

    private void sliderInitialization(View view) {
        imageSlider=view.findViewById(R.id.image_slider);

        List<SlideModel> sliderModelsArrayList = new ArrayList<>();
        sliderModelsArrayList.add(new SlideModel("https://www.bawabtalsharq.com/images/promo/11/Agricultural.jpg","AGRICULTER & CROUPS", ScaleTypes.FIT));
        sliderModelsArrayList.add(new SlideModel("https://www.bawabtalsharq.com/images/promo/2/Medicine_and_Health__.jpg","MEDICINE & HEALTH", ScaleTypes.FIT));
        sliderModelsArrayList.add(new SlideModel("https://www.bawabtalsharq.com/images/promo/2/skin_care.jpg","SKIN CARE", ScaleTypes.FIT));


        //   rvSlider.setAdapter(sliderAdapterExample);
          imageSlider.setImageList(sliderModelsArrayList);

    }

    //try paging
    private void getAllProducts(int page) {
        Call<ProductsData> productsDataCall=api.getAllProducts(RetrofitClient.decodingBasicAuth(),page,20,"A");
        productsDataCall.enqueue(new Callback<ProductsData>() {
            @Override
            public void onResponse(Call<ProductsData> call, Response<ProductsData> response) {

                if (response.isSuccessful()) {


               //     allProductsAdapter.notifyDataSetChanged();

                    productsList = response.body().getProducts();
                    productItems.addAll(productsList);
                    allProductsAdapter = new AllProductsAdapter(getActivity(), productItems,productItems.size());
                    recyclerViewProducts.setLayoutManager(layoutManager);
                    recyclerViewProducts.setLayoutAnimation(controller);
                  /*
                    if (controller!=null) {
                        recyclerViewProducts.scheduleLayoutAnimation();
                    }


                   */
                    allProductsAdapter.setOnClickProduct(new AllProductsAdapter.AllProductClickListener() {
                        @Override
                        public void setOnClick(int position) {
                            productClick(position);
                            Log.e("click2","clicked");
                        }
                    });
                    recyclerViewProducts.setAdapter(allProductsAdapter);
                    progressBar.setVisibility(View.INVISIBLE);

                    //   progressBarAllCategories.setVisibility(View.GONE);
                    Log.e("response", "not null response");

                   // ProductsData product=response.body();
                     //  productItems.addAll(productsList);
                   //    allProductsAdapter.notifyDataSetChanged();

                 //   allProductsAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<ProductsData> call, Throwable t) {
                Log.e("failure", t.getMessage());
            }
        });

    }


   /*
    private void getAllProducts() {
        Call<ProductsData> productsDataCall=api.getAllProducts(RetrofitClient.decodingBasicAuth());
        productsDataCall.enqueue(new Callback<ProductsData>() {
            @Override
            public void onResponse(Call<ProductsData> call, Response<ProductsData> response) {

                if (response.isSuccessful()) {


                   productsList = response.body().getProducts();



                   allProductsAdapter = new AllProductsAdapter(getActivity(), productsList);
                   recyclerViewProducts.setLayoutManager(layoutManager);
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


    */






    private void productClick(int position) {

        Log.e("click fun","clicked");
       //do not forget replace the new list.position before click on the products page
        String product_id=productItems.get(position).getProductId();

        Bundle b=new Bundle();
        b.putString("123",product_id);
        ProfileProductFragment profileProductFragment=new ProfileProductFragment();
        profileProductFragment.setArguments(b);
       getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, profileProductFragment, "findThisFragment")
                .addToBackStack(null)
                .commit();
  }

    private void openAllCategories() {
        //Bundle bundle=new Bundle();
        //bundle.putInt("key",1212);
        AllCategoriesFragment allCategoriesFragment=new AllCategoriesFragment();
        //allCategoriesFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, allCategoriesFragment, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    private void openAllSuppilers() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SuppliersFragment(), "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

}
