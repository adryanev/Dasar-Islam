package com.adryanev.dasarislam.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adryanev.dasarislam.Adapter.RukunImanAdapter;
import com.adryanev.dasarislam.Data;
import com.adryanev.dasarislam.DbHelper;
import com.adryanev.dasarislam.R;

import java.util.ArrayList;

/**
 * Created by AdryanEV on 26/06/2016.
 */
public class FragmentRukunIman extends Fragment {
    RecyclerView recyclerView;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    ArrayList<Data> rukunIman;
    RukunImanAdapter adapter;

    public ArrayList<Data> getRukunIslam(){
        openHelper = new DbHelper(getActivity());
        db = openHelper.getReadableDatabase();
        rukunIman = new ArrayList<>();

        String selectQuery = "SELECT * FROM rukunIman";

        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do {
                Data rukun = new Data();
                rukun.setId(Integer.parseInt(cursor.getString(0)));
                rukun.setJudul(cursor.getString(1));
                rukun.setPenjelasan(cursor.getString(2));

                rukunIman.add(rukun);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return rukunIman;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        ArrayList<Data> data = getRukunIslam();
        adapter = new RukunImanAdapter(getActivity(),data);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
