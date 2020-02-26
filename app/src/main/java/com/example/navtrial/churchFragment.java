package com.example.navtrial;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.core.app.Fragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.navtrial.data.church;
import com.example.navtrial.data.event;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.GetChurchService;
import com.example.navtrial.webService.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class churchFragment extends Fragment {

    ProgressDialog progressDialog;

    ArrayList<String> mainchurches;
    List<church> mch;
    View view;
    private RecyclerView churchRecyclerView;
    private RecyclerView.Adapter churchRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.church_fragment, container, false);


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        GetChurchService churchService = new ServiceBuilder().getRetrofitInstance().create(GetChurchService.class);
        Call<List<church>> call = churchService.getChurches();
       call.enqueue(new Callback<List<church>>() {
           @Override
           public void onResponse(Call<List<church>> call, retrofit2.Response<List<church>> response) {

               if(response.isSuccessful()){
                   progressDialog.dismiss();

                   List<church> list = new ArrayList<>(new HashSet<>(response.body()));
                   mch = response.body();
                   ArrayList<String> m = new ArrayList<>();
                   for(int i =0;i<mch.size();i++){
                       m.add(mch.get(i).getMainchurch());
                   }

                  Set<String> uniqueValues = new HashSet<>(m);
                   mainchurches = new ArrayList<>(uniqueValues);
                   churchRecyclerView = view.findViewById(R.id.church_recycler_view);

                   churchRecyclerAdapter = new ChurchAdapter(getContext(),mainchurches);
                   // churchRecyclerAdapter = new ChurchAdapter(getContext(),mch);
                   churchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


                   churchRecyclerView.setAdapter(churchRecyclerAdapter);

               }
               else {
                   Toast.makeText(getContext(),"response is not succesfull",Toast.LENGTH_SHORT).show();
               }

           }

           @Override
           public void onFailure(Call<List<church>> call, Throwable t) {
               progressDialog.dismiss();
               if (t instanceof IOException) {

                   Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

               }
               else {
                   Toast.makeText(getContext(), "conversion issue! big problems", Toast.LENGTH_SHORT).show();

               }
           }
       });
        return view;
    }



}
