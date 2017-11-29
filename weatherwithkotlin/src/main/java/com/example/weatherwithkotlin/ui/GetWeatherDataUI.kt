package com.example.weatherwithkotlin.ui

import com.example.weatherwithkotlin.db.bean.WeatherNowDataBean

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：
 * 最后修改：
 */
interface GetWeatherDataUI {

    fun startLoadingView()

    fun stopLoadingView()

    fun setView(code: Int, weatherdata: WeatherNowDataBean?, message: String)

    fun setListView(code: Int, weatherdata: ArrayList<WeatherNowDataBean>?, message: String)

}