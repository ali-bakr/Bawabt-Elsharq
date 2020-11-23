package com.aliaboubakr.bawabtelsharq.models.Products;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductsData {

        @SerializedName("products")
        @Expose
        private List<Product> products = null;
        @SerializedName("params")
        @Expose
        private Params params;

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public Params getParams() {
            return params;
        }

        public void setParams(Params params) {
            this.params = params;
        }


    }
