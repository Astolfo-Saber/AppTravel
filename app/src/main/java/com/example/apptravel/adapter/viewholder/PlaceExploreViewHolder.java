package com.example.apptravel.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptravel.R;

public class PlaceExploreViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgPlace;
    private TextView txtNamePlace;
    private TextView txtAddress;
    private CardView Place;
    public PlaceExploreViewHolder(@NonNull View itemView) {
        super(itemView);
        imgPlace = itemView.findViewById(R.id.imgPlaceExplore);
        txtNamePlace = itemView.findViewById(R.id.txtPlaceNameExplore);
        txtAddress = itemView.findViewById(R.id.txtCityExplore);
        Place = itemView.findViewById(R.id.PlaceExplorer);
    }

    public ImageView getImgPlace() {
        return imgPlace;
    }

    public void setImgPlace(ImageView imgPlace) {
        this.imgPlace = imgPlace;
    }

    public TextView getTxtNamePlace() {
        return txtNamePlace;
    }

    public void setTxtNamePlace(TextView txtNamePlace) {
        this.txtNamePlace = txtNamePlace;
    }

    public TextView getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(TextView txtAddress) {
        this.txtAddress = txtAddress;
    }

    public CardView getPlace() {
        return Place;
    }

    public void setPlace(CardView place) {
        Place = place;
    }
}
