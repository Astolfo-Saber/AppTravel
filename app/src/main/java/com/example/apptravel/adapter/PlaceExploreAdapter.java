package com.example.apptravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptravel.R;
import com.example.apptravel.models.Place;

import java.util.List;

public class PlaceExploreAdapter extends RecyclerView.Adapter<PlaceExploreAdapter.PlaceExploreViewHolder> {
    private Context context;
    private List<Place> ListPlace;

    public PlaceExploreAdapter(Context context, List<Place> listPlace) {
        this.context = context;
        ListPlace = listPlace;
    }
    public void setData (List<Place> lstTourism) {
        this.ListPlace = lstTourism;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PlaceExploreAdapter.PlaceExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_explore,parent,false);
        return new PlaceExploreAdapter.PlaceExploreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceExploreAdapter.PlaceExploreViewHolder holder, int position) {
        Place place =ListPlace.get(position);
        if (place == null)
            return;
        holder.imgPlace.setImageResource(context.getResources().getIdentifier(place.getAvatar(),"drawable",context.getPackageName()));
        holder.txtNamePlace.setText(place.getPlaceName());
        holder.txtCity.setText(place.getAddress());
    }

    @Override
    public int getItemCount() {
        if (ListPlace!=null)
            return ListPlace.size();
        return 0;
    }
    public class PlaceExploreViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPlace;
        private TextView txtNamePlace;
        private TextView txtCity;
        public PlaceExploreViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlace = itemView.findViewById(R.id.imgPlaceExplore);
            txtNamePlace = itemView.findViewById(R.id.txtPlaceNameExplore);
            txtCity = itemView.findViewById(R.id.txtCityExplore);
        }
    }
}
