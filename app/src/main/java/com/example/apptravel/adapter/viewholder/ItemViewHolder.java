package com.example.apptravel.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptravel.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgPlace;
    private TextView txtNamePlace;
    private TextView txtPlaceAddress;
    private CardView item;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.itemall);
        imgPlace = itemView.findViewById(R.id.imgItemAll);
        txtNamePlace = itemView.findViewById(R.id.txtNameAll);
        txtPlaceAddress = itemView.findViewById(R.id.txtAddressAll);
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

    public TextView getTxtPlaceAddress() {
        return txtPlaceAddress;
    }

    public void setTxtPlaceAddress(TextView txtPlaceAddress) {
        this.txtPlaceAddress = txtPlaceAddress;
    }

    public CardView getItem() {
        return item;
    }

    public void setItem(CardView item) {
        this.item = item;
    }
}
