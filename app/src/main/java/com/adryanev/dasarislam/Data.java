package com.adryanev.dasarislam;

import android.support.v7.widget.RecyclerView;

/**
 * Created by AdryanEV on 25/06/2016.
 */
public class Data {

    private int id;
    private String judul;
    private String penjelasan;
    public Data(){

    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPenjelasan(String penjelasan){
        this.penjelasan = penjelasan;
    }
    public String getJudul() {
        return this.judul;
    }
    public String getPenjelasan(){
        return this.penjelasan;
    }
}
