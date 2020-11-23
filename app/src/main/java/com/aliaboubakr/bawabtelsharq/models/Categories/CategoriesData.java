package com.aliaboubakr.bawabtelsharq.models.Categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesData {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("params")
    @Expose
    private Params params;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
