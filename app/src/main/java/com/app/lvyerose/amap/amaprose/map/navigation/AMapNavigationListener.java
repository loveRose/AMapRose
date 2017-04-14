package com.app.lvyerose.amap.amaprose.map.navigation;

import android.util.Log;

import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.autonavi.tbt.TrafficFacilityInfo;

/************************************************************************
 *                    .::::.                                            *
 *                  .::::::::.                                          *
 *                 :::::::::::  FUCK YOU                                *
 *             ..:::::::::::'                                           *
 *           '::::::::::::'                                             *
 *             .::::::::::                                              *
 *        '::::::::::::::..                                             *
 *             ..::::::::::::.                                          *
 *           ``::::::::::::::::                                         *
 *            ::::``:::::::::'        .:::.                             *
 *           ::::'   ':::::'       .::::::::.                           *
 *         .::::'      ::::     .:::::::'::::.                          *
 *        .:::'       :::::  .:::::::::' ':::::.                        *
 *       .::'        :::::.:::::::::'      ':::::.                      *
 *      .::'         ::::::::::::::'         ``::::.                    *
 *  ...:::           ::::::::::::'              ``::.                   *
 * ```` ':.          ':::::::::'                  ::::..                *
 *                    '.:::::'                    ':'````..             *
 *              ━━━━━━━━━━━━━━━━━━━━━                                   *
 ************************************************************************
 *
 * 项目名称：AMapRose
 * 类描述： 导航对外控制类接口实现
 * 创建人：lvyerose
 * 邮箱：lvyerose@163.com
 * 创建时间：17/4/14
 *
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 *  ......
 */
public class AMapNavigationListener implements AMapNaviListener {
    @Override
    public void onInitNaviFailure() {
        Log.e("lvyerose:", "onInitNaviFailure");
    }

    @Override
    public void onInitNaviSuccess() {
        Log.e("lvyerose:", "onInitNaviSuccess");

    }

    @Override
    public void onStartNavi(int i) {
        Log.e("lvyerose:", "onStartNavi-i=" + i);

    }

    @Override
    public void onTrafficStatusUpdate() {
        Log.e("lvyerose:", "onTrafficStatusUpdate");

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        Log.e("lvyerose:", "onLocationChange");

    }

    @Override
    public void onGetNavigationText(int i, String s) {
        Log.e("lvyerose:", "onGetNavigationText");

    }

    @Override
    public void onEndEmulatorNavi() {
        Log.e("lvyerose:", "onEndEmulatorNavi");

    }

    @Override
    public void onArriveDestination() {
        Log.e("lvyerose:", "onArriveDestination");

    }

    @Override
    public void onCalculateRouteSuccess() {
        Log.e("lvyerose:", "onCalculateRouteSuccess");

    }

    @Override
    public void onCalculateRouteFailure(int i) {
        Log.e("lvyerose:", "onCalculateRouteFailure-i=" + i);

    }

    @Override
    public void onReCalculateRouteForYaw() {
        Log.e("lvyerose:", "onReCalculateRouteForYaw");

    }

    @Override
    public void onReCalculateRouteForTrafficJam() {
        Log.e("lvyerose:", "onReCalculateRouteForTrafficJam");

    }

    @Override
    public void onArrivedWayPoint(int i) {
        Log.e("lvyerose:", "onArrivedWayPoint");

    }

    @Override
    public void onGpsOpenStatus(boolean b) {
        Log.e("lvyerose:", "onGpsOpenStatus");

    }

    @Override
    public void onNaviInfoUpdate(NaviInfo naviInfo) {
        Log.e("lvyerose:", "onNaviInfoUpdate");

    }

    @Override
    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
        Log.e("lvyerose:", "onNaviInfoUpdated");

    }

    @Override
    public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {
        Log.e("lvyerose:", "updateCameraInfo");

    }

    @Override
    public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {
        Log.e("lvyerose:", "onServiceAreaUpdate");

    }

    @Override
    public void showCross(AMapNaviCross aMapNaviCross) {
        Log.e("lvyerose:", "showCross");

    }

    @Override
    public void hideCross() {
        Log.e("lvyerose:", "hideCross");

    }

    @Override
    public void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {
        Log.e("lvyerose:", "showLaneInfo");

    }

    @Override
    public void hideLaneInfo() {
        Log.e("lvyerose:", "hideLaneInfo");

    }

    @Override
    public void onCalculateMultipleRoutesSuccess(int[] ints) {
        Log.e("lvyerose:", "onCalculateMultipleRoutesSuccess");

    }

    @Override
    public void notifyParallelRoad(int i) {
        Log.e("lvyerose:", "notifyParallelRoad");

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
        Log.e("lvyerose:", "OnUpdateTrafficFacility");

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {
        Log.e("lvyerose:", "OnUpdateTrafficFacility");

    }

    @Override
    public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
        Log.e("lvyerose:", "OnUpdateTrafficFacility");

    }

    @Override
    public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
        Log.e("lvyerose:", "updateAimlessModeStatistics");

    }

    @Override
    public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
        Log.e("lvyerose:", "updateAimlessModeCongestionInfo");

    }

    @Override
    public void onPlayRing(int i) {
        Log.e("lvyerose:", "onPlayRing");

    }
}
