package com.example.weatherwithkotlin.db.bean;

import com.example.weatherwithkotlin.db.gen.CityBeanDao;
import com.example.weatherwithkotlin.utils.greendaoUtils.DBManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：
 * 最后修改：
 */

public class CityBeanManager {
    private static CityBeanDao cityBeanDao;


    private static CityBeanDao getCityBeanDao() {
        if (cityBeanDao == null) {
            cityBeanDao = DBManager.getInstance().getDaoSession().getCityBeanDao();
        }
        return cityBeanDao;
    }


    /**
     * 添加城市
     *
     * @param mCityBean
     */
    public static void addCity(CityBean mCityBean) {
        CityBeanDao cityBeanDao = getCityBeanDao();
        cityBeanDao.insert(mCityBean);
    }

    /**
     * 修改定位城市
     * 如果没有定位城市，就添加。如果有了之前的定位城市，就修改
     *
     * @param cityName
     */
    public static void addLoactionCity(String cityName) {
        CityBeanDao cityBeanDao = getCityBeanDao();
        //0:定位城市  1：添加城市
        CityBean unique = cityBeanDao.queryBuilder().where(CityBeanDao.Properties.Sign.eq(0)).unique();
        if (unique == null) {
            cityBeanDao.insert(new CityBean(null, cityName, 0));
        } else {
            if (!unique.CityName.endsWith(cityName)) {
                unique.setCityName(cityName);
                cityBeanDao.update(unique);
            }
        }
    }

    /**
     * 查询所有城市（不包括定位城市）
     */
    public static ArrayList<CityBean> queryAllCity() {
        ArrayList<CityBean> mList = new ArrayList<>();
        CityBeanDao cityBeanDao = getCityBeanDao();
        List<CityBean> cityBeans =  cityBeanDao.queryBuilder().where(CityBeanDao.Properties.Sign.eq(1)).list();
        if (cityBeans != null) {
            mList.clear();
            mList.addAll(cityBeans);
        }
        return mList;
    }


    /**
     * 查询定位城市
     *
     * @return
     */
    public static CityBean queryLocationCity() {
        CityBeanDao cityBeanDao = getCityBeanDao();
        //0:定位城市  1：添加城市
        CityBean unique = cityBeanDao.queryBuilder().where(CityBeanDao.Properties.Sign.eq(0)).unique();
        return unique;
    }


}
