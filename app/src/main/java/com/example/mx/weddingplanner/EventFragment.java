package com.example.mx.weddingplanner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EventFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button eventdelete;Button addevent;
    EditText txevent,txdate,txdescription;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_event, container, false);

        addevent=(Button)view.findViewById(R.id.event_add_button);
        txevent =(EditText) view.findViewById(R.id.textview_event);
        txdate =(EditText) view.findViewById(R.id.textview_date);
        txdescription =(EditText) view.findViewById(R.id.textview_description);


        addevent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        event_database db=new event_database(view.getContext());
                        boolean isInserted=db.insertData(txevent.getText().toString(),txdate.getText().toString(),txdescription.getText().toString());
                        if(isInserted){
                            //Toast.makeText(view.getContext(),"sucess",Toast.LENGTH_SHORT).show();
                            recyclerView = view.findViewById(R.id.recycler_event);
                            layoutManager = new LinearLayoutManager(view.getContext());
                            recyclerView.setLayoutManager(layoutManager);
                            adapter = new RecyclerAdapter(view.getContext());
                            recyclerView.setAdapter(adapter);
                        }
                        else{
                            Toast.makeText(view.getContext(),"failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        recyclerView = view.findViewById(R.id.recycler_event);
        layoutManager = new LinearLayoutManager(view.getContext());

        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }


}
