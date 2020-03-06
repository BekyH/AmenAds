package com.example.navtrial;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.church;
import com.example.navtrial.webService.GetChurchService;
import com.example.navtrial.webService.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class churchBranchAdapter extends RecyclerView.Adapter<churchBranchAdapter.ViewHolder> {
    ProgressDialog progressDialog;
    private Context context;
    private List<church> churches;
    private List<String> nchurches;
    private List<church> mchurches;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.branch_church_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final church cch = churches.get(position);
                progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("Loading....");
                progressDialog.show();

                GetChurchService churchService = new ServiceBuilder().getRetrofitInstance().create(GetChurchService.class);
                Call<List<church>> call = churchService.getChurches();
                call.enqueue(new Callback<List<church>>() {
                    @Override
                    public void onResponse(Call<List<church>> call, retrofit2.Response<List<church>> response) {

                        if(response.isSuccessful()){
                            progressDialog.dismiss();

                            mchurches = response.body();
                            ArrayList<church> chu = new ArrayList<>();
                            for(int i = 0;i<mchurches.size();i++){
                                if(mchurches.get(i).getChurchName().equals(cch.getChurchName())){
                                    chu.add(mchurches.get(i));


                                }
                            }



                            churchDetailFragment cdf = new churchDetailFragment(chu);

                            ((MainActivity)context).getSupportFragmentManager()
                                    .beginTransaction().
                                    replace(R.id.containers,cdf)

                                    .addToBackStack(null)
                                    .commit();






                        }
                        else {

                        }

                    }

                    @Override
                    public void onFailure(Call<List<church>> call, Throwable t) {
                        progressDialog.dismiss();
                        if (t instanceof IOException) {

                            Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(context, "conversion issue! big problems", Toast.LENGTH_SHORT).show();

                        }
                    }
                });




            }
        });
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
