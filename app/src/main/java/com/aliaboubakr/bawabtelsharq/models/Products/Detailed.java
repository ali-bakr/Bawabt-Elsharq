package com.aliaboubakr.bawabtelsharq.models.Products;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detailed {
    @SerializedName("object_id")
    @Expose
    private String objectId;
    @SerializedName("object_type")
    @Expose
    private String objectType;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("image_x")
    @Expose
    private String imageX;
    @SerializedName("image_y")
    @Expose
    private String imageY;
    @SerializedName("http_image_path")
    @Expose
    private String httpImagePath;
    @SerializedName("https_image_path")
    @Expose
    private String httpsImagePath;
    @SerializedName("absolute_path")
    @Expose
    private String absolutePath;
    @SerializedName("relative_path")
    @Expose
    private String relativePath;
    @SerializedName("is_high_res")
    @Expose
    private Boolean isHighRes;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getImageX() {
        return imageX;
    }

    public void setImageX(String imageX) {
        this.imageX = imageX;
    }

    public String getImageY() {
        return imageY;
    }

    public void setImageY(String imageY) {
        this.imageY = imageY;
    }

    public String getHttpImagePath() {
        return httpImagePath;
    }

    public void setHttpImagePath(String httpImagePath) {
        this.httpImagePath = httpImagePath;
    }

    public String getHttpsImagePath() {
        return httpsImagePath;
    }

    public void setHttpsImagePath(String httpsImagePath) {
        this.httpsImagePath = httpsImagePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public Boolean getIsHighRes() {
        return isHighRes;
    }

    public void setIsHighRes(Boolean isHighRes) {
        this.isHighRes = isHighRes;
    }
}
