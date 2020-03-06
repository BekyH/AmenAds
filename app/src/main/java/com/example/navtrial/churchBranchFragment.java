package com.example.navtrial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navtrial.data.church;
import com.example.navtrial.webService.GetChurchService;
import com.example.navtrial.webService.ServiceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;

public class churchBranchFragment extends Fragment {


    ArrayList<String> branchchurches;
    List<church> mch;
    View view;
    public RecyclerView BranchchurchRecyclerView;
    public RecyclerView.Adapter BranchchurchRecyclerAdapter;
    public churchBranchFragment(List<church>mch){
        this.mch = mch;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.churchbranchfragment,container,false);
        BranchchurchRecyclerView= view.findViewById(R.id.church_branch_recycler_view);


        BranchchurchRecyclerAdapter = new churchBranchAdapter(getContext(),this.mch);
        // churchRecyclerAdapter = new ChurchAdapter(getContext(),mch);
        BranchchurchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        BranchchurchRecyclerView.setAdapter(BranchchurchRecyclerAdapter);

        return view;
    }


}
