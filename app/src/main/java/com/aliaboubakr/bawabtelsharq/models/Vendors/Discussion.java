package com.aliaboubakr.bawabtelsharq.models.Vendors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Discussion {

    @SerializedName("posts_count")
    @Expose
    private Integer postsCount;

    public Integer getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(Integer postsCount) {
        this.postsCount = postsCount;
    }

}
