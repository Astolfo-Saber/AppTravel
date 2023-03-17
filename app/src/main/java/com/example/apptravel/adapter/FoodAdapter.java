package com.example.apptravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apptravel.R;
import com.example.apptravel.adapter.viewholder.ItemViewHolder;
import com.example.apptravel.models.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<Food> ListFood;

    public FoodAdapter(Context context, List<Food> listFood) {
        this.context = context;
        ListFood = listFood;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Food food =ListFood.get(position);
        if (food == null)
            return;
        Glide.with(context).load(food.getImage()).into(holder.getImgPlace());
        holder.getTxtNamePlace().setText(food.getFoodName());
        holder.getTxtPlaceAddress().setText(food.getAddress());
        holder.getItem().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (ListFood!=null)
            return ListFood.size();
        return 0;
    }

}
