package com.app.lvyerose.amap.amaprose.map.location;

import android.content.Context;

import com.amap.api.location.AMapLocationClientOption;

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
 * 类描述： 定位参数设置组装类
 * 创建人：lvyerose
 * 邮箱：lvyerose@163.com
 * 创建时间：17/4/6
 *
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 *  ......
 */
public class LocationBuilder {
    public AMapLocationClientOption buildLocationOption = null;

    public LocationBuilder() {
        buildLocationOption = new AMapLocationClientOption();
        //获取一次定位结果：
        // 该方法默认为false。
        buildLocationOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        // 设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        buildLocationOption.setOnceLocationLatest(true);
    }

    /**
     * 设置定位模式
     *
     * @param mode AMapLocationMode.Hight_Accuracy，高精度模式
     *             AMapLocationMode.Battery_Saving，低功耗模式。
     *             AMapLocationMode.Device_Sensors，仅设备模式。
     * @return
     */
    public LocationBuilder setLocationMode(AMapLocationClientOption.AMapLocationMode mode) {
        buildLocationOption.setLocationMode(mode);
        return this;
    }

    /**
     * 自定义连续定位
     *
     * @param time 时间间隔 默认为2000ms   范围不低于1000ms
     * @return
     */
    public LocationBuilder setInterval(long time) {
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        buildLocationOption.setInterval(time);
        return this;
    }

    /**
     * 设置是否返回地址信息
     *
     * @param needAddress 默认返回
     * @return
     */
    public LocationBuilder setNeedAddress(boolean needAddress) {
        //设置是否返回地址信息（默认返回地址信息）
        buildLocationOption.setNeedAddress(needAddress);
        return this;
    }

    /**
     * 设置是否强制刷新WIFI，默认为强制刷新。每次定位主动刷新WIFI模块会提升WIFI定位精度，但相应的会多付出一些电量消耗。
     *
     * @param wifiScan 默认 true
     * @return
     */
    public LocationBuilder setWifiActiveScan(boolean wifiScan) {
        //设置是否强制刷新WIFI，默认为true，强制刷新。
        buildLocationOption.setWifiActiveScan(wifiScan);
        return this;
    }

    /**
     * 设置定位请求超时时间，默认为30秒。
     * 注意：自 V3.1.0 版本之后setHttpTimeOut(long httpTimeOut)方法不仅会限制低功耗定位、高精度定位两种模式的定位超时时间，
     * 同样会作用在仅设备定位时。
     * 如果单次定位发生超时情况，定位随即终止；
     * 连续定位状态下当前这一次定位会返回超时，但按照既定周期的定位请求会继续发起。
     *
     * @param timeOut 默认30000毫秒，建议超时时间不要低于8000毫秒
     * @return
     */
    public LocationBuilder setHttpTimeOut(long timeOut) {
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        buildLocationOption.setHttpTimeOut(timeOut);
        return this;
    }

    /**
     * 设置是否开启定位缓存机制
     * 缓存机制默认开启，可以通过以下接口进行关闭。
     * 当开启定位缓存功能，在高精度模式和低功耗模式下进行的网络定位结果均会生成本地缓存，不区分单次定位还是连续定位。GPS定位结果不会被缓存。
     *
     * @param cacheEnable 缓存机制默认开启
     * @return
     */
    public LocationBuilder setLocationCacheEnable(boolean cacheEnable) {
        //关闭缓存机制
        buildLocationOption.setLocationCacheEnable(cacheEnable);
        return this;
    }

    public LocationUtils build(Context c) {
        LocationUtils locationUtils = new LocationUtils(c);
        locationUtils.setLocationOption(buildLocationOption);
        return locationUtils;
    }

}
