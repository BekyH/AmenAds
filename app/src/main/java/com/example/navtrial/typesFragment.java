package com.example.navtrial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navtrial.data.event;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class typesFragment extends Fragment {

    View view;
    private RecyclerView typesRecyclerView;
    private RecyclerView.Adapter typesRecyclerAdapter;
    private List<String> types;

    public typesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.types_fragment,container,false);
        typesRecyclerView = view.findViewById(R.id.types_recycler_view);
        typesRecyclerView.setHasFixedSize(true);
        typesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        types = new ArrayList<>();
        types.add("Concert");
        types.add("Worship Night");
        types.add("Festivals");
        types.add("Confrance");
        types.add("Traning");
        typesRecyclerAdapter = new typesAdapter(getContext(),types,new typesAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(String item) {
                FragmentTransaction transection=getFragmentManager().beginTransaction();
             if(item=="Concert"){

                 AdsListFragment bf = new AdsListFragment(getContext(),concertAds);
                 Bundle bundle=new Bundle();
                 bundle.putSerializable("church", item);
//                    bf.setArguments(bundle); //data being send to SecondFragment
                 transection.replace(R.id.containers, bf);
                 transection.commit();
             }
             else if(item=="Worship Night"){
                 AdsListFragment bf = new AdsListFragment(getContext(),worshipNightAds);
                 Bundle bundle=new Bundle();
                 bundle.putSerializable("church", item);
//                    bf.setArguments(bundle); //data being send to SecondFragment
                 transection.replace(R.id.containers, bf);
                 transection.commit();
             }
             else if(item=="Festival"){
                 AdsListFragment bf = new AdsListFragment(getContext(),festivalsAds);
                 Bundle bundle=new Bundle();
                 bundle.putSerializable("church", item);
//                    bf.setArguments(bundle); //data being send to SecondFragment
                 transection.replace(R.id.containers, bf);
                 transection.commit();
             }
             else if(item=="Confrance"){
                 AdsListFragment bf = new AdsListFragment(getContext(),confranceAds);
                 Bundle bundle=new Bundle();
                 bundle.putSerializable("church", item);
//                    bf.setArguments(bundle); //data being send to SecondFragment
                 transection.replace(R.id.containers, bf);
                 transection.commit();
             }

            else if(item=="Traning"){
                 AdsListFragment bf = new AdsListFragment(getContext(),traningAds);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("church", item);
//                    bf.setArguments(bundle); //data being send to SecondFragment
                    transection.replace(R.id.containers, bf);
                    transection.commit();
                }
            else{
                 AdsListFragment bf = new AdsListFragment(getContext(),concertAds);
                 Bundle bundle=new Bundle();
                 bundle.putSerializable("church", item);
//                    bf.setArguments(bundle); //data being send to SecondFragment
                 transection.replace(R.id.containers, bf);
                 transection.commit();
             }
            }
        });
        typesRecyclerView.setAdapter(typesRecyclerAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    ArrayList<event> concertAds;
    ArrayList<event> worshipNightAds;
    ArrayList<event> festivalsAds;
    ArrayList<event> confranceAds;
    ArrayList<event> traningAds;
public void CreateAds(ArrayList<event> ads){

        for(event a :ads){
            if(a.getCategory()=="Concert"){
                concertAds.add(a);
            }
            else if(a.getCategory()=="Worship Night"){
                worshipNightAds.add(a);
            }
            else if(a.getCategory()=="Festivals"){
                festivalsAds.add(a);
            }
            else if(a.getCategory()=="Confrance"){
                confranceAds.add(a);
            }
            else if(a.getCategory()=="Traning"){
                traningAds.add(a);
            }

        }

}


}
