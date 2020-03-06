package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.church;

import java.util.ArrayList;
import java.util.List;

public class churchBranchAdapter extends RecyclerView.Adapter<churchBranchAdapter.ViewHolder> {
    private Context context;
    private List<church> churches;

    public churchBranchAdapter(Context context,List<church> churches){
        this.context = context;
        this.churches = churches;

        LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.churchbranchrecycleritem,parent,false);

        return new churchBranchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (churches!=null){
            church branch = churches.get(position);

            holder.branch_church_name.setText(branch.getChurchName());

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

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView branch_church_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            branch_church_name = itemView.findViewById(R.id.branch_church_text_view);

        }
    }
}
