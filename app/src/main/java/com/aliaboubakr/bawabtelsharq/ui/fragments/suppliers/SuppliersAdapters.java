package com.aliaboubakr.bawabtelsharq.ui.fragments.suppliers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.models.Vendors.Vendor;
import com.aliaboubakr.bawabtelsharq.models.Vendors.VendorsData;
import com.aliaboubakr.bawabtelsharq.ui.fragments.bottom_navigation.nav_home.adapters.AllProductsAdapter;

import java.util.List;

public  class SuppliersAdapters extends RecyclerView.Adapter <SuppliersAdapters.SuppliersVH>{
    private List<Vendor> vendorsDataList;
    Activity activity;
    public AllSuppliersClickListener allSuppliersClickListener;

    public SuppliersAdapters( Activity activity,List<Vendor> vendorsDataList) {
        this.vendorsDataList = vendorsDataList;
        this.activity = activity;
    }

    public interface AllSuppliersClickListener{
        void setOnClick(int position);
    }

    public void setOnClickSuppliers(AllSuppliersClickListener allSuppliersClickListener) {

        this.allSuppliersClickListener = allSuppliersClickListener;
    }

    @NonNull
    @Override
    public SuppliersVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.rv_item_suppliers,parent,false);
        return new SuppliersVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SuppliersVH holder, int position) {

        Vendor vendor=vendorsDataList.get(position);
       // holder.mSupplierImage
        holder.mSupplierName.setText(vendor.getCompany());

    }

    @Override
    public int getItemCount() {
        return vendorsDataList.size();
    }

    public class SuppliersVH extends RecyclerView.ViewHolder {
        TextView mSupplierName;
        ImageView mSupplierImage;
        public SuppliersVH(@NonNull View itemView) {
            super(itemView);
        mSupplierName=itemView.findViewById(R.id.tv_item_supplier_name);
        mSupplierImage=itemView.findViewById(R.id.iv_item_suppliers_img);
        actionClick(itemView);
        }
        public void actionClick(View view){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allSuppliersClickListener.setOnClick(getAdapterPosition());
                }
            });
        }
    }

}
