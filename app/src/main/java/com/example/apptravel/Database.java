package com.example.apptravel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
