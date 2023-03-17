package com.example.apptravel.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.apptravel.models.Food;
import com.example.apptravel.models.HomeStay;
import com.example.apptravel.models.Place;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public List<Place> getAllPlace() {
        List<Place> list = new ArrayList<>();
        //cau truy van
        String sql = "Select * from "+"Place";
        //lay doi tuong csdl sqlite
        SQLiteDatabase db = this.getReadableDatabase();
        //chay cau truy van tra ve dang cursor
        Cursor cursor = db.rawQuery(sql,null);
        //tao arraylist<Contact> de tra ve
        if (cursor != null)
            while (cursor.moveToNext()){
                Place place = new Place(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
                list.add(place);
            }
        return list;
    }
    public List<Food> getAllFood() {
        List<Food> list = new ArrayList<>();
        //cau truy van
        String sql = "Select * from "+"Food";
        //lay doi tuong csdl sqlite
        SQLiteDatabase db = this.getReadableDatabase();
        //chay cau truy van tra ve dang cursor
        Cursor cursor = db.rawQuery(sql,null);
        //tao arraylist<Contact> de tra ve
        if (cursor != null)
            while (cursor.moveToNext()){
                Food food = new Food(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6));
                list.add(food);
            }
        return list;
    }
    public List<HomeStay> getAllHomeStay() {
        List<HomeStay> list = new ArrayList<>();
        //cau truy van
        String sql = "Select * from "+"HomeStay";
        //lay doi tuong csdl sqlite
        SQLiteDatabase db = this.getReadableDatabase();
        //chay cau truy van tra ve dang cursor
        Cursor cursor = db.rawQuery(sql,null);
        //tao arraylist<Contact> de tra ve
        if (cursor != null)
            while (cursor.moveToNext()){
                HomeStay homeStay = new HomeStay(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7));
                list.add(homeStay);
            }
        return list;
    }
}
