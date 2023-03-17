package com.example.apptravel.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apptravel.R;
import com.example.apptravel.activity.DetailsActivity;
import com.example.apptravel.models.Food;
import com.example.apptravel.models.HomeStay;
import com.example.apptravel.models.Place;

import java.util.List;

public class HomeStayAdapter extends RecyclerView.Adapter<HomeStayAdapter.HomeStayViewHolder> {
    private Context context;
    private List<HomeStay> ListHomeStay;

    public HomeStayAdapter(Context context, List<HomeStay> listHomeStay) {
        this.context = context;
        ListHomeStay = listHomeStay;
    }
    @NonNull
    @Override
    public HomeStayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all,parent,false);
        return new HomeStayAdapter.HomeStayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeStayViewHolder holder, int position) {
        HomeStay homeStay =ListHomeStay.get(position);
        if (homeStay == null)
            return;
        //holder.imgHomeStay.setImageResource(context.getResources().getIdentifier(homeStay.getImage(),"drawable",context.getPackageName()));
        Glide.with(context).load(homeStay.getImage()).into(holder.imgHomeStay);
        holder.txtHomeStayName.setText(homeStay.getHomeStayName());
        holder.txtHomeStayAddress.setText(homeStay.getAddress());
        holder.HomeStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Id", "HOMESTAY");
                bundle.putString("Name",homeStay.getHomeStayName());
                bundle.putString("Address",homeStay.getAddress());
                bundle.putString("Detail",homeStay.getDetail());
                bundle.putString("ImageUrl",homeStay.getImage());
                bundle.putString("Price",homeStay.getPrice());
                bundle.putString("Contact",homeStay.getContact());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (ListHomeStay!=null)
            return ListHomeStay.size();
        return 0;
    }

    public void filterHomeStay (List<HomeStay> filterHomeStay) {
        ListHomeStay = filterHomeStay;
        notifyDataSetChanged();
    }

    public class HomeStayViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgHomeStay;
        private TextView txtHomeStayName;
        private TextView txtHomeStayAddress;
        private CardView HomeStay;
        public HomeStayViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHomeStay = itemView.findViewById(R.id.imgItemAll);
            txtHomeStayName = itemView.findViewById(R.id.txtNameAll);
            txtHomeStayAddress = itemView.findViewById(R.id.txtAddressAll);
            HomeStay = itemView.findViewById(R.id.itemall);
        }
    }
}
