package com.example.apptravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.apptravel.Database;
import com.example.apptravel.R;
import com.example.apptravel.adapter.*;
import com.example.apptravel.models.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Database db;
    private PlaceAdapter placeAdapter;
    private List<Place> ListPlace;
    private RecyclerView recycleviewexplore;
    private PlaceExploreAdapter placeExploreAdapter;
    private ImageView imgPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleviewexplore = findViewById(R.id.recycleviewexpore);
        recyclerView = findViewById(R.id.recycleviewmustgo);
        db = new Database(this,"AppTravel",null,1);
        ListPlace = db.getAllPlace();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManagerPlaceExplore = new LinearLayoutManager(this,recycleviewexplore.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recycleviewexplore.setLayoutManager(linearLayoutManagerPlaceExplore);
        placeAdapter = new PlaceAdapter(this,ListPlace);
        placeExploreAdapter = new PlaceExploreAdapter(this,ListPlace);
        recyclerView.setAdapter(placeAdapter);
        recycleviewexplore.setAdapter(placeExploreAdapter);
    }
}