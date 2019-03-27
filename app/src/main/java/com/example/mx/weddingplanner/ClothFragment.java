package com.example.mx.weddingplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
public class ClothFragment extends Fragment {
    ImageView cloth;
    ArrayList<String> arr;
    int i=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_cloth, container, false);
        cloth=view.findViewById(R.id.imageView_cloth);
        cloth.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch(i){
                            case 0:
                                cloth.setImageResource(R.drawable.modernlove);
                                break;
                            case 1:
                                cloth.setImageResource(R.drawable.beachykeen);
                                break;
                            case 2:
                                cloth.setImageResource(R.drawable.citychic);
                                break;
                            case 3:
                                cloth.setImageResource(R.drawable.formalballroom);
                                break;
                            case 4:
                                cloth.setImageResource(R.drawable.modernlove);
                                break;
                            case 5:
                                cloth.setImageResource(R.drawable.preppypairing);
                                break;
                            case 6:
                                cloth.setImageResource(R.drawable.romanticrustic);
                                break;
                            case 7:
                                cloth.setImageResource(R.drawable.royalromance);
                                break;
                            case 8:
                                cloth.setImageResource(R.drawable.ultraglam);

                                break;
                            case 9:
                                cloth.setImageResource(R.drawable.vintagevibes);
                                i=0;
                                break;

                        }
                        i++;
                    }
                });
        return view;
    }
}
