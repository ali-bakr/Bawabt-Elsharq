package com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.adapters;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.models.Categories.Category;
import com.aliaboubakr.bawabtelsharq.models.Products.Detailed;
import com.aliaboubakr.bawabtelsharq.models.Products.MainPair;
import com.aliaboubakr.bawabtelsharq.models.Products.Product;
import com.aliaboubakr.bawabtelsharq.models.Products.ProductsData;
import com.aliaboubakr.bawabtelsharq.models.Products.product.ProductData;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.OverviewProductFragment;
import com.aliaboubakr.bawabtelsharq.ui.fragments.profiles.profile_product.ProfileProductFragment;
import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.AllProductsVH> {
    private Activity activity;
    private List<Product> productList;
    private int newListSize;
  //  private  List<ProductsData> productsDataList;
    //
    private List<MainPair> mainPairList;
    public  AllProductClickListener allProductClickListener;

    //interface for  item clicks
    public  interface AllProductClickListener{
        void setOnClick(int position);
    }
    //constructor for clicks
    public void setOnClickProduct(AllProductsAdapter.AllProductClickListener allProductClickListener) {
        this.allProductClickListener = allProductClickListener;
    }
    public AllProductsAdapter(Activity activity, List<Product> productList,int newListSize) {
        this.activity = activity;
        this.productList = productList;
        this.newListSize=newListSize;
    }

    @NonNull
    @Override
    public AllProductsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(activity).inflate(R.layout.rv_item_product,parent,false);
        return new AllProductsVH(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull AllProductsVH holder, int position) {
        fillData(holder,position);

    }

    private void fillData(AllProductsVH holder, int position) {

        Product product= productList.get(position);
        Detailed detailed=productList.get(position).getMainPair().getDetailed();
       // ProductsData productsDataList=new ProductsData();
        //Log.e(".....",productsDataList.getParams().getTotalItems());
        String img_path_flag="https://static.thenounproject.com/png/1211233-200.png";
        //ProductData productData=productDataList.get(position);
if (product.getMainPair().getDetailed()!=null){
    double amount =Double.parseDouble(product.getPrice());
    String price=NumberFormat.getCurrencyInstance(new Locale("en", "US"))
            .format(amount);
    holder.name.setText(product.getProduct());
    holder.price.setText(price);
    String img_path=detailed.getImagePath();


    if (detailed!=null) {
      //  Log.e("log work", detailed.getImagePath());
        Glide.with(activity).load(detailed.getImagePath()).into(holder.productImage);

    }
}
else {
    Glide.with(activity).load(img_path_flag).into(holder.productImage);
}


    }

    @Override
    public int getItemCount() {
        //return productList.size();
return newListSize;
    }

    public class AllProductsVH extends RecyclerView.ViewHolder{
    TextView name,price,chatClick,cartClick;
    ImageView productImage;
    public AllProductsVH(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.tv_product_name_item);
        price=itemView.findViewById(R.id.tv_product_price_item);
        chatClick=itemView.findViewById(R.id.imgbtn_chat_supplier_item);
        cartClick=itemView.findViewById(R.id.imgbtn_cart_item);
        productImage=itemView.findViewById(R.id.tv_product_img_item);
        actionClick(itemView);
    }

    private void actionClick(View view){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allProductClickListener.setOnClick(getAdapterPosition());
            }
        });
    }
}

/*
name,price,addtoCart
 */

    // try paging
    /*

      Boolean isLoading=false;
    int visibleItemCount=0, totalItemCount=0,pastVisibleItem=0,previousTotal=0,page=1;
    int viewThreshold = 10;


     recyclerViewProducts.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount =layoutManager.getChildCount();
                totalItemCount =layoutManager.getChildCount();
                pastVisibleItem=layoutManager.findFirstVisibleItemPosition();

                if (dy > 0) {
                    if (isLoading) {
                        if (totalItemCount > previousTotal) {
                            isLoading = false;
                            previousTotal = totalItemCount;
                        }
                        Log.e("TAG", "performPagination()");
                    }
                    if (!isLoading && (totalItemCount - visibleItemCount) <= (pastVisibleItem + viewThreshold)) {
                        Log.e("TAG", "performPagination()");
                      //  avi.smoothToShow();
                        page++;
                        getAllProducts(page);
                       //     if (productCollectionList != null) {
                         //v   }
                           // avi.smoothToHide();

                        isLoading = true;
                        Log.e("TAG", "pageNumber " + page);
                    }

                }

     */

}
