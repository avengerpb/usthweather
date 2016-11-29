package com.example.linhtynny.usthweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.linhtynny.usthweather.R;

/**
 * Created by linhtynny on 02/11/2016.
 */

public class ForecastFragment2 extends Fragment {

    public ForecastFragment2() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout ll =  new LinearLayout(getContext());
        ll.setOrientation(LinearLayout.VERTICAL );
        TextView tv = new TextView(getContext());
        tv.setText("Monday");

        ImageView iv = new ImageView(getContext());
        iv.setImageResource(R.drawable.halfsun);
        ll.addView(tv);
        ll.addView(iv);
        return ll;
    }


    }
