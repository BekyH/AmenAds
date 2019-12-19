package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class typesAdapter extends RecyclerView.Adapter< typesAdapter.ViewHolder> {

    private List<String> types;
    private Context context;
    private final typesAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String item);
    }


    public typesAdapter(Context context, List<String>types, typesAdapter.OnItemClickListener listener) {
        this.context = context;
        this.types = types;
        this.listener=listener;
    }

    @NonNull
    @Override
    public typesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_type, parent, false);
        return new typesAdapter.ViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull ChurchAdapter.ViewHolder holder, int position) {
//
//        Church church = mchurch.get(position);
//        //holder.churchImage.setImageResource(church.getChurchImage());
//        holder.churchName.setText(church.getChurchName());
//
//    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.type.setText(types.get(position));
        holder.bind(types.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
        }

        public void bind(final String type1, final typesAdapter.OnItemClickListener listener) {
            type.setText(type1);
            //    Picasso.with(itemView.getContext()).load(item.imageUrl).into(image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(type1);
                }
            });
        }
    }
}