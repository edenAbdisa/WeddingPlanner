package com.example.mx.weddingplanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    ImageView imageviewaddnote,imageviewtwo;
    ImageView imageviewethiopianfood;
    SimpleCursorAdapter mAdapter;
    MatrixCursor mMatrixCursor;
    EditText edittextaddevent,edittextadddate,edittextadddescription;
    ListView listviewevents;
    Button imageviewlistpeople,imageviewlistcolor,imageviewlistfood,imageviewlistvenue,imageviewchecklist;
    Database_query db;
    event_database even;
    ArrayAdapter<String> arr_adapter;
    ClothFragment cloth_fragment;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new Database_query(this);
        imageviewlistpeople =findViewById(R.id.imageview_list_people);
        imageviewlistcolor=findViewById(R.id.imageview_list_color);
        imageviewlistfood=findViewById(R.id.imageview_list_food);
        imageviewlistvenue=findViewById(R.id.imageview_list_venue);
        imageviewchecklist=findViewById(R.id.imageview_checklist);
        imageviewethiopianfood=findViewById(R.id.ethiopian_food);
        cloth_fragment=new ClothFragment();
        FragmentManager frma=getSupportFragmentManager();
        FragmentTransaction ft=frma.beginTransaction();
        ft.replace(R.id.linearlayout_fragment_area,cloth_fragment);
        ft.commit();
        imageviewlistpeople.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeFragment(v);

                        }
                });
        imageviewlistcolor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       changeFragment(v);
                    }
                });
        imageviewlistfood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeFragment(v);
                    }
                });
        imageviewlistvenue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeFragment(v);
                    }
                });
        imageviewchecklist.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeFragment(v);
                    }
                });

    }

    public void changeFragment(View view){
        FoodFragment food_fragment=new FoodFragment();
        EventFragment event_fragment=new EventFragment();
        VenueFragment venue_fragment=new VenueFragment();

        if(view==findViewById(R.id.imageview_list_people)){
            getPeopleLayout();
        }
        if(view==findViewById(R.id.imageview_list_venue)){

            FragmentManager frma=getSupportFragmentManager();
            FragmentTransaction ft=frma.beginTransaction();
            ft.replace(R.id.linearlayout_fragment_area,venue_fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.imageview_list_food)){
            FragmentManager frma=getSupportFragmentManager();
            FragmentTransaction ft=frma.beginTransaction();
            ft.replace(R.id.linearlayout_fragment_area,food_fragment);
            ft.commit();

        }
        if(view==findViewById(R.id.imageview_list_color)){
            FragmentManager frma=getSupportFragmentManager();
            FragmentTransaction ft=frma.beginTransaction();
            ft.replace(R.id.linearlayout_fragment_area,cloth_fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.imageview_checklist)){


            FragmentManager frma=getSupportFragmentManager();
            FragmentTransaction ft=frma.beginTransaction();
            ft.replace(R.id.linearlayout_fragment_area,event_fragment);
            ft.commit();

        }
    }
    public void update_event(){
        EventFragment event_fragment=new EventFragment();
        FragmentManager frma=getSupportFragmentManager();
        FragmentTransaction ft=frma.beginTransaction();
        ft.replace(R.id.linearlayout_fragment_area,event_fragment);
        ft.commit();}
    public void getPeopleLayout(){
        Intent intent=new Intent(this , AddPeople.class);
        startActivity(intent);
    }
    public Context get(){
        return this;
    }
}
