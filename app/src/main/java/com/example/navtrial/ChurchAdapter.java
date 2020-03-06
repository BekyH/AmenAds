package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.church;


import java.util.List;

public class ChurchAdapter extends RecyclerView.Adapter<ChurchAdapter.viewHolder> {
    private Context context;
    private List<String> churches;
    private List<church> nchurhches;;



    public ChurchAdapter(Context context,List<String> churches){
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
    public void onBindViewHolder(@NonNull ChurchAdapter.viewHolder holder, final int position) {
        holder.main_church_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ch = churches.get(position);


            }
        });
        if (churches!=null){
            String ch = churches.get(position);

            holder.main_church_name.setText(ch);

        }


    }
    public void setChurches(List<church> churches){
        nchurhches = churches;
        notifyDataSetChanged();
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
