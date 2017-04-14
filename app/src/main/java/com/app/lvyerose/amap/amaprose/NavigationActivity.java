package com.app.lvyerose.amap.amaprose;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NavigationActivity extends AppCompatActivity {
    public final static String INTENT_LAT = "LAT";
    public final static String INTENT_LNG = "LNG";
    private double carLat;
    private double carLng;

    public static void startNavigationActivity(Context context, double lat, double lng) {
        Intent intent = new Intent(context, NavigationActivity.class);
        intent.putExtra(INTENT_LAT, lat);
        intent.putExtra(INTENT_LNG, lng);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        carLat = getIntent().getDoubleExtra(INTENT_LAT, 0.0);
        carLng = getIntent().getDoubleExtra(INTENT_LNG, 0.0);


    }
}
