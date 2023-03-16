package com.example.apptravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.apptravel.database.Database;
import com.example.apptravel.R;
import com.example.apptravel.adapter.*;
import com.example.apptravel.models.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Database db;
    private PlaceAdapter placeAdapter;
    private List<Place> ListPlace;
    private RecyclerView recycleviewPlacemustgo;
    private RecyclerView recycleviewPlaceexplore;
    private PlaceExploreAdapter placeExploreAdapter;
    private ImageView imgPlace;
    private ImageView imgFood;
    private ImageView imgHomeStay;
    private ImageView imgMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addData();
        addEvent();
    }

    private void init(){
        recycleviewPlaceexplore = findViewById(R.id.recycleviewexpore);
        recycleviewPlacemustgo = findViewById(R.id.recycleviewmustgo);
        imgPlace = findViewById(R.id.Place);
        imgFood = findViewById(R.id.Food);
        imgHomeStay = findViewById(R.id.HomeStay);
        imgMenu = findViewById(R.id.Menu);
    }

    private void addData(){
        db = new Database(this,"AppTravel",null,1);
        ListPlace = db.getAllPlace();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManagerPlaceExplore = new LinearLayoutManager(this, recycleviewPlaceexplore.HORIZONTAL,false);
        placeAdapter = new PlaceAdapter(this,ListPlace);
        placeExploreAdapter = new PlaceExploreAdapter(this,ListPlace);
        recycleviewPlacemustgo.setLayoutManager(linearLayoutManager);
        recycleviewPlaceexplore.setLayoutManager(linearLayoutManagerPlaceExplore);
        recycleviewPlacemustgo.setAdapter(placeAdapter);
        recycleviewPlaceexplore.setAdapter(placeExploreAdapter);
    }

    private void addEvent(){
        imgPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllPlaceActivity.class);
                startActivity(intent);
            }
        });

        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllFoodActivity.class);
                startActivity(intent);
            }
        });

        imgHomeStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllHomeStayActivity.class);
                startActivity(intent);
            }
        });
    }
}