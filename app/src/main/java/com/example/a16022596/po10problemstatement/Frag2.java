package com.example.a16022596.po10problemstatement;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Frag2 extends Fragment {
    Button btnChangeBg;
    TextView tv1;
    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        btnChangeBg = (Button) view.findViewById(R.id.buttonBackground);
        tv1 = (TextView) view.findViewById(R.id.tvData1);

        btnChangeBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                tv1.setBackgroundColor(color);
            }
        });

        return view;

    }


}
