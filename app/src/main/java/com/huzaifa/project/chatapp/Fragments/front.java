package com.huzaifa.project.chatapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huzaifa.project.chatapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class front extends Fragment {


    public front() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_front,container,false);

        return view;
    }

}
