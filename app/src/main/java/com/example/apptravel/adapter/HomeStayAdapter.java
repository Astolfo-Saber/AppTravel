package com.example.apptravel.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.apptravel.models.HomeStay;

import java.util.ArrayList;

public class HomeStayAdapter extends BaseAdapter implements Filterable {
    private ArrayList<HomeStay> data;
    private ArrayList<HomeStay> dataBackup;
    private Activity context;
    private LayoutInflater inflater;

    public HomeStayAdapter() {
    }

    public HomeStayAdapter(ArrayList<HomeStay> data, Activity context, LayoutInflater inflater) {
        this.data = data;
        this.context = context;
        this.inflater = inflater;
    }

    public ArrayList<HomeStay> getData() {
        return data;
    }

    public void setData(ArrayList<HomeStay> data) {
        this.data = data;
    }

    public ArrayList<HomeStay> getDataBackup() {
        return dataBackup;
    }

    public void setDataBackup(ArrayList<HomeStay> dataBackup) {
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
