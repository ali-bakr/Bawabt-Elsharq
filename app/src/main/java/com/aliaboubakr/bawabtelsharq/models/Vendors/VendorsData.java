package com.aliaboubakr.bawabtelsharq.models.Vendors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VendorsData {
    @SerializedName("vendors")
    @Expose
    private List<Vendor> vendors = null;
    @SerializedName("params")
    @Expose
    private Params params;

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
