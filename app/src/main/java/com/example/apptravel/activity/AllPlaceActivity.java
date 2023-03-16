package com.example.apptravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.apptravel.database.Database;
import com.example.apptravel.R;
import com.example.apptravel.adapter.PlaceAllAdapter;
import com.example.apptravel.models.Place;

import java.util.ArrayList;
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
    private EditText etSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_all);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        init();
        addData();
        addEvent();
    }

    private void init(){
        recycleviewPlace = findViewById(R.id.recycleviewallplace);
        imgHome = findViewById(R.id.Home);
        imgFood = findViewById(R.id.Food);
        imgHomeStay = findViewById(R.id.HomeStay);
        imgMenu = findViewById(R.id.Menu);
        etSearch = findViewById(R.id.txtSearchAllPlace);
    }

    private void addData(){
        db = new Database(this,"AppTravel",null,1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        ListPlace = db.getAllPlace();
        placeAllAdapter = new PlaceAllAdapter(this,ListPlace);
        recycleviewPlace.setLayoutManager(linearLayoutManager);
        recycleviewPlace.setAdapter(placeAllAdapter);
    }

    private void addEvent(){
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllPlaceActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllPlaceActivity.this,AllFoodActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imgHomeStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllPlaceActivity.this,AllHomeStayActivity.class);
                startActivity(intent);
                finish();
            }
        });
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
    public void filter (String search) {
        List<Place> PlaceFilter = new ArrayList<>();
        for (Place place : ListPlace) {
            if ((place.getPlaceName().toLowerCase().contains(search.toLowerCase()))) {
                PlaceFilter.add(place);
            }
        }
        placeAllAdapter.filterPlace(PlaceFilter);
    }
}