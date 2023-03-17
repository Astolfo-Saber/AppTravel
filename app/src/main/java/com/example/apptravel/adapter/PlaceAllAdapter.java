package com.example.apptravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apptravel.R;
import com.example.apptravel.activity.DetailsActivity;
import com.example.apptravel.models.Place;

import java.util.List;

public class PlaceAllAdapter extends RecyclerView.Adapter<PlaceAllAdapter.PlaceAllViewHolder> {
    private Context context;
    private List<Place> ListPlace;

    public PlaceAllAdapter(Context context, List<Place> listPlace) {
        this.context = context;
        ListPlace = listPlace;
    }

    @NonNull
    @Override
    public PlaceAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all,parent,false);
        return new PlaceAllAdapter.PlaceAllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAllViewHolder holder, int position) {
        Place place =ListPlace.get(position);
        if (place == null)
            return;
        //holder.imgPlace.setImageResource(context.getResources().getIdentifier(place.getAvatar(),"drawable",context.getPackageName()));
        Glide.with(context).load(place.getImage()).into(holder.imgPlace);
        holder.txtNamePlace.setText(place.getPlaceName());
        holder.txtPlaceAddress.setText(place.getAddress());
        holder.Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Id", "PLACE");
                bundle.putString("Name",place.getPlaceName());
                bundle.putString("Address",place.getAddress());
                bundle.putString("Detail",place.getDetail());
                bundle.putString("ImageUrl",place.getImage());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (ListPlace!=null)
            return ListPlace.size();
        return 0;
    }

    public void filterPlace (List<Place> filterPlace) {
        ListPlace = filterPlace;
        notifyDataSetChanged();
    }

    public class PlaceAllViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPlace;
        private TextView txtNamePlace;
        private TextView txtPlaceAddress;
        private CardView Place;
        public PlaceAllViewHolder(@NonNull View itemView) {
            super(itemView);
            Place = itemView.findViewById(R.id.itemall);
            imgPlace = itemView.findViewById(R.id.imgItemAll);
            txtNamePlace = itemView.findViewById(R.id.txtNameAll);
            txtPlaceAddress = itemView.findViewById(R.id.txtAddressAll);
        }
    }
}
