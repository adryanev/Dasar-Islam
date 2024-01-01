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

import com.adryanev.dasarislam.Adapter.RukunIslamAdapter;
import com.adryanev.dasarislam.Data;
import com.adryanev.dasarislam.DbHelper;
import com.adryanev.dasarislam.R;

import java.util.ArrayList;

/**
 * Created by AdryanEV on 26/06/2016.
 */
public class FragmentRukunIslam extends Fragment {
    RecyclerView recyclerView;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    ArrayList<Data> rukunIslam;
    public FragmentRukunIslam (){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container , false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rukunIslam = getRukunIslam();
        RukunIslamAdapter adapter = new RukunIslamAdapter(getActivity(),rukunIslam);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public ArrayList<Data> getRukunIslam(){

        openHelper = new DbHelper(getActivity());
        db = openHelper.getReadableDatabase();
        rukunIslam = new ArrayList<>();

        String selectQuery = "SELECT * FROM rukunIslam";

        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do {
                Data rukun = new Data();
                rukun.setId(Integer.parseInt(cursor.getString(0)));
                rukun.setJudul(cursor.getString(1));
                rukun.setPenjelasan(cursor.getString(2));

                rukunIslam.add(rukun);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return rukunIslam;
    }
}
