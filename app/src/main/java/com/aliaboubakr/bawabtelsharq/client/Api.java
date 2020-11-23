package com.aliaboubakr.bawabtelsharq.client;

import com.aliaboubakr.bawabtelsharq.models.Categories.CategoriesData;
import com.aliaboubakr.bawabtelsharq.models.Products.ProductsData;
import com.aliaboubakr.bawabtelsharq.models.Products.product.ProductData;
import com.aliaboubakr.bawabtelsharq.models.Vendors.Vendor;
import com.aliaboubakr.bawabtelsharq.models.Vendors.VendorsData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

@GET ("categories")
    Call<CategoriesData> getAllCategories(@Header("Authorization") String str);

  //  @GET ("products?page=1&items_per_page=20&status=A")
//    Call<ProductsData> getAllProducts(@Header("Authorization") String str);

    @GET ("products")
    Call<ProductsData> getAllProducts(@Header("Authorization") String str2,@Query("page") int page,@Query("items_per_page") int items_per_page,@Query("status") String status);


    // @GET ("products")
     //Call<ProductsData> getAllProducts(@Header("Authorization") String str);

    @GET ("products/{id}")
    Call<ProductData> getProductsDetails(@Header("Authorization") String str, @Path("id") String id);

    @GET ("vendors")
    Call<VendorsData> getAllVendors(@Header("Authorization") String str);

    @GET ("vendors/{id}")
    Call<Vendor> getVendorsDetails(@Header("Authorization") String str, @Path("id") String id);

    @GET ("categories/{id}/products&status=A")
    Call<ProductsData> getCategoryProducts(@Header("Authorization") String str, @Path("id") String id);


}


