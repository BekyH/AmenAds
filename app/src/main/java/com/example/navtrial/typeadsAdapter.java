package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.event;

import java.util.List;

public class typeadsAdapter extends RecyclerView.Adapter<typeadsAdapter.ViewHolder> {
    private List<Type> types;
    private Context context;
    private List<Type> mtypes;

    public typeadsAdapter(Context context,List<Type> types){
        this.context = context;
        this.types = types;
        LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_type_recyclerview,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull typeadsAdapter.ViewHolder holder, int position) {
       if(types!=null){
           final Type ty = types.get(position);

           holder.type_conference.setText(ty.conference);
           holder.type_concert.setText(ty.concert);
           holder.type_worship.setText(ty.worship);
           holder.type_training.setText(ty.training);
           holder.type_art.setText(ty.art);

       }
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView type_conference,type_concert,type_worship,type_training,type_art;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type_conference = itemView.findViewById(R.id.ads_conference);
            type_concert = itemView.findViewById(R.id.ads_concert);
            type_worship = itemView.findViewById(R.id.ads_worship);
            type_art = itemView.findViewById(R.id.ads_art);
            type_training = itemView.findViewById(R.id.ads_training);
        }
    }
}
