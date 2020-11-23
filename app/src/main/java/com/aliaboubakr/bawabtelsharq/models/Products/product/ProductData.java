package com.aliaboubakr.bawabtelsharq.models.Products.product;

import com.aliaboubakr.bawabtelsharq.models.Products.Detailed;
import com.aliaboubakr.bawabtelsharq.models.Products.MainPair;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class ProductData {


    @SerializedName("min_items_in_box")
    @Expose
    private Integer minItemsInBox;
    @SerializedName("max_items_in_box")
    @Expose
    private Integer maxItemsInBox;
    @SerializedName("box_length")
    @Expose
    private Integer boxLength;
    @SerializedName("box_width")
    @Expose
    private Integer boxWidth;
    @SerializedName("box_height")
    @Expose
    private Integer boxHeight;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("list_price")
    @Expose
    private String listPrice;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("shipping_freight")
    @Expose
    private String shippingFreight;
    @SerializedName("low_avail_limit")
    @Expose
    private String lowAvailLimit;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("updated_timestamp")
    @Expose
    private String updatedTimestamp;
    @SerializedName("usergroup_ids")
    @Expose
    private String usergroupIds;
    @SerializedName("is_edp")
    @Expose
    private String isEdp;
    @SerializedName("edp_shipping")
    @Expose
    private String edpShipping;
    @SerializedName("unlimited_download")
    @Expose
    private String unlimitedDownload;
    @SerializedName("tracking")
    @Expose
    private String tracking;
    @SerializedName("free_shipping")
    @Expose
    private String freeShipping;
    @SerializedName("zero_price_action")
    @Expose
    private String zeroPriceAction;
    @SerializedName("is_pbp")
    @Expose
    private String isPbp;
    @SerializedName("is_op")
    @Expose
    private String isOp;
    @SerializedName("is_oper")
    @Expose
    private String isOper;
    @SerializedName("is_returnable")
    @Expose
    private String isReturnable;
    @SerializedName("return_period")
    @Expose
    private String returnPeriod;
    @SerializedName("avail_since")
    @Expose
    private String availSince;
    @SerializedName("out_of_stock_actions")
    @Expose
    private String outOfStockActions;
    @SerializedName("localization")
    @Expose
    private String localization;
    @SerializedName("min_qty")
    @Expose
    private String minQty;
    @SerializedName("max_qty")
    @Expose
    private String maxQty;
    @SerializedName("qty_step")
    @Expose
    private String qtyStep;
    @SerializedName("list_qty_count")
    @Expose
    private String listQtyCount;
    @SerializedName("tax_ids")
    @Expose
    private List<Object> taxIds = null;
    @SerializedName("age_verification")
    @Expose
    private String ageVerification;
    @SerializedName("age_limit")
    @Expose
    private String ageLimit;
    @SerializedName("options_type")
    @Expose
    private String optionsType;
    @SerializedName("exceptions_type")
    @Expose
    private String exceptionsType;
    @SerializedName("details_layout")
    @Expose
    private String detailsLayout;
    @SerializedName("shipping_params")
    @Expose
    private String shippingParams;
    @SerializedName("facebook_obj_type")
    @Expose
    private String facebookObjType;
    @SerializedName("parent_product_id")
    @Expose
    private String parentProductId;
    @SerializedName("buy_now_url")
    @Expose
    private String buyNowUrl;
    @SerializedName("lang_code")
    @Expose
    private String langCode;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("shortname")
    @Expose
    private String shortname;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("full_description")
    @Expose
    private String fullDescription;
    @SerializedName("meta_keywords")
    @Expose
    private String metaKeywords;
    @SerializedName("meta_description")
    @Expose
    private String metaDescription;
    @SerializedName("search_words")
    @Expose
    private String searchWords;
    @SerializedName("page_title")
    @Expose
    private String pageTitle;
    @SerializedName("age_warning_message")
    @Expose
    private Object ageWarningMessage;
    @SerializedName("promo_text")
    @Expose
    private String promoText;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("category_ids")
    @Expose
    private List<Integer> categoryIds = null;
    @SerializedName("popularity")
    @Expose
    private String popularity;
    @SerializedName("sales_amount")
    @Expose
    private Object salesAmount;
    @SerializedName("point_price")
    @Expose
    private Object pointPrice;
    @SerializedName("discussion_type")
    @Expose
    private String discussionType;
    @SerializedName("base_price")
    @Expose
    private String basePrice;
    @SerializedName("main_category")
    @Expose
    private Integer mainCategory;
    @SerializedName("image_pairs")
    @Expose
    private List<Object> imagePairs = null;
    @SerializedName("main_pair")
    @Expose
    private MainPairProduct mainPair;
    @SerializedName("product_features")
    @Expose
    private List<Object> productFeatures = null;
    @SerializedName("detailed_params")
    @Expose
    private DetailedParams detailedParams;
    @SerializedName("premoderation_reason")
    @Expose
    private String premoderationReason;
    @SerializedName("have_required")
    @Expose
    private String haveRequired;
    @SerializedName("selected_options")
    @Expose
    private List<Object> selectedOptions = null;
    @SerializedName("variation_features")
    @Expose
    private List<Object> variationFeatures = null;
    @SerializedName("has_options")
    @Expose
    private Boolean hasOptions;
    @SerializedName("product_options")
    @Expose
    private List<Object> productOptions = null;
    @SerializedName("discounts")
    @Expose
    private Discounts discounts;
    @SerializedName("qty_content")
    @Expose
    private List<Object> qtyContent = null;

    public Integer getMinItemsInBox() {
        return minItemsInBox;
    }

    public void setMinItemsInBox(Integer minItemsInBox) {
        this.minItemsInBox = minItemsInBox;
    }

    public Integer getMaxItemsInBox() {
        return maxItemsInBox;
    }

    public void setMaxItemsInBox(Integer maxItemsInBox) {
        this.maxItemsInBox = maxItemsInBox;
    }

    public Integer getBoxLength() {
        return boxLength;
    }

    public void setBoxLength(Integer boxLength) {
        this.boxLength = boxLength;
    }

    public Integer getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(Integer boxWidth) {
        this.boxWidth = boxWidth;
    }

    public Integer getBoxHeight() {
        return boxHeight;
    }

    public void setBoxHeight(Integer boxHeight) {
        this.boxHeight = boxHeight;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getShippingFreight() {
        return shippingFreight;
    }

    public void setShippingFreight(String shippingFreight) {
        this.shippingFreight = shippingFreight;
    }

    public String getLowAvailLimit() {
        return lowAvailLimit;
    }

    public void setLowAvailLimit(String lowAvailLimit) {
        this.lowAvailLimit = lowAvailLimit;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(String updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getUsergroupIds() {
        return usergroupIds;
    }

    public void setUsergroupIds(String usergroupIds) {
        this.usergroupIds = usergroupIds;
    }

    public String getIsEdp() {
        return isEdp;
    }

    public void setIsEdp(String isEdp) {
        this.isEdp = isEdp;
    }

    public String getEdpShipping() {
        return edpShipping;
    }

    public void setEdpShipping(String edpShipping) {
        this.edpShipping = edpShipping;
    }

    public String getUnlimitedDownload() {
        return unlimitedDownload;
    }

    public void setUnlimitedDownload(String unlimitedDownload) {
        this.unlimitedDownload = unlimitedDownload;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(String freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getZeroPriceAction() {
        return zeroPriceAction;
    }

    public void setZeroPriceAction(String zeroPriceAction) {
        this.zeroPriceAction = zeroPriceAction;
    }

    public String getIsPbp() {
        return isPbp;
    }

    public void setIsPbp(String isPbp) {
        this.isPbp = isPbp;
    }

    public String getIsOp() {
        return isOp;
    }

    public void setIsOp(String isOp) {
        this.isOp = isOp;
    }

    public String getIsOper() {
        return isOper;
    }

    public void setIsOper(String isOper) {
        this.isOper = isOper;
    }

    public String getIsReturnable() {
        return isReturnable;
    }

    public void setIsReturnable(String isReturnable) {
        this.isReturnable = isReturnable;
    }

    public String getReturnPeriod() {
        return returnPeriod;
    }

    public void setReturnPeriod(String returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public String getAvailSince() {
        return availSince;
    }

    public void setAvailSince(String availSince) {
        this.availSince = availSince;
    }

    public String getOutOfStockActions() {
        return outOfStockActions;
    }

    public void setOutOfStockActions(String outOfStockActions) {
        this.outOfStockActions = outOfStockActions;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getMinQty() {
        return minQty;
    }

    public void setMinQty(String minQty) {
        this.minQty = minQty;
    }

    public String getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(String maxQty) {
        this.maxQty = maxQty;
    }

    public String getQtyStep() {
        return qtyStep;
    }

    public void setQtyStep(String qtyStep) {
        this.qtyStep = qtyStep;
    }

    public String getListQtyCount() {
        return listQtyCount;
    }

    public void setListQtyCount(String listQtyCount) {
        this.listQtyCount = listQtyCount;
    }

    public List<Object> getTaxIds() {
        return taxIds;
    }

    public void setTaxIds(List<Object> taxIds) {
        this.taxIds = taxIds;
    }

    public String getAgeVerification() {
        return ageVerification;
    }

    public void setAgeVerification(String ageVerification) {
        this.ageVerification = ageVerification;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getOptionsType() {
        return optionsType;
    }

    public void setOptionsType(String optionsType) {
        this.optionsType = optionsType;
    }

    public String getExceptionsType() {
        return exceptionsType;
    }

    public void setExceptionsType(String exceptionsType) {
        this.exceptionsType = exceptionsType;
    }

    public String getDetailsLayout() {
        return detailsLayout;
    }

    public void setDetailsLayout(String detailsLayout) {
        this.detailsLayout = detailsLayout;
    }

    public String getShippingParams() {
        return shippingParams;
    }

    public void setShippingParams(String shippingParams) {
        this.shippingParams = shippingParams;
    }

    public String getFacebookObjType() {
        return facebookObjType;
    }

    public void setFacebookObjType(String facebookObjType) {
        this.facebookObjType = facebookObjType;
    }

    public String getParentProductId() {
        return parentProductId;
    }

    public void setParentProductId(String parentProductId) {
        this.parentProductId = parentProductId;
    }

    public String getBuyNowUrl() {
        return buyNowUrl;
    }

    public void setBuyNowUrl(String buyNowUrl) {
        this.buyNowUrl = buyNowUrl;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getSearchWords() {
        return searchWords;
    }

    public void setSearchWords(String searchWords) {
        this.searchWords = searchWords;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Object getAgeWarningMessage() {
        return ageWarningMessage;
    }

    public void setAgeWarningMessage(Object ageWarningMessage) {
        this.ageWarningMessage = ageWarningMessage;
    }

    public String getPromoText() {
        return promoText;
    }

    public void setPromoText(String promoText) {
        this.promoText = promoText;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public Object getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Object salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Object getPointPrice() {
        return pointPrice;
    }

    public void setPointPrice(Object pointPrice) {
        this.pointPrice = pointPrice;
    }

    public String getDiscussionType() {
        return discussionType;
    }

    public void setDiscussionType(String discussionType) {
        this.discussionType = discussionType;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(Integer mainCategory) {
        this.mainCategory = mainCategory;
    }

    public List<Object> getImagePairs() {
        return imagePairs;
    }

    public void setImagePairs(List<Object> imagePairs) {
        this.imagePairs = imagePairs;
    }

    public MainPairProduct getProductMainPair() {
        return mainPair;
    }

    public void setMainPair(MainPairProduct mainPair) {
        this.mainPair = mainPair;
    }

    public List<Object> getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(List<Object> productFeatures) {
        this.productFeatures = productFeatures;
    }

    public DetailedParams getDetailedParams() {
        return detailedParams;
    }

    public void setDetailedParams(DetailedParams detailedParams) {
        this.detailedParams = detailedParams;
    }

    public String getPremoderationReason() {
        return premoderationReason;
    }

    public void setPremoderationReason(String premoderationReason) {
        this.premoderationReason = premoderationReason;
    }

    public String getHaveRequired() {
        return haveRequired;
    }

    public void setHaveRequired(String haveRequired) {
        this.haveRequired = haveRequired;
    }

    public List<Object> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<Object> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public List<Object> getVariationFeatures() {
        return variationFeatures;
    }

    public void setVariationFeatures(List<Object> variationFeatures) {
        this.variationFeatures = variationFeatures;
    }

    public Boolean getHasOptions() {
        return hasOptions;
    }

    public void setHasOptions(Boolean hasOptions) {
        this.hasOptions = hasOptions;
    }

    public List<Object> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<Object> productOptions) {
        this.productOptions = productOptions;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Discounts discounts) {
        this.discounts = discounts;
    }

    public List<Object> getQtyContent() {
        return qtyContent;
    }

    public void setQtyContent(List<Object> qtyContent) {
        this.qtyContent = qtyContent;
    }
}

