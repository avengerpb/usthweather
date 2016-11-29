package com.example.linhtynny.usthweather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.linhtynny.usthweather.fragment.WeatherAndForecastFragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static android.R.id.content;
import static java.lang.Thread.sleep;

public class WeatherActivity extends AppCompatActivity {
    MediaPlayer mp;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());

        ViewPager pager = (ViewPager) findViewById(R.id.container1);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);


        TabLayout tableLayout = (TabLayout) findViewById(R.id.container);
        tableLayout.setupWithViewPager(pager);

        Log.i("log1", "This is log from onCreate()");


        mp = MediaPlayer.create(this, R.raw.tl);
        mp.start();

//        File f =new File(Environment.getExternalStorageDirectory(),"music.mp3");
//
//        InputStream in = getResources().openRawResource(R.raw.tl);
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(f);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        byte[] buff = new byte[1024];
//        int read = 0;
//
//        try {
//            while ((read = in.read(buff)) > 0) {
//                out.write(buff, 0, read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        mp = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "music.mp3"));
//        mp.setLooping(true);
//        mp.start();

        //Create a new Fragment to be placed in the activity layout
//        WeatherFragment weatherFragment = new WeatherFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.activity_weather, weatherFragment).commit();

//        ForecastFragment firstFragment = new ForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.activity_weather, firstFragment).commit();

//        ForecastFragment2 secondFragment = new ForecastFragment2();
//        getSupportFragmentManager().beginTransaction().add(R.id.activity_weather, secondFragment).commit();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final URL temp;
        final HttpURLConnection tempurl;
        final InputStream tempis;
        switch (item.getItemId()) {
            case R.id.refresh:

                AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
                    URL url = null;
                    HttpURLConnection connection = null;
                    InputStream is = null;
                    @Override
                    protected void onPreExecute() {

                        try {
                            url = new URL("http://ict.usth.edu.vn/wp-content/uploads/usth/usthlogo.png");
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                        // do some preparation here, if needed
                    }
                    @Override
                    protected Bitmap doInBackground(String... params) {
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        return null;

                        try {
                            connection = (HttpURLConnection) url.openConnection();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            connection.setRequestMethod("GET");
                        } catch (ProtocolException e) {
                            e.printStackTrace();
                        }
                        connection.setDoInput(true);

                        int response = 0;
                        try {
                            response = connection.getResponseCode();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Log.i("USTHWeather", "The response is: " + response);
                        try {
                            is = connection.getInputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return BitmapFactory.decodeStream(is);

                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
// This method is called in the main thread, so it's possible
// to update UI to reflect the worker thread progress here.
// In a network access task, this should update a progress bar
// to reflect how many percent of data has been retrieved

                    }
                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
// This method is called in the main thread. After #doInBackground returns
// the bitmap data, we simply set it to an ImageView using ImageView.setImageBitmap()

                        ImageView logo = (ImageView) findViewById(R.id.logo);
                        logo.setImageBitmap(bitmap);
                        connection.disconnect();
//                        String content = "ALO";
//                        int duration = Toast.LENGTH_SHORT;
//                        Toast toast = Toast.makeText(WeatherActivity.this, content, duration);
//                        toast.show();
                    }

                };
                task.execute("http://ict.usth.edu.vn/wp-content/uploads/usth/usthlogo.png");

                return true;
            case  R.id.add:
                return true;
            default:
                super.onOptionsItemSelected(item);
                return true;
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("log1", "This is log from onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
        Log.i("log1", "This is log from onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
        Log.i("log1", "This is log from onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("log1", "This is log from onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("log1", "This is log from onDestroy()");

    }

//    class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
//        private final int PAGE_COUNT = 3;
//        private String location[] = new String[] { "Hanoi", "Paris", "Toulouse" };
//        public HomeFragmentPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//        @Override
//        public int getCount() {
//            return (location.length); // number of pages for a ViewPager
//        }
//        @Override
//        public Fragment getItem(int page) {
//// returns an instance of Fragment corresponding to the specified page
////        switch (page) {
////            case 0: return Fragment1.newInstance();
////            case 1: return Fragment2.newInstance();
////            case 2: return Fragment3.newInstance();
////        }
//            return new Fragment(); // failsafe
//        }
//        @Override
//        public CharSequence getPageTitle(int page) {
//// returns a tab title corresponding to the specified page
//            return location[page];
//        }

    class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String location[] = new String[]{"Hanoi", "Paris", "Toulouse"};

        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return (location.length); // number of pages for a ViewPager
        }

        @Override
        public Fragment getItem(int page) {
            return new WeatherAndForecastFragment();
        }

        @Override
        public CharSequence getPageTitle(int page) {
            // returns a tab title corresponding to the specified page
            return location[page];
        }
    }



}
