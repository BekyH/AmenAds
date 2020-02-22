package com.example.navtrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.event;
import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.android.material.tabs.TabLayout;

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

                switch (vh.getAdapterPosition()){

                    case 0:
                        conferenceFragment cf = new conferenceFragment();
                        ((MainActivity)context).getSupportFragmentManager()
                                .beginTransaction().
                                replace(R.id.containers,cf)
                                .addToBackStack(null)
                                .commit();

                        break;
                    case 1:
                       concertFragment concertFragment = new concertFragment();
                        ((MainActivity)context).getSupportFragmentManager()
                                .beginTransaction().
                                replace(R.id.containers,concertFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 2:
                      worshipFragment wf = new worshipFragment();
                        ((MainActivity)context).getSupportFragmentManager()
                                .beginTransaction().
                                replace(R.id.containers,wf)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 3:
                        trainingFragment tf = new trainingFragment();
                        ((MainActivity)context).getSupportFragmentManager()
                                .beginTransaction().
                                replace(R.id.containers,tf)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case 4:
                        artFragment af = new artFragment();
                        ((MainActivity)context).getSupportFragmentManager()
                            .beginTransaction().
                                    replace(R.id.containers,af)
                            .addToBackStack(null)
                            .commit();
                        break;
                }
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
