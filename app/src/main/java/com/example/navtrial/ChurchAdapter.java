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

public class ChurchAdapter extends RecyclerView.Adapter<ChurchAdapter.viewHolder>
{

    private Context context;
    private List<String> churches;
    private List<church> nchurches;
    ProgressDialog progressDialog;




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
                final String ch = churches.get(position);
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

                          nchurches = response.body();
                            ArrayList<church> chu = new ArrayList<>();
                            for(int i = 0;i<nchurches.size();i++){
                                if(nchurches.get(i).getMainchurch().equals(ch)){
                                    chu.add(nchurches.get(i));


                                }
                            }



                            churchBranchFragment cbf = new churchBranchFragment(chu);

                            ((MainActivity)context).getSupportFragmentManager()
                                    .beginTransaction().
                                    replace(R.id.containers,cbf)

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
            String ch = churches.get(position);

            holder.main_church_name.setText(ch);

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
