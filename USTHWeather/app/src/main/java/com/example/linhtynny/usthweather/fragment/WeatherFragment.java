package com.example.linhtynny.usthweather.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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

public class WeatherFragment extends Fragment {
    public WeatherFragment() {
        super();
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
////        LinearLayout ll =  new LinearLayout(getContext());
//        ll.setOrientation(LinearLayout.VERTICAL );
//
//        TextView tv1 = new TextView(getContext());
//        tv1.setText("12oC \n Sunshine");
//
//        TextView tv2 = new TextView(getContext());
//        tv2.setText("Paris");
//
//        ImageView iv = new ImageView(getContext());
//        iv.setImageResource(R.drawable.sunshine);
//
//        ll.addView(tv1);
//        ll.addView(tv2);
//        ll.addView(iv);
//        ll.setBackgroundColor(0x20FF0000);
//
//        return ll;}


        @RequiresApi(api = Build.VERSION_CODES.M)
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = new View(getContext());
            v = inflater.inflate(R.layout.fragment_weather, container, false);
//            v.setBackgroundColor(0x20FF0000);
            return v;
        }
    }


