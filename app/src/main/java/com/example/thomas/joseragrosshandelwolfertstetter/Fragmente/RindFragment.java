package com.example.thomas.joseragrosshandelwolfertstetter.Fragmente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.thomas.joseragrosshandelwolfertstetter.*;

public class RindFragment extends Fragment {

    public RindFragment() {
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

        View view = inflater.inflate(R.layout.fragment_rind, container, false);

        Button buttonProSpezial = (Button) view.findViewById(R.id.button_pro_spezial);
        buttonProSpezial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                oeffneProSpezial();
            }
        });

        Button buttonFrumiPlus = (Button) view.findViewById(R.id.button_frumi_plus);
        buttonFrumiPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                oeffneFrumiPlus();
            }
        });

        return view;
    }

    private void oeffneProSpezial()
    {
        Intent intent = new Intent(getActivity(), pro_spezial.class);
        startActivity(intent);
    }

    private void oeffneFrumiPlus()
    {
        Intent intent = new Intent(getActivity(), frumi_plus.class);
        startActivity(intent);
    }
}
