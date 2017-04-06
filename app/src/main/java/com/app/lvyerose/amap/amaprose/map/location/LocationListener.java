package com.app.lvyerose.amap.amaprose.map.location;

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
 * 类描述：  外部监听回调总体接口 包含回调所有功能
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
public interface LocationListener {
    void onError(int errorCode, String errorInfo);

    void onLocationType(int locationType);//获取当前定位结果来源，如网络定位结果，详见定位类型表

    void onLocationDetail(String locationDetail);//定位描叙信息
//
//    void onLatitude(double lat);//获取纬度
//
//    void onLongitude(double lon);//获取经度
    void onLatLng(double lat,double lng);//获取经纬度

    void onAccuracy(float acc);//获取精度信息

    void onAddress(String address);//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。

    void onCountry(String country);//国家信息

    void onProvince(String province);//省信息

    void onCity(String city);//城市信息

    void onDistrict(String district);//城区信息

    void onStreet(String street);//街道信息

    void onStreetNum(String streetNum);//街道门牌号信息

    void onCityCode(String cityCode);//城市编码

    void onAdCode(String adCode);//地区编码

    void onPoiName(String poiName);//获取当前定位点的POI信息

    void onAoiName(String aoiName);//获取当前定位点的AOI信息

    void onAltitude(double altitude); //获取海拔

    void onSpeed(float altitude); //获取 速度 米/秒

    void onBearing(float altitude); //获取当前 方向角

    void onBuildingId(String buildingId);//获取当前室内定位的建筑物Id

    void onFloor(String floor);//获取当前室内定位的楼层

    void onLocationTime(String time);    //获取定位时间


}
