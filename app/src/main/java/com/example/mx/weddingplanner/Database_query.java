package com.example.mx.weddingplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eden on 5/26/2018.
 */

public class Database_query extends SQLiteOpenHelper {

    public static final String databasename="wedding.db";
    public static final String tablename="wedding_database";
    public static final String col1="ID";
    public static final String col2="EVENT";
    public static final String col3="DATE";
    public static final String col4="DESCRIPTION";
    SQLiteDatabase db;

    public Database_query(Context context) {
        super(context,databasename, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        db.execSQL(("create table ")+tablename+(" (ID INTEGER PRIMARY KEY AUTOINCREMENT,EVENT TEXT,DATE TEXT,DESCRIPTION TEXT)") );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXIST")+tablename);
        onCreate(db);
    }

    public Cursor getAllData(){
        try{
            // arr_list=new ArrayList<>();
            SQLiteDatabase d=this.getWritableDatabase();
            Cursor cur=d.rawQuery("select * from wedding_database",null);
            return cur;}
        catch(Exception e){ }
        return null;

    }



    public boolean insertData(String event,String date,String descrription){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cont_value=new ContentValues();
        cont_value.put(col2,event);
        cont_value.put(col3,date);
        cont_value.put(col4,descrription);
        long result= db.insert(tablename,null,cont_value);
        if(result==-1){return false;}else{return true;}

    }
        /*

        public Cursor getAllData(){
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor cur=db.rawQuery(("select * from ")+tablename,null);
            return cur;

        }*/

}

