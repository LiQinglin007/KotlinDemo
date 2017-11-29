package com.example.weatherwithkotlin.ui

import com.example.weatherwithkotlin.http.bean.WeatherDetailsBean


/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/29
 * 内容：城市详情页面
 * 最后修改：
 */
interface CityActivityUI {
    fun startLoadingView()

    fun stopLoadingView()

    fun setView(code: Int, weatherdata: WeatherDetailsBean?, message: String)
}