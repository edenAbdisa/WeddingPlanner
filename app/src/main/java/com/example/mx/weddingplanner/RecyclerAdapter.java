package com.example.mx.weddingplanner;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {
    Context con;
    ArrayList<String> titles;
    event_database even;
    MainActivity main;
    int count =0;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    public RecyclerAdapter(Context co){
        con=co;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.single_event, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

       // Toast.makeText(con,"setted  liine59",Toast.LENGTH_SHORT).show();
        even=new event_database(con);
        ArrayList<String> tit=new ArrayList<>();
        Cursor cur=even.getAllDatas();
        if(cur.getCount()==0){
            tit.add("no value inserted yet" );
        }
        while(cur.moveToNext()){
            tit.add(cur.getString(1));
            tit.add(cur.getString(2));
            tit.add(cur.getString(3));
        }
        try {
            viewHolder.itemTitle.setText(tit.get(count).toString());count+=1;
            viewHolder.itemDetail.setText(tit.get(count).toString());count+=1;
            viewHolder.itemDescription.setText(tit.get(count).toString());count+=1;
        }
        catch(Exception ex){
           /// Toast.makeText(con,String.valueOf(tit.size()),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public int getItemCount(){
        even=new event_database(con);
       // Toast.makeText(con,"setted  liine86",Toast.LENGTH_SHORT).show();
        Cursor cur=even.getAllDatas();
            if(cur.getCount()==0){
                return 0;
            }
            else{
                //Toast.makeText(con,String.valueOf(cur.getCount()),Toast.LENGTH_SHORT).show();
                return cur.getCount();
            }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTitle;
        public TextView itemDetail;
        public TextView itemDescription;
        public Button eventdelete;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemTitle =itemView.findViewById(R.id.event_date);
            itemDetail =itemView.findViewById(R.id.event_type);
            itemDescription =itemView.findViewById(R.id.event_description);


        }
    }



}

