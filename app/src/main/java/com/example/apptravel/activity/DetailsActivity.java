package com.example.apptravel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apptravel.R;

public class DetailsActivity extends AppCompatActivity {
    private ImageView imgDetail;
    private TextView txtDetailName;
    private TextView txtDetailAddress;
    private TextView txtDetailPrice;
    private TextView txtDetailDescription;
    private Button btnContact;
    private ImageView imgRoute;
    private TextView txtPriceTitle;
    private String contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();
        getData();
        addEvent();
    }
    private void init() {
        imgDetail = findViewById(R.id.imgDetail);
        txtDetailName = findViewById(R.id.tvName);
        txtDetailAddress = findViewById(R.id.tvAddress);
        txtDetailPrice = findViewById(R.id.tvPrice);
        txtDetailDescription = findViewById(R.id.tvDescription);
        btnContact = findViewById(R.id.btnContact);
        imgRoute = findViewById(R.id.imgRoute);
        txtPriceTitle = findViewById(R.id.tvPriceTitle);
    }
    private void getData () {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle.getString("Id").equals("PLACE")) {
            Glide.with(this).load(bundle.getString("ImageUrl")).into(imgDetail);
            txtDetailName.setText(bundle.getString("Name"));
            txtDetailAddress.setText(bundle.getString("Address"));
            txtDetailDescription.setText(bundle.getString("Detail"));
            btnContact.setVisibility(View.INVISIBLE);
            txtDetailPrice.setVisibility(View.INVISIBLE);
            txtPriceTitle.setVisibility(View.INVISIBLE);
        }
        else if (bundle.getString("Id").equals("FOOD")) {
            Glide.with(this).load(bundle.getString("ImageUrl")).into(imgDetail);
            txtDetailName.setText(bundle.getString("Name"));
            txtDetailAddress.setText(bundle.getString("Address"));
            txtDetailDescription.setText(bundle.getString("Detail"));
            txtDetailPrice.setText(bundle.getString("Price"));
            btnContact.setVisibility(View.INVISIBLE);
        }
        else if (bundle.getString("Id").equals("HOMESTAY")) {
            Glide.with(this).load(bundle.getString("ImageUrl")).into(imgDetail);
            txtDetailName.setText(bundle.getString("Name"));
            txtDetailAddress.setText(bundle.getString("Address"));
            txtDetailDescription.setText(bundle.getString("Detail"));
            txtDetailPrice.setText(bundle.getString("Price"));
            contact = bundle.getString("Contact");
        }
    }
    private void addEvent () {
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact));
                startActivity(i);
            }
        });
        imgRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Name",txtDetailName.getText().toString());
                bundle.putString("Address",txtDetailAddress.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}