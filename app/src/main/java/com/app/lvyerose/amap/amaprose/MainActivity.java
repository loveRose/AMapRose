package com.app.lvyerose.amap.amaprose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.location.AMapLocationClientOption;
import com.app.lvyerose.amap.amaprose.map.location.LocationBuilder;
import com.app.lvyerose.amap.amaprose.map.location.LocationUtils;
import com.app.lvyerose.amap.amaprose.map.location.PartLocationLisenter;

public class MainActivity extends AppCompatActivity {
    private LocationUtils locationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }

    public void start() {
        locationUtils = new LocationBuilder()
                .setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
                .setNeedAddress(true)
                .build(getApplication());
        locationUtils.setLocationListener(new PartLocationLisenter() {
            @Override
            public void onError(int errorCode, String errorInfo) {
                super.onError(errorCode, errorInfo);
            }

            @Override
            public void onAddress(String address) {
                super.onAddress(address);

            }

            @Override
            public void onLocationDetail(String locationDetail) {
                super.onLocationDetail(locationDetail);

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
