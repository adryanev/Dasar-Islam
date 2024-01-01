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
 * Created by AdryanEV on 26/06/2016.
 */
public class NamaMalaikatAdapter extends RecyclerView.Adapter<NamaMalaikatAdapter.DataViewHolder> {
    private LayoutInflater inflater;
    public NamaMalaikatAdapter (Context context, ArrayList<Data> namaMalaikat){
        this.namaMalaikat = namaMalaikat;
        inflater = LayoutInflater.from(context);
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
    ArrayList<Data> namaMalaikat;
    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_nama_malaikat,parent,false);
        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        Data malaikat = namaMalaikat.get(position);
        holder.judul.setText(malaikat.getJudul());
        holder.penjelasan.setText(malaikat.getPenjelasan());
    }

    @Override
    public int getItemCount() {
        return namaMalaikat.size();
    }
}
