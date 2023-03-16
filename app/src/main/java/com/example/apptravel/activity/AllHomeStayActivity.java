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
import com.example.apptravel.adapter.HomeStayAdapter;
import com.example.apptravel.models.HomeStay;

import java.util.ArrayList;
import java.util.List;

public class AllHomeStayActivity extends AppCompatActivity {
    private RecyclerView recycleviewHomeStay;
    private Database db;
    private List<HomeStay> ListHomeStay;
    private HomeStayAdapter homeStayAdapter;
    private ImageView imgHome;
    private ImageView imgFood;
    private ImageView imgPlace;
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
        recycleviewHomeStay = findViewById(R.id.recycleviewallplace);
        imgHome = findViewById(R.id.Home);
        imgPlace = findViewById(R.id.Place);
        imgFood = findViewById(R.id.Food);
        imgMenu = findViewById(R.id.Menu);
        etSearch = findViewById(R.id.txtSearchAllPlace);
    }

    private void addData(){
        db = new Database(this,"AppTravel",null,1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        ListHomeStay = db.getAllHomeStay();
        homeStayAdapter = new HomeStayAdapter(this,ListHomeStay);
        recycleviewHomeStay.setLayoutManager(linearLayoutManager);
        recycleviewHomeStay.setAdapter(homeStayAdapter);
    }

    private void addEvent(){
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHomeStayActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imgPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHomeStayActivity.this,AllPlaceActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllHomeStayActivity.this,AllFoodActivity.class);
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
    public void filter(String search) {
        List<HomeStay> HomeStayFilter = new ArrayList<>();
        for (HomeStay homeStay : ListHomeStay) {
            if ((homeStay.getHomeStayName().toLowerCase().contains(search.toLowerCase()))) {
                HomeStayFilter.add(homeStay);
            }
        }
        homeStayAdapter.filterHomeStay(HomeStayFilter);
    }
}