package com.aliaboubakr.bawabtelsharq.models.Vendors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("items_per_page")
    @Expose
    private Integer itemsPerPage;
    @SerializedName("sort_order")
    @Expose
    private String sortOrder;
    @SerializedName("sort_by")
    @Expose
    private String sortBy;
    @SerializedName("sort_order_rev")
    @Expose
    private String sortOrderRev;
    @SerializedName("total_items")
    @Expose
    private String totalItems;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrderRev() {
        return sortOrderRev;
    }

    public void setSortOrderRev(String sortOrderRev) {
        this.sortOrderRev = sortOrderRev;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }
}
