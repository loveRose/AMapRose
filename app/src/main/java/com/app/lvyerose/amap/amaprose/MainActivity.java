package com.app.lvyerose.amap.amaprose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.amap.api.location.AMapLocationClientOption;
import com.app.lvyerose.amap.amaprose.map.location.LocationBuilder;
import com.app.lvyerose.amap.amaprose.map.location.LocationUtils;
import com.app.lvyerose.amap.amaprose.map.location.PartLocationListener;

public class MainActivity extends AppCompatActivity {
    private LocationUtils locationUtils;

    TextView locationShowTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationShowTv = (TextView) findViewById(R.id.location_tv);
        start();

    }

    public void start() {
        locationUtils = new LocationBuilder()
                .setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
                .setNeedAddress(true)
                .build(getApplication());
        locationUtils.setLocationListener(new PartLocationListener() {
            @Override
            public void onError(int errorCode, String errorInfo) {
                super.onError(errorCode, errorInfo);
            }

            @Override
            public void onAddress(String address) {
                super.onAddress(address);
                locationShowTv.setText(address);
            }

            @Override
            public void onLatLng(double lat, double lng) {
                super.onLatLng(lat, lng);
            }

            @Override
            public void onLatitude(double lat) {
                super.onLatitude(lat);
            }

            @Override
            public void onLongitude(double lon) {
                super.onLongitude(lon);
            }
        });
        locationUtils.start();
    }


    @Override
    protected void onDestroy() {
        locationUtils.onDestroy();
        super.onDestroy();
    }
}
