package com.app.lvyerose.amap.amaprose;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.app.lvyerose.amap.amaprose.map.location.LocationBuilder;
import com.app.lvyerose.amap.amaprose.map.location.LocationUtils;
import com.app.lvyerose.amap.amaprose.map.location.PartLocationListener;

public class MainActivity extends Activity {
    TextView locationShowTv;

    LocationUtils locationUtils; //地图定位工具
    MapView mapView; //地图渲染 View
    AMap aMap; // 地图控制类
    UiSettings mUiSettings;//定义一个UiSettings对象 地图控件对象设置类

    //小汽车1的坐标位置
    double car1Lat = 39.906901;
    double car1Lng = 116.397972;

    //小汽车2的坐标位置
    double car2Lat = 39.966141;
    double car2Lng = 116.308998;

    //当前定位所得位置坐标
    double locationLat;
    double locationLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        startLocation();
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        initShowMap();
        drawCar1Point();
        drawCar2Point();
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
                locationLat = lat;
                locationLng = lng;
            }
        });
        locationUtils.start();
    }

    public void initShowMap() {
        aMap = mapView.getMap();
        aMap.setTrafficEnabled(true);// 显示实时交通状况
        //地图模式可选类型：MAP_TYPE_NORMAL,MAP_TYPE_SATELLITE,MAP_TYPE_NIGHT
        aMap.setMapType(AMap.MAP_TYPE_BUS);
        aMap.setTrafficEnabled(true);//显示实时路况图层，aMap是地图控制器对象。
        aMap.showIndoorMap(true);     //true：显示室内地图；false：不显示；

        //控制当前显示缩放大小为 50m   范围 3-21
        CameraUpdate mCameraUpdate = CameraUpdateFactory.zoomTo(17);
        aMap.animateCamera(mCameraUpdate);

        showLocationStyle();
        initUIMap();
    }

    public void initUIMap() {
        mUiSettings = aMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(false); //  设置是否显示缩放按钮
        mUiSettings.setCompassEnabled(false); //设置是否显示 指南针
        mUiSettings.setScaleControlsEnabled(true);//控制比例尺控件是否显示

    }

    //显示定位蓝点
    public void showLocationStyle() {
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_SHOW);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
//        myLocationStyle.myLocationIcon();
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
    }

    public void drawCar1Point() {
        LatLng latLng = new LatLng(car1Lat, car1Lng);
        final Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("最屌").snippet("干点我"));
    }

    public void drawCar2Point() {
        LatLng latLng = new LatLng(car2Lat, car2Lng);
        MarkerOptions markerOption = new MarkerOptions().position(latLng).title("最屌").snippet("干点我");
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(), R.mipmap.car_log_md)));
        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
        markerOption.setFlat(true);//设置marker平贴地图效果
        final Marker marker = aMap.addMarker(markerOption);
    }


    public void carOnClick(View view) {
        double navigationLat = 0;
        double navigationLng = 0;
        switch (view.getId()) {
            case R.id.car_1_btn:
                navigationLat = car1Lat;
                navigationLng = car1Lng;
                break;
            case R.id.car_2_btn:
                navigationLat = car2Lat;
                navigationLng = car2Lng;
                break;
        }
        NavigationActivity.startNavigationActivity(MainActivity.this, locationLat, locationLng, navigationLat, navigationLng);
    }


    /**
     * activity life about map
     */
    @Override
    protected void onDestroy() {
        locationUtils.onDestroy();
        super.onDestroy();
    }
}
