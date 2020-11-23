package com.aliaboubakr.bawabtelsharq.models.Vendors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vendor {
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("lang_code")
    @Expose
    private String langCode;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("plan")
    @Expose
    private Object plan;
    @SerializedName("average_rating")
    @Expose
    private Object averageRating;
    @SerializedName("company_thread_ids")
    @Expose
    private String companyThreadIds;
    @SerializedName("discussion")
    @Expose
    private Discussion discussion;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getPlan() {
        return plan;
    }

    public void setPlan(Object plan) {
        this.plan = plan;
    }

    public Object getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Object averageRating) {
        this.averageRating = averageRating;
    }

    public String getCompanyThreadIds() {
        return companyThreadIds;
    }

    public void setCompanyThreadIds(String companyThreadIds) {
        this.companyThreadIds = companyThreadIds;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

}
