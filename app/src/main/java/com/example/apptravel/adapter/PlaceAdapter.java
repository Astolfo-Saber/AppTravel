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
import com.example.apptravel.models.Place;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<Place> ListPlace;

    public PlaceAdapter(Context context, List<Place> listPlace) {
        this.context = context;
        ListPlace = listPlace;
    }
    public void setData (List<Place> lstTourism) {
        this.ListPlace = lstTourism;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_must_go,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Place place =ListPlace.get(position);
        if (place == null)
            return;
        Glide.with(context).load(place.getImage()).into(holder.getImgPlace());
        holder.getTxtNamePlace().setText(place.getPlaceName());
        holder.getTxtPlaceAddress().setText(place.getAddress());
        holder.getItem().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (ListPlace!=null)
            return ListPlace.size();
        return 0;
    }

}
