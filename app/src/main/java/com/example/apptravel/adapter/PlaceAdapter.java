package com.example.apptravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.apptravel.models.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends BaseAdapter implements Filterable {

    private ArrayList<Place> data;
    private ArrayList<Place> dataBackup;
    private Activity context;
    private LayoutInflater inflater;
    public PlaceAdapter() {
    }

    public PlaceAdapter(ArrayList<Place> data, Activity activity) {
        this.data = data;
        this.context = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<Place> getData() {
        return data;
    }

    public void setData(ArrayList<Place> data) {
        this.data = data;
    }

    public ArrayList<Place> getDataBackup() {
        return dataBackup;
    }

    public void setDataBackup(ArrayList<Place> dataBackup) {
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
