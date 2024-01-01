package com.adryanev.dasarislam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.adryanev.dasarislam.Data;
import com.adryanev.dasarislam.R;

import java.util.ArrayList;

/**
 * Created by AdryanEV on 25/06/2016.
 */
public class RukunImanAdapter extends RecyclerView.Adapter <RukunImanAdapter.DataViewHolder> {
    private LayoutInflater inflater;

    public RukunImanAdapter(Context context, ArrayList<Data> rukunIman){
        inflater = LayoutInflater.from(context);
        this.rukunIman = rukunIman;

    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{

        protected TextView judul;
        protected TextView penjelasan;

        public DataViewHolder(View itemView) {
            super(itemView);
            judul = (TextView) itemView.findViewById(R.id.judul);
            penjelasan = (TextView) itemView.findViewById(R.id.penjelasan);
        }
    }
    ArrayList<Data> rukunIman;


    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.fragment_rukun_iman,parent,false);
        DataViewHolder holder = new DataViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Data iman = rukunIman.get(position);
        holder.judul.setText(iman.getJudul());
        holder.penjelasan.setText(iman.getPenjelasan());


    }



    @Override
    public int getItemCount() {
        return rukunIman.size();
    }
}

