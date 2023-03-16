package com.example.apptravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.apptravel.Database;
import com.example.apptravel.R;
import com.example.apptravel.adapter.PlaceAllAdapter;
import com.example.apptravel.models.Place;

import java.util.List;

public class AllPlaceActivity extends AppCompatActivity {
    private RecyclerView recycleviewPlace;
    private Database db;
    private List<Place> ListPlace;
    private PlaceAllAdapter placeAllAdapter;
    private ImageView imgHome;
    private ImageView imgFood;
    private ImageView imgHomeStay;
    private ImageView imgMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_all);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        recycleviewPlace = findViewById(R.id.recycleviewallplace);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        db = new Database(this,"AppTravel",null,1);
        ListPlace = db.getAllPlace();
        recycleviewPlace.setLayoutManager(linearLayoutManager);
        placeAllAdapter = new PlaceAllAdapter(this,ListPlace);
        recycleviewPlace.setAdapter(placeAllAdapter);
        imgHome = findViewById(R.id.Home);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllPlaceActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgFood = findViewById(R.id.Food);
        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllPlaceActivity.this,AllFoodActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgHomeStay = findViewById(R.id.HomeStay);
        imgHomeStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllPlaceActivity.this,AllHomeStayActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}