package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.church;


import java.util.List;

public class ChurchAdapter extends RecyclerView.Adapter<ChurchAdapter.viewHolder> {
    private Context context;
    private List<church> churches;

    public ChurchAdapter(Context context,List<church> churches){
        this.context = context;
        this.churches = churches;
        LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ChurchAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.church_recycler_view_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChurchAdapter.viewHolder holder, int position) {
        if (churches!=null){
            church ch = churches.get(position);
            holder.main_church_name.setText(ch.getMainchurch());

        }

    }

    @Override
    public int getItemCount() {
        if(churches!=null){
            return churches.size();
        }
        else{
            return 0;
        }


    }
    public  class viewHolder extends RecyclerView.ViewHolder{
        public TextView main_church_name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            main_church_name = itemView.findViewById(R.id.main_church_text_view);
        }
    }
}
