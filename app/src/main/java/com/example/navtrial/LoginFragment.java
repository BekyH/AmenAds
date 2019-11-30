package com.example.navtrial;

import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import androidx.core.app.Fragment;
//import androidx.core.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LoginFragment extends Fragment {
    TextView logintextview;
    Button loginbtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        logintextview = view.findViewById(R.id.login_click_here_textview);
        loginbtn = view.findViewById(R.id.login_btn);
        logintextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFragment rf = new registerFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containers,rf)
                        .addToBackStack(null)
                        .commit();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).Navigation();
                ((MainActivity)getActivity()).mytoolbar.setVisibility(View.VISIBLE);
                adsFragment eventFragment = new adsFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containers,eventFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });
        return view;

    }

}
