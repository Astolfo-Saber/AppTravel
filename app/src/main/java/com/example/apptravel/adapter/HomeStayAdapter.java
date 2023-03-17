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
import com.example.apptravel.models.HomeStay;

import java.util.List;

public class HomeStayAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<HomeStay> listHomeStay;

    public HomeStayAdapter(Context context, List<HomeStay> listHomeStay) {
        this.context = context;
        this.listHomeStay = listHomeStay;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        HomeStay homeStay = listHomeStay.get(position);
        if (homeStay == null)
            return;
        Glide.with(context).load(homeStay.getImage()).into(holder.getImgPlace());
        holder.getTxtPlaceAddress().setText(homeStay.getHomeStayName());
        holder.getTxtNamePlace().setText(homeStay.getAddress());
        holder.getItem().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (listHomeStay !=null)
            return listHomeStay.size();
        return 0;
    }


}
