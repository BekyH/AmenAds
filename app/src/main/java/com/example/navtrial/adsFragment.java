package com.example.navtrial;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.navtrial.Repository.AdsRepository;
import com.example.navtrial.data.event;
//import com.example.navtrial.viewModel.adsViewmodel;
import com.example.navtrial.webService.GetAdsService;
import com.example.navtrial.webService.ServiceBuilder;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;


public class adsFragment extends Fragment    {
    ProgressDialog progressDialog;
    View view;
    private RecyclerView adsRecyclerView;
    private RecyclerView.Adapter adsRecyclerAdapter;
    //private adsViewmodel eventViewmodel;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_fragment, container, false);

//            eventViewmodel = ViewModelProviders.of(getActivity()).get(adsViewmodel.class);
//           eventViewmodel.init();
//            eventViewmodel.getNevents().observe(getActivity(), new Observer<List<event>>() {
//                @Override
//                public void onChanged(List<event> eventList) {
//                    adsRecyclerAdapter.notifyDataSetChanged();
//                }
//            });
//            initRecycler();
  //      eventViewmodel = ViewModelProviders.of(this).get(adsViewmodel.class);
//        eventViewmodel.init();
//
//        eventViewmodel.getNevents().observe(this, new Observer<List<event>>() {
//            @Override
//            public void onChanged(@Nullable List<event> eventList) {
//                adsRecyclerAdapter.notifyDataSetChanged();
//
//            }
//        });
//        initRecyclerView();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        GetAdsService service = ServiceBuilder.getRetrofitInstance().create(GetAdsService.class);
        Call<List<event>> call = service.getAllAds();
        call.enqueue(new Callback<List<event>>() {
            @Override
            public void onResponse(Call<List<event>> call, retrofit2.Response<List<event>> response) {
                progressDialog.dismiss();

                if(response.isSuccessful()){
                    generateDatalist(response.body());
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



    public void generateDatalist(List<event> eventList){
       // AdsRepository adsRepository = AdsRepository.getInstance();
        adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
        adsRecyclerAdapter = new adsAdapter(getContext(), eventList);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adsRecyclerView.setAdapter(adsRecyclerAdapter);


    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//    }

//    private void initRecycler(){
//    adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
//    adsRecyclerAdapter = new adsAdapter(getActivity(), eventViewmodel.getNevents().getValue());
//    adsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//
//    adsRecyclerView.setAdapter(adsRecyclerAdapter);
//
//
//       // alertDialog.setMessage(" please try again!!");
//
}









