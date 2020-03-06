package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.event;
import com.squareup.picasso.Picasso;

import java.util.List;

public class latestAdsAdapter extends RecyclerView.Adapter<latestAdsAdapter.ViewHolder> {

    private List<event> ads;
    private Context context;
    private List<event> mevents;

    public latestAdsAdapter(Context context,List<event> ads){
        this.context = context;
        this.ads = ads;
        LayoutInflater.from(context);


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_ads_recyclerview,parent,false);


        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(ads!=null){
            final event ad = ads.get(position);


            holder.ads_name.setText(ad.getName());
           //Picasso.get().load("http://10.0.2.2:3000/api/containers/ads/download/" + ad.getImage()).into(holder.im);
            Picasso.get().load("http://10.5.227.20:3000/api/containers/ads/download/" + ad.getImage()).into(holder.im);
            holder.ads_organizer.setText(ad.getOrganizer());
            holder.ads_location.setText(ad.getLocation());
            holder.ads_date.setText(ad.getEventDate());


        }

    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView ads_name,ads_organizer,ads_date,ads_category,ads_location;
        public ImageView im;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ads_name = itemView.findViewById(R.id.ads_name_text_view_card_view);
            ads_organizer = itemView.findViewById(R.id.ads_organizer_text_view);
            ads_location = itemView.findViewById(R.id.ads_location_text_view);
            ads_date = itemView.findViewById(R.id.ads_date_text_view);
            im = itemView.findViewById(R.id.image_view);
        }
    }
}
