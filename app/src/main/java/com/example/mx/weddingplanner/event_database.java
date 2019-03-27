package com.example.mx.weddingplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Eden on 5/26/2018.
 */

public class event_database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="events.db";
    private static final String TABLE_NAME="events_table";
    private static final String Col_1="ID";
    private static final String Col_2="EVENTDATE";
    private static final String Col_3="EVENTTYPE";
    private static final String Col_4="EVENTDESCRIPTION";

    public event_database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(("CREATE TABLE ") + TABLE_NAME+("( ID INTEGER PRIMARY KEY AUTOINCREMENT , EVENTDATE TEXT , EVENTTYPE TEXT , EVENTDESCRIPTION TEXT)"));
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS ")+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String even,String date,String des){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues con= new ContentValues();
        con.put(Col_2,even);
        con.put(Col_3,even);
        con.put(Col_4,even);
        long result=db.insert(TABLE_NAME,null, con);
        if(result==-1){db.close();return false;}else{db.close(); return true;}
    }
    public Cursor getAllDatas(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cur=db.rawQuery( "select * from "+TABLE_NAME,null);
        return cur;
    }
    public boolean deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
       if(db.delete(TABLE_NAME,"ID= ?",new String[]{id})>0){
           return true;
       }
       else{
           return false;
       }

    }
}
