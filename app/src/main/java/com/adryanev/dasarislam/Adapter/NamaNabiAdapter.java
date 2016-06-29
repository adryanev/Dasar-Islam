package com.adryanev.dasarislam.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.support.v4.content.ContextCompat;
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
public class NamaNabiAdapter extends RecyclerView.Adapter<NamaNabiAdapter.DataViewHolder> {
    private LayoutInflater inflater;
    ArrayList<Data> namaNabi;
    public static class DataViewHolder extends RecyclerView.ViewHolder{

        protected TextView judul;
        protected TextView penjelasan;

        public DataViewHolder(View itemView) {
            super(itemView);
            judul = (TextView) itemView.findViewById(R.id.judul);
            penjelasan = (TextView) itemView.findViewById(R.id.penjelasan);
        }
    }
    public NamaNabiAdapter (Context context, ArrayList<Data> namaNabi){
        this.namaNabi = namaNabi;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_nama_nabi,parent,false);
        DataViewHolder holder = new DataViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        Data nabi = namaNabi.get(position);
        holder.judul.setText(nabi.getJudul());
        holder.penjelasan.setText(nabi.getPenjelasan());

    }

    @Override
    public int getItemCount() {
        return namaNabi.size();
    }
}
