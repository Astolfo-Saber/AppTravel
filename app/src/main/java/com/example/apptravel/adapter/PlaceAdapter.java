package com.example.apptravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptravel.R;
import com.example.apptravel.models.Place;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
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
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_must_go,parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Place place =ListPlace.get(position);
        if (place == null)
            return;
        holder.imgPlace.setImageResource(context.getResources().getIdentifier(place.getAvatar(),"drawable",context.getPackageName()));
        holder.txtNamePlace.setText(place.getPlaceName());
        holder.txtAddress.setText(place.getAddress());
        holder.Place.setOnClickListener(new View.OnClickListener() {
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

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPlace;
        private TextView txtNamePlace;
        private TextView txtAddress;
        private CardView Place;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlace = itemView.findViewById(R.id.imgPlace);
            txtNamePlace = itemView.findViewById(R.id.txtPlaceName);
            txtAddress = itemView.findViewById(R.id.txtCity);
            Place = itemView.findViewById(R.id.Placemustgo);
        }
    }
}
