package com.example.mx.weddingplanner;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FoodFragment extends Fragment {
TextView et,ko,am,ar,eu;
boolean truth_et=true;
boolean truth_ko=true;
    boolean  truth_am=true;
    boolean truth_ar=true;
    boolean  truth_eu=true;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

             final View view=inflater.inflate(R.layout.fragment_food, container, false);
             et=view.findViewById(R.id.ethiopian_food);
             ko=view.findViewById(R.id.korean_food);
             am=view.findViewById(R.id.american_food);
             ar=view.findViewById(R.id.arabian_food);
             eu=view.findViewById(R.id.europe_food);
             et.setOnClickListener(
                     new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             LinearLayout lay=view.findViewById(R.id.ethiopian_layout);
                             if(truth_et){
                                 TextView tx=new TextView(v.getContext());
                                 tx.setWidth(et.getWidth());
                                 tx.setTextSize(et.getTextSize());

                                 tx.setText("\t\tDor Wot (chicken with boiled egg)\n" +
                                         "Alecha wot (beef with lots of minched onion)\n" +
                                         "Rice with vegitables)\n" +
                                         "Fish cutelet\n" +
                                         "Keteffo Miced meat with lots of seasoning and ethiopian butter\n" +
                                         "Tere sega (Raw beef)\n" +
                                         "Different fried vegitables\n" +
                                         "Popeti fried Minced Meat\n" +
                                         "Miser wot lentil with onion and spices\n" );
                                 truth_et=false;
                                 lay.addView(tx);
                             }
                             else{
                                 lay.removeViewAt(1);
                                 truth_et=true;
                             }
                         }
                     });
            ko.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            LinearLayout lay=view.findViewById(R.id.korean_layout);
                            if(truth_ko){
                                TextView tx=new TextView(v.getContext());
                                tx.setWidth(et.getWidth());
                                tx.setTextSize(et.getTextSize());
                                tx.setText("Japche Sweet potato spagehti\n" +
                                        "Gimichi with rice\n" +
                                        "Bullgogi Minced meat with little bit of suger\n" +
                                        "Chicken fried\n" +
                                        "Different fried vegitables\n" +
                                        "Roasted pork\n" );
                                truth_ko=false;
                                lay.addView(tx);}
                            else{
                                lay.removeViewAt(1);
                                truth_ko=true;
                            }

                        }
                    });
            am.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            LinearLayout lay=view.findViewById(R.id.american_layout);
                            if(truth_am){
                                TextView tx=new TextView(v.getContext());
                                tx.setWidth(et.getWidth());
                                tx.setTextSize(et.getTextSize());
                                tx.setText("Rice with vegitables\n" +
                                        "Different Salad with  Fresh Mozzarella and Tomatoes and Basil\n" +
                                        "Mini Burgers \n" +
                                        "Fried chicken\n" +
                                        "Spagehtti with meatballs\n" +
                                        "Raisins, Almonds and a Squeeze of Lemon\n" +
                                        "Cucumber Salad with Yogurt Dill Dressing\n" +
                                        "Grilled and Marinated Vegetables topped with Parmesan Shavings\n" +
                                        "Grilled Fresh Tuna served with Tomato\n" +
                                        "Carbonara\n" +
                                        "Pizza\n" +
                                        "Turkey \n" );
                                truth_am=false;
                                lay.addView(tx);}
                            else{
                                lay.removeViewAt(1);
                                truth_am=true;
                            }
                        }
                    });
            ar.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            LinearLayout lay=view.findViewById(R.id.arabian_layout);
                            if(truth_ar){
                                TextView tx=new TextView(v.getContext());
                                tx.setWidth(et.getWidth());
                                tx.setTextSize(et.getTextSize());
                                tx.setText("Kilich Sheesh (Turkish skewered Swordfish with braised)\n" +
                                        "Samak Hara (Hammour with Tomato, bell Peppers, Garlic and Coriander)\n" +
                                        "Mixed Grill (Shish Taouk, Kofta Kebab and Shish Kebab with Sumac Onions)\n" +
                                        "Ojja (Meat balls in Tomato Sauce with Eggs)\n" +
                                        "Kibbeh Bil Laban (Minced Meat and cracked wheat dumplings in Yogurt Sauce)\n" +
                                        "Macarona Bi Dijaj (Pasta with Chicken in Tomato Sauce)\n" +
                                        "Khodra Mahshi (Stuffed Eggplant and baby Marrows and bell Peppers)\n" +
                                        "Yakhnit El Ardishawki (Artichoke Stew)\n" +
                                        "Roasted Potato with Arabic Spices\n" +
                                        "Saffron Rice with Green Peas\n" +
                                        "Steamed Rice");

                                truth_ar=false;
                                lay.addView(tx);}
                            else{
                                lay.removeViewAt(1);
                                truth_ar=true;
                            }
                        }
                    });
            eu.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            LinearLayout lay=view.findViewById(R.id.europe_layout);
                            if(truth_eu){
                                TextView tx=new TextView(v.getContext());
                                tx.setWidth(et.getWidth());
                                tx.setTextSize(et.getTextSize());
                                tx.setText("Assorted Bread Basket served with Olive Oil and Tapenade\n" +
                                        "Caprese: Salad of Fresh Mozzarella and Tomatoes and Basil\n" +
                                                "Pesto Oil, Rocket Salad mixed with Slivered Pears\n" +
                                                "Sprinkles of Goat Cheese and Caramelized Walnuts\n" +
                                                "Couscous Salad with Mint\n" +
                                                "Raisins, Almonds and a Squeeze of Lemon\n" +
                                                "Cucumber Salad with Yogurt Dill Dressing\n" +
                                                "Grilled and Marinated Vegetables topped with Parmesan Shavings\n" +
                                                "Grilled Fresh Tuna served with Tomato\n" +
                                                "Mango and Onion Salsa\n" +
                                                "sliced Beef Tenderloin with a Chanterelle Sauce\n" +
                                                "Grilled English Cumberland Sausages\n" +
                                                "Tapenade Mash Potato and Broccoli Amandine");

                                truth_eu=false;
                                lay.addView(tx);}
                            else{
                                lay.removeViewAt(1);
                                truth_eu=true;
                            }
                        }
                    });
            return  view;
        }





    }