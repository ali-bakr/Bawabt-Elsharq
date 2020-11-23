package com.aliaboubakr.bawabtelsharq.models.Products.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class DetailedParams {


    @SerializedName("info_type")
    @Expose
    private String infoType;
    @SerializedName("is_preview")
    @Expose
    private Boolean isPreview;

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public Boolean getIsPreview() {
        return isPreview;
    }

    public void setIsPreview(Boolean isPreview) {
        this.isPreview = isPreview;
    }
}
