package com.example.navtrial;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.event;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class trainingFragment extends Fragment {
    private RecyclerView trainingadsRecyclerView;
    ProgressDialog progressDialog;
    private RecyclerView.Adapter trainingadsRecyclerAdapter;
    ArrayList<event> trainingads;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.training_fragment,container,false);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        GetAdsService ads_service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
        Call<List<event>> call = ads_service.getAllAds();
        call.enqueue(new Callback<List<event>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {
                progressDialog.dismiss();

                if(response.isSuccessful()){
                    //  Toast.makeText(getContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
                    getTrainingAds(response.body());
                }
                else {
                    Toast.makeText(getContext(),"response is not successfull",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<event>> call, Throwable t) {
                progressDialog.dismiss();
                if (t instanceof IOException) {

                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    Toast.makeText(getContext(), "conversion issue! big problems", Toast.LENGTH_SHORT).show();

                }
            }
        });



        return view;
    }

    public void getTrainingAds(List<event> allads){
        trainingads = new ArrayList<>();
        for(int i = 0;i<allads.size();i++){
            if(allads.get(i).getCategory().equals("training")){
                trainingads.add(allads.get(i));

            }
        }
        trainingadsRecyclerView = view.findViewById(R.id.training_recycler_view);
        trainingadsRecyclerAdapter = new trainingAdapter(getContext(),trainingads);
        trainingadsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        trainingadsRecyclerView.setAdapter(trainingadsRecyclerAdapter);

    }
}
