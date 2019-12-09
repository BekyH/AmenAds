package com.example.navtrial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adsFragment extends Fragment {

    View view;
    private RecyclerView adsRecyclerView;
    private RecyclerView.Adapter adsRecyclerAdapter;
    private List<Ads> Adslist;

    public adsFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_fragment,container,false);
        adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
//        adsRecyclerView.setHasFixedSize(true);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Adslist = new ArrayList<>();
        for(int i = 0;i<20;i++){
            Ads myad = new Ads("denk stota","mkc","november","addis");
            Adslist.add(myad);

        }
        adsRecyclerAdapter = new adsAdapter(getContext(),Adslist);
        adsRecyclerView.setAdapter(adsRecyclerAdapter);



        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
