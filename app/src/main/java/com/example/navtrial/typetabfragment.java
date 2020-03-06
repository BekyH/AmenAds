package com.example.navtrial;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class typetabfragment extends Fragment {
    ArrayList<String> categories;
    private RecyclerView typesRecyclerview;
    private RecyclerView.Adapter typesRecyclerAdapter;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                view = inflater.inflate(R.layout.typetabfragment,container,false);
//        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                getFragmentManager().popBackStack();
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
                categories = new ArrayList<>();
               categories.add("Conference");
               categories.add("Concert");
                categories.add("Worship");
                categories.add("Training");
                categories.add("Art");

                typesRecyclerview = view.findViewById(R.id.type_tab_recycler_view);
                typesRecyclerAdapter = new typeadsAdapter(getContext(),categories);
                typesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
                typesRecyclerview.setAdapter(typesRecyclerAdapter);


                return view;
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        getView().setFocusableInTouchMode(true);
//        getView().requestFocus();
//        getView().setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
//                    if (getChildFragmentManager().getBackStackEntryCount() > 0)
//                        getChildFragmentManager().popBackStack();
//
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

}
