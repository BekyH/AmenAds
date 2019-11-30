package com.example.navtrial;

import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.core.app.Fragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class churchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.church_fragment,container,false);
        return view;
    }
}
