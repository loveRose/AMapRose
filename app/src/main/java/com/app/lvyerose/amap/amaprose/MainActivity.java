package com.app.lvyerose.amap.amaprose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.app.lvyerose.amap.amaprose.map.location.LocationBuilder;
import com.app.lvyerose.amap.amaprose.map.location.LocationUtils;
import com.app.lvyerose.amap.amaprose.map.location.PartLocationListener;

public class MainActivity extends AppCompatActivity {
    private LocationUtils locationUtils;

    TextView locationShowTv;
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        startLocation();
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        initShowMap();
    }

    private void initView() {
        locationShowTv = (TextView) findViewById(R.id.location_result_tv);
        mapView = (MapView) findViewById(R.id.main_map_view);
    }

    //开始定位
    public void startLocation() {
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

    public void initShowMap() {
        AMap aMap = mapView.getMap();
        aMap.setTrafficEnabled(true);// 显示实时交通状况
        //地图模式可选类型：MAP_TYPE_NORMAL,MAP_TYPE_SATELLITE,MAP_TYPE_NIGHT
        aMap.setMapType(AMap.MAP_TYPE_BUS);// 卫星地图模式
    }

    @Override
    protected void onDestroy() {
        locationUtils.onDestroy();
        super.onDestroy();
    }
}
