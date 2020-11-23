package com.aliaboubakr.bawabtelsharq.models.Categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("visible")
    @Expose
    private Boolean visible;
    @SerializedName("current_category_id")
    @Expose
    private Integer currentCategoryId;
    @SerializedName("simple")
    @Expose
    private Boolean simple;
    @SerializedName("plain")
    @Expose
    private Boolean plain;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("item_ids")
    @Expose
    private String itemIds;
    @SerializedName("group_by_level")
    @Expose
    private Boolean groupByLevel;
    @SerializedName("get_images")
    @Expose
    private Boolean getImages;
    @SerializedName("category_delimiter")
    @Expose
    private String categoryDelimiter;
    @SerializedName("get_frontend_urls")
    @Expose
    private Boolean getFrontendUrls;
    @SerializedName("max_nesting_level")
    @Expose
    private Object maxNestingLevel;
    @SerializedName("get_company_name")
    @Expose
    private Boolean getCompanyName;
    @SerializedName("items_per_page")
    @Expose
    private Integer itemsPerPage;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("except_id")
    @Expose
    private Integer exceptId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Integer getCurrentCategoryId() {
        return currentCategoryId;
    }

    public void setCurrentCategoryId(Integer currentCategoryId) {
        this.currentCategoryId = currentCategoryId;
    }

    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    public Boolean getPlain() {
        return plain;
    }

    public void setPlain(Boolean plain) {
        this.plain = plain;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getItemIds() {
        return itemIds;
    }

    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }

    public Boolean getGroupByLevel() {
        return groupByLevel;
    }

    public void setGroupByLevel(Boolean groupByLevel) {
        this.groupByLevel = groupByLevel;
    }

    public Boolean getGetImages() {
        return getImages;
    }

    public void setGetImages(Boolean getImages) {
        this.getImages = getImages;
    }

    public String getCategoryDelimiter() {
        return categoryDelimiter;
    }

    public void setCategoryDelimiter(String categoryDelimiter) {
        this.categoryDelimiter = categoryDelimiter;
    }

    public Boolean getGetFrontendUrls() {
        return getFrontendUrls;
    }

    public void setGetFrontendUrls(Boolean getFrontendUrls) {
        this.getFrontendUrls = getFrontendUrls;
    }

    public Object getMaxNestingLevel() {
        return maxNestingLevel;
    }

    public void setMaxNestingLevel(Object maxNestingLevel) {
        this.maxNestingLevel = maxNestingLevel;
    }

    public Boolean getGetCompanyName() {
        return getCompanyName;
    }

    public void setGetCompanyName(Boolean getCompanyName) {
        this.getCompanyName = getCompanyName;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getExceptId() {
        return exceptId;
    }

    public void setExceptId(Integer exceptId) {
        this.exceptId = exceptId;
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
