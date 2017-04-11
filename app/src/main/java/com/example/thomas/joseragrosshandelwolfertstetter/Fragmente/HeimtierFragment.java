package com.example.thomas.joseragrosshandelwolfertstetter.Fragmente;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.joseragrosshandelwolfertstetter.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeimtierFragment extends Fragment {


    public HeimtierFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heimtier, container, false);
    }

}
