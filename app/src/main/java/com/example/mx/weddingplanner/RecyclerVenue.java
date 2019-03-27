package com.example.mx.weddingplanner;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerVenue extends RecyclerView.Adapter<RecyclerVenue.ViewHolder> {
        private String[] titles = {"Hotel",
                "Banquet Hall",
                "Farm/Barn",
                "Vineyard/Winery",
                "Park/Garden",
                "Restaurant",
                "Mansion",
                "Country Club"};
        private String[] details = {"Hotels make great weddingveues for couples hosting lots of out -of-townguests.",
                "Banquet halls are ussually on the larger sie and work well for weddings with bigger guests counts.",
                "Farm/Barn offer rustic charm and an innately casual feel,plus mazing ,scenic backdrops for photos",
                "Vineyard offer event space for weddings ",
                "Park doesnt require toomuch additional decor which can begreat for your budget.",
                "Resturant is the most common and typical choicce of most couple.Resturant offer delicious food for the guets ",
                "Historic places and Mnsion have an innate sense ofnostaligia and a vintage vibe.These charming venues ussually fetaure both indoor andoutdoor spaces for the wedding as well as lots of the unique opportunities or portraits",
                "Country club weddings are often stress free and os course ,stunning."};
        private int[] images = {R.drawable.hotelvenue,
                                R.drawable.banquet,
                                R.drawable.barn,
                                R.drawable.vineyard,
                                R.drawable.garden,
                                R.drawable.resturant,
                                R.drawable.historichouse,
                                R.drawable.countryclub};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venue_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);
    }
    @Override
    public int getItemCount() {
        return titles.length;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView itemImage;
            public TextView itemTitle;
            public TextView itemDetail;

            public ViewHolder(View itemView) {
                super(itemView);
                itemImage =
                        (ImageView) itemView.findViewById(R.id.venue_image);
                itemTitle =
                        (TextView) itemView.findViewById(R.id.venue_title);
                itemDetail =
                        (TextView) itemView.findViewById(R.id.venue_detail);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        int position = getAdapterPosition();
                    }
                });
            }
        }
    }
