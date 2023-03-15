package com.example.apptravel.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.apptravel.models.Food;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter implements Filterable {
    private ArrayList<Food> data;
    private ArrayList<Food> dataBackup;
    private Activity context;
    private LayoutInflater inflater;

    public FoodAdapter() {
    }

    public FoodAdapter(ArrayList<Food> data, Activity context, LayoutInflater inflater) {
        this.data = data;
        this.context = context;
        this.inflater = inflater;
    }

    public ArrayList<Food> getData() {
        return data;
    }

    public void setData(ArrayList<Food> data) {
        this.data = data;
    }

    public ArrayList<Food> getDataBackup() {
        return dataBackup;
    }

    public void setDataBackup(ArrayList<Food> dataBackup) {
        this.dataBackup = dataBackup;
    }

    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
