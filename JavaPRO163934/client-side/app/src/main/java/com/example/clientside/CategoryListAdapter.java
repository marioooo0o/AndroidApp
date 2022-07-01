package com.example.clientside;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {
    public static final String CATEGORY_KEY = "com.example.clientside.CATEGORY_KEY";
    private final android.view.LayoutInflater layoutInflater;
    private List<Category> categoryList;

    public CategoryListAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        this.categoryList = null;
    }

    public  void setCategoryList(List<Category> categoryList){
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = layoutInflater.inflate(R.layout.category_row, parent, false);
        return new CategoryViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.categoryTitle.setText(category.getTitle());
        holder.id = category.getId();

    }

    @Override
    public int getItemCount() {
        if (categoryList != null)
            return categoryList.size();
        return 0;
    }


    public  class CategoryViewHolder extends  RecyclerView.ViewHolder{
        Button categoryTitle;
        Long id;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.btn_category);
            categoryTitle.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), ChooseTool.class);
                intent.putExtra(CATEGORY_KEY, id);
                v.getContext().startActivity(intent);
             });
        }
    }
}
