package com.example.apptravel.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptravel.R;
import com.example.apptravel.activity.MainActivity;
import com.example.apptravel.models.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private Context context;
    private List<Food> ListFood;

    public FoodAdapter(Context context, List<Food> listFood) {
        this.context = context;
        ListFood = listFood;
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all,parent,false);
        return new FoodAdapter.FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food =ListFood.get(position);
        if (food == null)
            return;
        holder.imageFood.setImageResource(context.getResources().getIdentifier(food.getImage(),"drawable",context.getPackageName()));
        holder.txtFoodName.setText(food.getFoodName());
        holder.txtFoodAddress.setText(food.getAddress());
        holder.Food.setOnClickListener(new View.OnClickListener() {
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

    public void filterFood (List<Food> filterFood) {
        ListFood = filterFood;
        notifyDataSetChanged();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageFood;
        private TextView txtFoodName;
        private TextView txtFoodAddress;
        private CardView Food;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFood = itemView.findViewById(R.id.imgItemAll);
            txtFoodName = itemView.findViewById(R.id.txtNameAll);
            txtFoodAddress = itemView.findViewById(R.id.txtAddressAll);
            Food = itemView.findViewById(R.id.itemall);
        }
    }
}
