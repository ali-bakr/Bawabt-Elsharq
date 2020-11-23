package com.aliaboubakr.bawabtelsharq.models.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainPair {

    @SerializedName("pair_id")
    @Expose
    private String pairId;
    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("detailed_id")
    @Expose
    private String detailedId;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("object_id")
    @Expose
    private String objectId;
    @SerializedName("object_type")
    @Expose
    private String objectType;
    @SerializedName("detailed")
    @Expose
    private Detailed detailed;

    public String getPairId() {
        return pairId;
    }

    public void setPairId(String pairId) {
        this.pairId = pairId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDetailedId() {
        return detailedId;
    }

    public void setDetailedId(String detailedId) {
        this.detailedId = detailedId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Detailed getDetailed() {
        return detailed;
    }

    public void setDetailed(Detailed detailed) {
        this.detailed = detailed;
    }


}
