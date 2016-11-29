package com.example.linhtynny.usthweather.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linhtynny.usthweather.R;
import static com.example.linhtynny.usthweather.R.id.activity_weather;

/**
 * Created by linhtynny on 04/11/2016.
 */

public class WeatherAndForecastFragment extends Fragment {
    private static final String TAG = "WeatherForecastFrag";

    public WeatherAndForecastFragment() {

    }

    public static WeatherAndForecastFragment newInstance(String location) {
        Bundle args = new Bundle();
        args.putString("location", location);

        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        fragment.setArguments(args);


        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup activity_weather, Bundle savedInstanceStase) {
//        View v = inflater.inflate(R.layout.fragment_weather_with_forecast, null);
//        String location = "Hanoi";
//        if (getArguments() != null) {
//            location = getArguments().getString("location");
//        }
//        View v = inflater.inflate(R.layout.fragment_weather_with_forecast, activity_weather, false);
        View v = new View(getContext());
        v = inflater.inflate(R.layout.fragment_weather_with_forecast, activity_weather, false);

        return v;
    }
}

