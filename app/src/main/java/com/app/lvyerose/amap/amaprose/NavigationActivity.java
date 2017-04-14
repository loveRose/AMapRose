package com.app.lvyerose.amap.amaprose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.NaviLatLng;
import com.app.lvyerose.amap.amaprose.map.navigation.AMapNavigationListener;
import com.app.lvyerose.amap.amaprose.map.navigation.AMapNavigationViewListener;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends Activity {
    public final static String INTENT_START_LAT = "S_LAT";
    public final static String INTENT_START_LNG = "S_LNG";
    public final static String INTENT_END_LAT = "E_LAT";
    public final static String INTENT_END_LNG = "E_LNG";
    private double carLat;
    private double carLng;
    private double sLat;
    private double sLng;
    private List<NaviLatLng> startPoints;
    private List<NaviLatLng> endPoints;

    AMapNaviView mAMapNavigationView;
    AMapNavi mAMapNavigation;

    public static void startNavigationActivity(Activity context, double sLat, double sLng, double eLat, double eLng) {
        Intent intent = new Intent(context, NavigationActivity.class);
        intent.putExtra(INTENT_START_LAT, sLat);
        intent.putExtra(INTENT_START_LNG, sLng);

        intent.putExtra(INTENT_END_LAT, eLat);
        intent.putExtra(INTENT_END_LNG, eLng);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initView();
        mAMapNavigationView.onCreate(savedInstanceState);
        initNavigationData();
    }

    /**
     * 开始导航
     */
    private void startNavigation() {
        mAMapNavigation.startNavi(NaviType.GPS);
    }

    private void initNavigationData() {
        sLat = getIntent().getDoubleExtra(INTENT_START_LAT, 0.0);
        sLng = getIntent().getDoubleExtra(INTENT_START_LNG, 0.0);

        carLat = getIntent().getDoubleExtra(INTENT_END_LAT, 39.906901);
        carLng = getIntent().getDoubleExtra(INTENT_END_LNG, 116.397972);

        endPoints = new ArrayList<>();
        endPoints.add(new NaviLatLng(carLat, carLng));
        startPoints = new ArrayList<>();
        startPoints.add(new NaviLatLng(sLat, sLng));
        initNavigation();
    }

    private void initNavigation() {
        //实例化 算路控制器
        mAMapNavigation = AMapNavi.getInstance(this);

        mAMapNavigation.addAMapNaviListener(new AMapNavigationListener() {

            @Override
            public void onInitNaviSuccess() {
                super.onInitNaviSuccess();
                //控制器初始化成功
                /**
                 * 方法:
                 *   int strategy=mAMapNavi.strategyConvert(congestion, avoidhightspeed, cost, hightspeed, multipleroute);
                 * 参数:
                 * @congestion 躲避拥堵
                 * @avoidhightspeed 不走高速
                 * @cost 避免收费
                 * @hightspeed 高速优先
                 * @multipleroute 多路径
                 *
                 * 说明:
                 *      以上参数都是boolean类型，其中multipleroute参数表示是否多条路线，如果为true则此策略会算出多条路线。
                 * 注意:
                 *      不走高速与高速优先不能同时为true
                 *      高速优先与避免收费不能同时为true
                 */
                int strategy = 0;
                try {
                    strategy = mAMapNavigation.strategyConvert(true, false, false, false, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mAMapNavigation.calculateDriveRoute(startPoints, endPoints, endPoints, strategy);
            }

            @Override
            public void onInitNaviFailure() {
                super.onInitNaviFailure();
            }

            @Override
            public void onCalculateRouteFailure(int i) {
                super.onCalculateRouteFailure(i);
            }

            @Override
            public void onCalculateMultipleRoutesSuccess(int[] ints) {
                super.onCalculateMultipleRoutesSuccess(ints);
                //多策略--显示路径或开始导航

            }

            @Override
            public void onCalculateRouteSuccess() {
                super.onCalculateRouteSuccess();
                //单策略--显示路径或开始导航
                startNavigation();
            }
        });

    }

    private void initView() {

        //获取 AMapNaviView 实例
        mAMapNavigationView = (AMapNaviView) findViewById(R.id.navigation_view);

        mAMapNavigationView.setAMapNaviViewListener(new AMapNavigationViewListener() {
            @Override
            public void onNaviViewLoaded() {
                super.onNaviViewLoaded();

            }


        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mAMapNavigationView != null)
            mAMapNavigationView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAMapNavigationView != null)
            mAMapNavigationView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAMapNavigationView != null)
            mAMapNavigationView.onDestroy();

        if (mAMapNavigation != null) {
            mAMapNavigation.stopNavi();
            mAMapNavigation.destroy();
        }
    }

}
