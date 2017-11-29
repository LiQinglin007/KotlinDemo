package com.example.weatherwithkotlin.db.bean;

import com.example.weatherwithkotlin.db.gen.WeatherNowDataBeanDao;
import com.example.weatherwithkotlin.utils.greendaoUtils.DBManager;

import java.util.Date;
import java.util.List;


/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/29
 * 内容：
 * 最后修改：
 */

public class WeatherNowDataBeanManager {
    private static WeatherNowDataBeanDao weatherNowDataBeanDao;


    private static WeatherNowDataBeanDao getCityBeanDao() {
        if (weatherNowDataBeanDao == null) {
            weatherNowDataBeanDao = DBManager.getInstance().getDaoSession().getWeatherNowDataBeanDao();
        }
        return weatherNowDataBeanDao;
    }


    /**
     * 添加或者修改一个城市的信息
     *
     * @param mWeatherNowDataBean
     */
    public static void UpdateCityWeather(WeatherNowDataBean mWeatherNowDataBean) {
        WeatherNowDataBean unique = getCityBeanDao().queryBuilder().where(WeatherNowDataBeanDao.Properties.CityName.eq(mWeatherNowDataBean.CityName)).unique();
        if (unique == null) {
            getCityBeanDao().insert(mWeatherNowDataBean);
        } else {
            if (mWeatherNowDataBean.getHttpCode().equals("ok")) {
                unique.setHttpCode(mWeatherNowDataBean.getHttpCode());
                unique.setCloudCode(mWeatherNowDataBean.getCloudCode());
                unique.setLastTime(new Date().getTime());
                unique.setUpdateTime(mWeatherNowDataBean.getUpdateTime());
                unique.setCloudTxt(mWeatherNowDataBean.getCloudTxt());
                unique.setFl(mWeatherNowDataBean.getFl());
                unique.setHum(mWeatherNowDataBean.getHum());
                unique.setPcpn(mWeatherNowDataBean.getPcpn());
                unique.setTmp(mWeatherNowDataBean.getTmp());
                unique.setWindDir(mWeatherNowDataBean.getWindDir());
                unique.setWindSc(mWeatherNowDataBean.getWindSc());
                getCityBeanDao().update(unique);
            } else {
                unique.setHttpCode(mWeatherNowDataBean.getHttpCode());
                getCityBeanDao().update(unique);
            }
        }
    }


    /**
     * 查询一个城市的天气
     *
     * @param cityName
     * @return
     */
    public static WeatherNowDataBean LoadCityData(String cityName) {
        WeatherNowDataBean unique = getCityBeanDao().queryBuilder().where(WeatherNowDataBeanDao.Properties.CityName.eq(cityName)).unique();
        return unique;
    }

    public static List<WeatherNowDataBean> LoadAll() {
        return getCityBeanDao().loadAll();
    }

    /**
     * 删除一个
     *
     * @param cityName
     */
    public static void DeleteCity(String cityName) {
        WeatherNowDataBean unique = getCityBeanDao().queryBuilder().where(WeatherNowDataBeanDao.Properties.CityName.eq(cityName)).unique();
        if (unique != null) {
            getCityBeanDao().delete(unique);
        }
    }


    /**
     * 删除全部
     */
    public static void DeleteAll() {
        getCityBeanDao().deleteAll();
    }


}
