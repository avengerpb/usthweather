package com.example.linhtynny.usthweather.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linhtynny.usthweather.R;

/**
 * Created by linhtynny on 02/11/2016.
 */

public class ForecastFragment extends Fragment {
    public ForecastFragment() {
        super();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = new View(getContext());
        v = inflater.inflate(R.layout.fragment_forecast, container, false);
//        v.setBackgroundColor(0xff0000ff);
        return v;
    }
}
