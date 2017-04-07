package com.app.lvyerose.amap.amaprose.map.location;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import java.text.SimpleDateFormat;
import java.util.Date;

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
 * 类描述： 地图定位工具类封装
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
public class LocationUtils {
    private Context mContext;
    //声明AMapLocationClient类对象
    private AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    //AMapLocationClientOption对象用来设置发起定位的模式和相关参数。
    private AMapLocationClientOption mLocationOption = null;
    private LocationListener externalLocationListener;
    //声明定位回调监听器
    private AMapLocationListener internalLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (externalLocationListener != null) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析aMapLocation获取相应内容。
                        //定位成功
                        //返回定位类型
                        externalLocationListener.onLocationType(aMapLocation.getLocationType());
                        externalLocationListener.onLocationDetail(aMapLocation.getLocationDetail());
                        externalLocationListener.onLatLng(aMapLocation.getLatitude(),aMapLocation.getLongitude());
                        externalLocationListener.onAccuracy(aMapLocation.getAccuracy());
                        externalLocationListener.onAddress(aMapLocation.getAddress());
                        externalLocationListener.onCountry(aMapLocation.getCountry());
                        externalLocationListener.onProvince(aMapLocation.getProvince());
                        externalLocationListener.onCity(aMapLocation.getCity());
                        externalLocationListener.onDistrict(aMapLocation.getDistrict());
                        externalLocationListener.onStreet(aMapLocation.getStreet());
                        externalLocationListener.onStreetNum(aMapLocation.getStreetNum());
                        externalLocationListener.onCityCode(aMapLocation.getCityCode());
                        externalLocationListener.onAdCode(aMapLocation.getAdCode());
                        externalLocationListener.onAoiName(aMapLocation.getAoiName());
                        externalLocationListener.onPoiName(aMapLocation.getPoiName());
                        externalLocationListener.onAltitude(aMapLocation.getAltitude());
                        externalLocationListener.onSpeed(aMapLocation.getSpeed());
                        externalLocationListener.onBearing(aMapLocation.getBearing());
                        externalLocationListener.onBuildingId(aMapLocation.getBuildingId());
                        externalLocationListener.onFloor(aMapLocation.getFloor());
                        //返回时间
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = new Date(aMapLocation.getTime());
                        externalLocationListener.onLocationTime(df.format(date));
                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        externalLocationListener.onError(aMapLocation.getErrorCode(), aMapLocation.getErrorInfo());
                    }
                }
            }
        }
    };

    public LocationUtils(Context context) {
        mContext = context;
        initLocation();
    }

    public void setLocationOption(AMapLocationClientOption option) {
        this.mLocationOption = option;
    }

    public AMapLocationClientOption getLocationOption() {
        return mLocationOption;
    }

    private void initLocation() {
        //初始化定位
        mLocationClient = new AMapLocationClient(mContext);
        //设置定位回调监听
        mLocationClient.setLocationListener(internalLocationListener);
    }

    /**
     * 设置外部回调监听  用于返回获取的数据
     *
     * @param listener
     */
    public void setLocationListener(LocationListener listener) {
        externalLocationListener = listener;
    }

    /**
     * 开始定位
     */
    public void start() {
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    /**
     * 结束定位
     */
    public void stop() {
        if (mLocationClient != null && mLocationClient.isStarted())
            mLocationClient.startLocation();

    }

    /**
     * 销毁 定位客服端
     */
    public void onDestroy() {
        mLocationClient.onDestroy();
    }

}
