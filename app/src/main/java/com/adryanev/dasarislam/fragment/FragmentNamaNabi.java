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

import com.adryanev.dasarislam.Adapter.NamaNabiAdapter;
import com.adryanev.dasarislam.Data;
import com.adryanev.dasarislam.DbHelper;
import com.adryanev.dasarislam.R;

import java.util.ArrayList;

/**
 * Created by AdryanEV on 26/06/2016.
 */
public class FragmentNamaNabi extends Fragment {
    RecyclerView recyclerView;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    ArrayList<Data> namaNabi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        openHelper = new DbHelper(getActivity());
        db = openHelper.getReadableDatabase();
        namaNabi = getNamaNabi();
        View view = inflater.inflate(R.layout.activity_main,container,false);
        NamaNabiAdapter adapter = new NamaNabiAdapter(getActivity(),namaNabi);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public ArrayList<Data> getNamaNabi(){

        namaNabi = new ArrayList<>();

        String selectQuery = "SELECT * FROM namaNabi";

        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do {
                Data data = new Data();
                data.setId(Integer.parseInt(cursor.getString(0)));
                data.setJudul(cursor.getString(1));
                data.setPenjelasan(cursor.getString(2));

                namaNabi.add(data);
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return namaNabi;
    }
}
