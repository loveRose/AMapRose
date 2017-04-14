package com.app.lvyerose.amap.amaprose.map.navigation;

import android.util.Log;

import com.amap.api.navi.AMapNaviViewListener;

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
 * 类描述： 导航类视图接口实现
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
public class AMapNavigationViewListener implements AMapNaviViewListener {
    @Override
    public void onNaviSetting() {
        Log.e("lvyerose-view:", "onNaviSetting");
    }

    @Override
    public void onNaviCancel() {
        Log.e("lvyerose-view:", "onNaviCancel");

    }

    @Override
    public boolean onNaviBackClick() {
        Log.e("lvyerose-view:", "onNaviBackClick");
        return false;
    }

    @Override
    public void onNaviMapMode(int i) {
        Log.e("lvyerose-view:", "onNaviMapMode");

    }

    @Override
    public void onNaviTurnClick() {
        Log.e("lvyerose-view:", "onNaviTurnClick");

    }

    @Override
    public void onNextRoadClick() {
        Log.e("lvyerose-view:", "onNextRoadClick");

    }

    @Override
    public void onScanViewButtonClick() {
        Log.e("lvyerose-view:", "onScanViewButtonClick");

    }

    @Override
    public void onLockMap(boolean b) {
        Log.e("lvyerose-view:", "onLockMap");

    }

    @Override
    public void onNaviViewLoaded() {
        Log.e("lvyerose-view:", "onNaviViewLoaded");

    }
}
