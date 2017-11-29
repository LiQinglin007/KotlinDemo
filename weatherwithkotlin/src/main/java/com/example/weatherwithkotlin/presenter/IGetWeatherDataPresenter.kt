package com.example.weatherwithkotlin.presenter

import com.example.weatherwithkotlin.db.bean.CityBean

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：
 * 最后修改：
 */
interface IGetWeatherDataPresenter {
    fun getData(city: ArrayList<CityBean>)
    fun getData(city: CityBean)
}