package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.event;

import java.util.List;

public class typeadsAdapter extends RecyclerView.Adapter<typeadsAdapter.ViewHolder> {
    private List<String> types;
    private Context context;
    private List<Type> mtypes;

    public typeadsAdapter(Context context,List<String> types){
        this.context = context;
        this.types = types;
        LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_type_recyclerview,parent,false);
        final ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,String.valueOf(vh.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull typeadsAdapter.ViewHolder holder, int position) {
       if(types!=null){
           final String ty = types.get(position);


           holder.adsType.setText(ty);


       }
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView adsType;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adsType= itemView.findViewById(R.id.ads_type);

        }
    }
}
