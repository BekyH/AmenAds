package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adsAdapter extends RecyclerView.Adapter<adsAdapter.ViewHolder> {
    private List<Ads> ads;
    private Context context;


 public adsAdapter(Context context,List<Ads>ads){
     this.context = context;
     this.ads = ads;

 }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = View.inflate(parent.getContext(),R.layout.ads_recycler_view_list_item,null);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_recycler_view_list_item,parent,false);


        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ads ad = ads.get(position);
        holder.ads_name.setText(ad.getAds_name());
        holder.ads_organizer.setText(ad.getAds_organizer());
        holder.ads_location.setText(ad.getAds_location());
        holder.ads_date.setText(ad.getads_date());

    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView ads_name,ads_organizer,ads_date,ads_category,ads_location;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ads_name = itemView.findViewById(R.id.ads_name_text_view_card_view);
            ads_organizer = itemView.findViewById(R.id.ads_organizer_text_view);
            ads_location = itemView.findViewById(R.id.ads_location_text_view);
            ads_date = itemView.findViewById(R.id.ads_date_text_view);

        }
    }
}