package com.example.navtrial;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navtrial.data.event;

import org.json.JSONArray;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdsListFragment extends Fragment {

    View view;
    private RecyclerView adsRecyclerView;
    private RecyclerView.Adapter adsRecyclerAdapter;
   public ArrayList<event> Adslist;
    private JSONArray jsonArray;
    String url = "http://192.168.17.1:3000/ads";
    private Context context;
    public AdsListFragment(Context context, ArrayList<event> Adslist) {
        this.Adslist=Adslist;
        this.context=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ads_list_fragment, container, false);
        adsRecyclerView = view.findViewById(R.id.ads_recycler_view);
//        adsRecyclerView.setHasFixedSize(true);
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Adslist = new ArrayList<>();
      for(int i = 0;i<5;i++){
          event myad = new event("denk stota","mkc","november","addis","musica","Concert");
            Adslist.add(myad);

      }
        adsRecyclerAdapter = new adsAdapter(getContext(), Adslist);
        adsRecyclerView.setAdapter(adsRecyclerAdapter);
       // getApiData();
return view;

    }
}
