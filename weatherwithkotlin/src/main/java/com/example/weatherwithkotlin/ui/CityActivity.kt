package com.example.weatherwithkotlin.ui

import android.os.Bundle
import com.example.weatherwithkotlin.R
import com.example.weatherwithkotlin.http.bean.WeatherDetailsBean
import com.example.weatherwithkotlin.presenter.GetWeatherDetailsPresenter
import com.example.weatherwithkotlin.utils.LogUtils
import kotlinx.android.synthetic.main.activity_city.*

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：
 * 最后修改：
 */
class CityActivity : BaseActivity(), CityActivityUI {
    override fun setView(code: Int, weatherdata: WeatherDetailsBean?, message: String) {

        LogUtils.Loge("详情页拿到数据了：${weatherdata.toString()}")
        nameCityDataTv.text = weatherdata.toString()
    }

    var mGetWeatherDetailsPresenter: GetWeatherDetailsPresenter? = null
    var CityName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        CityName = intent.getStringExtra("cityname")
        mGetWeatherDetailsPresenter = GetWeatherDetailsPresenter(this)
        initView()
    }

    fun initView() {
        mGetWeatherDetailsPresenter!!.getWeatherDetailsData(CityName.toString())
    }


    override fun startLoadingView() {
        startLoading(resources.getString(R.string.LOADING))

    }

    override fun stopLoadingView() {
        stopLoading()
    }


}