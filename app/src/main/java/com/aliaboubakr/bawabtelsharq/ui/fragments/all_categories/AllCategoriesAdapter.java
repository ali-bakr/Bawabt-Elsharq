package com.aliaboubakr.bawabtelsharq.ui.fragments.all_categories;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aliaboubakr.bawabtelsharq.R;
import com.aliaboubakr.bawabtelsharq.models.Categories.Category;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class AllCategoriesAdapter extends RecyclerView.Adapter<AllCategoriesAdapter.AllCategoriesVH> {

    private Activity activity;
    private List<Category> allCategoriesModelList;
    public AllCategoriesClickListener allCategoriesClickListener;

    public AllCategoriesAdapter(Activity activity, List<Category> allCategoriesModelList) {
        this.activity = activity;
        this.allCategoriesModelList = allCategoriesModelList;
    }


    public interface AllCategoriesClickListener {

        void onClick(int position);
    }

    public void AllCategoriesAdapter(AllCategoriesClickListener allCategoriesClickListener) {
        this.allCategoriesClickListener = allCategoriesClickListener;
    }





    @NonNull
    @Override
    public AllCategoriesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(activity).inflate(R.layout.rv_item_categories_v2,parent,false);
Log.e("onCreateViewHolder","done");
        return new AllCategoriesVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoriesVH holder, int position) {

        fillData(holder,position);

    }

    private void fillData(@NonNull AllCategoriesVH holder, int position) {

        Category categoryList= allCategoriesModelList.get(position);
        holder.categoryProductCount.setText(categoryList.getProductCount());
        holder.categoryName.setText(categoryList.getCategory());
       holder.categoryChar.setText(categoryList.getCategory());
       // Log.e("try",categoryList.getCategory());
        holder.categoryName.setBackground(null);
        //set the categories image when it's available
    }

    @Override
    public int getItemCount() {
        //return 0;
        return allCategoriesModelList.size();
    }



    public class AllCategoriesVH extends RecyclerView.ViewHolder{


        TextView categoryName,categoryChar,categoryProductCount;
        CircleImageView categoryImage;

        public AllCategoriesVH(@NonNull View itemView) {
            super(itemView);

            categoryName=itemView.findViewById(R.id.tv_item_categories);
            categoryImage=itemView.findViewById(R.id.iv_item_categories);
            categoryChar=itemView.findViewById(R.id.tv_item_categories_in_circle);
            categoryProductCount=itemView.findViewById(R.id.tv_item_product_count);
            itemOnClick(itemView);
        }

        public void itemOnClick(View itemView) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allCategoriesClickListener.onClick(getAdapterPosition());
                }
            });
        }

    }
}
