package com.example.weatherwithkotlin.presenter

import com.example.weatherwithkotlin.http.bean.WeatherDetailsBean
import com.example.weatherwithkotlin.http.retrofitUtils.RetrofitApi
import com.example.weatherwithkotlin.http.retrofitUtils.RetrofitHttpUtils
import com.example.weatherwithkotlin.http.retrofitUtils.RetrofitSubscriber
import com.example.weatherwithkotlin.ui.CityActivityUI
import com.example.weatherwithkotlin.utils.FinalData
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/29
 * 内容：
 * 最后修改：
 */
class GetWeatherDetailsPresenter(var mCityActivityUI: CityActivityUI) : IGetWeatherDetailsPresenter {

    var mView: CityActivityUI? = null
    var instance: RetrofitApi? = null
    val baseUrl = "https://free-api.heweather.com/s6/"
    val key = "b2b3b3cc22ff486d9489a7c36f020afc"

//    未来3-10天的天气情况
//    https://free-api.heweather.com/s6/weather/forecast?parameters

//逐小时天气
//    https://free-api.heweather.com/s6/weather/hourly?parameters

    fun getView(): CityActivityUI {
        if (mView == null) {
            mView = mCityActivityUI
        }
        return mView as CityActivityUI
    }

    fun getRetrofit(): RetrofitApi {
        if (instance == null) {
            instance = RetrofitHttpUtils.getInstance(baseUrl)
        }
        return instance as RetrofitApi
    }

    //获取常规天气
    override fun getWeatherDetailsData(city: String) {
        val view = getView()
        view.startLoadingView()
        getRetrofit().getData(city, key).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(object : RetrofitSubscriber<WeatherDetailsBean>() {
                    override fun onSuccess(response: WeatherDetailsBean?) {
                        view.stopLoadingView()
                        view.setView(FinalData.OnSuccess, response, "")
                    }

                    override fun onFailure(e: Throwable?) {
                        view.stopLoadingView()
                        view.setView(FinalData.OnSuccess, null, e.toString())
                    }
                })
    }
}