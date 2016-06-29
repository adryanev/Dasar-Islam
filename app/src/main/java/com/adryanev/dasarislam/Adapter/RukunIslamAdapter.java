package com.adryanev.dasarislam.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adryanev.dasarislam.Data;
import com.adryanev.dasarislam.R;

import java.util.ArrayList;

/**
 * Created by AdryanEV on 26/06/2016.
 */
public class RukunIslamAdapter extends RecyclerView.Adapter<RukunIslamAdapter.DataViewHolder> {

    private LayoutInflater inflater;

    public RukunIslamAdapter(Context context, ArrayList<Data> rukunIslam) {
        inflater = LayoutInflater.from(context);
        this.rukunIslam = rukunIslam;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_rukun_islam,parent,false);
        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        Data islam = rukunIslam.get(position);
        holder.judul.setText(islam.getJudul());
        holder.penjelasan.setText(islam.getPenjelasan());
    }

    @Override
    public int getItemCount() {
        return rukunIslam.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        protected TextView judul;
        protected TextView penjelasan;

        public DataViewHolder(View itemView) {
            super(itemView);
            judul = (TextView) itemView.findViewById(R.id.judul);
            penjelasan = (TextView) itemView.findViewById(R.id.penjelasan);
        }
    }

    ArrayList<Data> rukunIslam;
}
