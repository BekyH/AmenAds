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

import com.example.navtrial.data.church;

import java.util.List;

public class churchDetailFragment extends Fragment {
    List<church> churchDetails;
    View view;
    public RecyclerView churchDetailRecyclerView;
    public RecyclerView.Adapter DetailchurchRecyclerAdapter;
    public churchDetailFragment(List<church>churchDetails){
        this.churchDetails = churchDetails;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.churchdetailfragment,container,false);
        churchDetailRecyclerView = view.findViewById(R.id.church_detail_recycler_view);
        DetailchurchRecyclerAdapter = new churchDetailAdapter(getContext(),this.churchDetails);
        churchDetailRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        churchDetailRecyclerView.setAdapter(DetailchurchRecyclerAdapter);

        return view;
    }
}
