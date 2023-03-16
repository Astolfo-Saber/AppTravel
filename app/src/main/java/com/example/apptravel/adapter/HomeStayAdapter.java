package com.example.apptravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptravel.R;
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
        holder.imgHomeStay.setImageResource(context.getResources().getIdentifier(homeStay.getImage(),"drawable",context.getPackageName()));
        holder.txtHomeStayName.setText(homeStay.getHomeStayName());
        holder.txtHomeStayAddress.setText(homeStay.getAddress());
        holder.HomeStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (ListHomeStay!=null)
            return ListHomeStay.size();
        return 0;
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
