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

public class churchDetailAdapter extends RecyclerView.Adapter<churchDetailAdapter.ViewHolder> {
private Context context;
private List<church> mchurches;

            public churchDetailAdapter(Context context,List<church> mchurches){
                this.context = context;
                this.mchurches = mchurches;
                LayoutInflater.from(context);

            }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.church_detail_recycler_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    if(mchurches!=null){
        church branches = mchurches.get(position);
        holder.branchName.setText(branches.getChurchName());
        holder.mainChurchName.setText(branches.getMainchurch());
        holder.phoneNumber.setText(branches.getChurchPhoneno());
        holder.churchLocation.setText(branches.getLocation());
        holder.churchProgram.setText(branches.getProgram());
        holder.churchDescritpion.setText(branches.getDescription());
        holder.churchBankAccount.setText(branches.getBankAccount());

    }
    }

    @Override
    public int getItemCount() {
                if(mchurches!=null){
                    return mchurches.size();

                }
                else{
                    return 0;
                }

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView branchName;
        public TextView mainChurchName;
        public TextView phoneNumber;
        public TextView churchLocation;
        public TextView churchProgram;
        public TextView churchDescritpion;
        public TextView churchBankAccount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            branchName = itemView.findViewById(R.id.branch_name_text_view);
            mainChurchName = itemView.findViewById(R.id.main_church_name_text_view);
            churchLocation = itemView.findViewById(R.id.church_location_text_view);
            churchProgram = itemView.findViewById(R.id.church_program_text_view);
            churchDescritpion = itemView.findViewById(R.id.church_description_text_view);
            churchBankAccount = itemView.findViewById(R.id.church_bank_account_text_view);
            phoneNumber = itemView.findViewById(R.id.branch_church_phone_text_view);
        }
    }
}
