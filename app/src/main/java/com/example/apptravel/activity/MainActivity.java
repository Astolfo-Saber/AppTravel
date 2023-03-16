package com.example.apptravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.apptravel.Database;
import com.example.apptravel.R;
import com.example.apptravel.adapter.*;
import com.example.apptravel.models.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleviewPlacemustgo;
    private Database db;
    private PlaceAdapter placeAdapter;
    private List<Place> ListPlace;
    private RecyclerView recycleviewPlaceexplore;
    private PlaceExploreAdapter placeExploreAdapter;
    private ImageView imgPlace;
    private ImageView imgFood;
    private ImageView imgHomeStay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleviewPlaceexplore = findViewById(R.id.recycleviewexpore);
        recycleviewPlacemustgo = findViewById(R.id.recycleviewmustgo);
        db = new Database(this,"AppTravel",null,1);
        ListPlace = db.getAllPlace();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManagerPlaceExplore = new LinearLayoutManager(this, recycleviewPlaceexplore.HORIZONTAL,false);
        recycleviewPlacemustgo.setLayoutManager(linearLayoutManager);
        recycleviewPlaceexplore.setLayoutManager(linearLayoutManagerPlaceExplore);
        placeAdapter = new PlaceAdapter(this,ListPlace);
        placeExploreAdapter = new PlaceExploreAdapter(this,ListPlace);
        recycleviewPlacemustgo.setAdapter(placeAdapter);
        recycleviewPlaceexplore.setAdapter(placeExploreAdapter);
        imgPlace = findViewById(R.id.Place);
        imgPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllPlaceActivity.class);
                startActivity(intent);
            }
        });
        imgFood = findViewById(R.id.Food);
        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllFoodActivity.class);
                startActivity(intent);
            }
        });
        imgHomeStay = findViewById(R.id.HomeStay);
        imgHomeStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllHomeStayActivity.class);
                startActivity(intent);
            }
        });
    }
}