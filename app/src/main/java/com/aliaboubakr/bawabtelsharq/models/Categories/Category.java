package com.aliaboubakr.bawabtelsharq.models.Categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("id_path")
    @Expose
    private String idPath;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("product_count")
    @Expose
    private String productCount;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }
}
