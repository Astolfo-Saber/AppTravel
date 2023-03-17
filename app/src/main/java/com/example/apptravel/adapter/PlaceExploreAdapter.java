package com.example.apptravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apptravel.R;
import com.example.apptravel.adapter.viewholder.PlaceExploreViewHolder;
import com.example.apptravel.models.Place;
import java.util.List;

public class PlaceExploreAdapter extends RecyclerView.Adapter<PlaceExploreViewHolder> {
    private Context context;
    private List<Place> listPlace;

    public PlaceExploreAdapter(Context context, List<Place> listPlace) {
        this.context = context;
        this.listPlace = listPlace;
    }

    @NonNull
    @Override
    public PlaceExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_explore,parent,false);
        return new PlaceExploreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceExploreViewHolder holder, int position) {
        Place place =listPlace.get(position);
        if (place == null)
            return;
        //holder.imgPlace.setImageResource(context.getResources().getIdentifier(place.getAvatar(),"drawable",context.getPackageName()));
        Glide.with(context).load(place.getImage()).into(holder.getImgPlace());
        holder.getTxtNamePlace().setText(place.getPlaceName());
        holder.getTxtAddress().setText(place.getAddress());

        holder.getPlace().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (listPlace!=null)
            return listPlace.size();
        return 0;
    }
}
