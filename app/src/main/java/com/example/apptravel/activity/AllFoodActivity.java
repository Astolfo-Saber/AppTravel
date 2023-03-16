package com.example.apptravel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptravel.Database;
import com.example.apptravel.R;
import com.example.apptravel.adapter.FoodAdapter;
import com.example.apptravel.models.Food;

import java.util.List;

public class AllFoodActivity extends AppCompatActivity {
    private RecyclerView recycleviewFood;
    private Database db;
    private List<Food> ListFood;
    private FoodAdapter foodAdapter;
    private ImageView imgHome;
    private ImageView imgHomeStay;
    private ImageView imgMenu;
    private ImageView imgPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_all);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        recycleviewFood = findViewById(R.id.recycleviewallplace);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        db = new Database(this,"AppTravel",null,1);
        ListFood = db.getAllFood();
        recycleviewFood.setLayoutManager(linearLayoutManager);
        foodAdapter = new FoodAdapter(this,ListFood);
        recycleviewFood.setAdapter(foodAdapter);
        imgHome = findViewById(R.id.Home);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFoodActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgHomeStay = findViewById(R.id.HomeStay);
        imgHomeStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFoodActivity.this,AllHomeStayActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgPlace = findViewById(R.id.Place);
        imgPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFoodActivity.this,AllPlaceActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
