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
import com.example.apptravel.adapter.HomeStayAdapter;
import com.example.apptravel.models.HomeStay;

import java.util.List;

public class AllHomeStayActivity extends AppCompatActivity {
    private RecyclerView recycleviewHomeStay;
    private Database db;
    private List<HomeStay> ListHomeStay;
    private HomeStayAdapter homeStayAdapter;
    private ImageView imgHome;
    private ImageView imgFood;
    private ImageView imgMenu;
    private ImageView imgPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_all);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        recycleviewHomeStay = findViewById(R.id.recycleviewallplace);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        db = new Database(this,"AppTravel",null,1);
        ListHomeStay = db.getAllHomeStay();
        recycleviewHomeStay.setLayoutManager(linearLayoutManager);
        homeStayAdapter = new HomeStayAdapter(this,ListHomeStay);
        recycleviewHomeStay.setAdapter(homeStayAdapter);
        imgHome = findViewById(R.id.Home);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHomeStayActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgPlace = findViewById(R.id.Place);
        imgPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHomeStayActivity.this,AllPlaceActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgFood = findViewById(R.id.Food);
        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHomeStayActivity.this,AllFoodActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}