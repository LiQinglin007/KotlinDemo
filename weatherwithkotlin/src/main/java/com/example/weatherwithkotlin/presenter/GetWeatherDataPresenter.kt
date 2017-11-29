package com.example.weatherwithkotlin.presenter

import com.example.weatherwithkotlin.db.bean.CityBean
import com.example.weatherwithkotlin.db.bean.WeatherNowDataBean
import com.example.weatherwithkotlin.db.bean.WeatherNowDataBeanManager
import com.example.weatherwithkotlin.http.bean.WeatherDataBean
import com.example.weatherwithkotlin.http.retrofitUtils.HttpCode
import com.example.weatherwithkotlin.http.retrofitUtils.RetrofitApi
import com.example.weatherwithkotlin.http.retrofitUtils.RetrofitHttpUtils
import com.example.weatherwithkotlin.http.retrofitUtils.RetrofitSubscriber
import com.example.weatherwithkotlin.ui.GetWeatherDataUI
import com.example.weatherwithkotlin.utils.FinalData
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：
 * 最后修改：
 */
class GetWeatherDataPresenter(var mGetWeatherDataUI: GetWeatherDataUI) : IGetWeatherDataPresenter {
    var mView: GetWeatherDataUI? = null
    var instance: RetrofitApi? = null
    val baseUrl = "https://free-api.heweather.com/s6/"
    val key = "b2b3b3cc22ff486d9489a7c36f020afc"
    fun getView(): GetWeatherDataUI {
        if (mView == null) {
            mView = mGetWeatherDataUI
        }
        return mView as GetWeatherDataUI
    }

    fun getRetrofit(): RetrofitApi {
        if (instance == null) {
            instance = RetrofitHttpUtils.getInstance(baseUrl)
        }
        return instance as RetrofitApi
    }

    //批量查询
    override fun getData(city: ArrayList<CityBean>) {
        val view = getView()
        view.startLoadingView()
        var returnData = ArrayList<WeatherNowDataBean>()

        getDataFormService(city, object : callbackForService {
            override fun myCallBack() {
                for (cityBean in city) {
                    returnData.add(WeatherNowDataBeanManager.LoadCityData(cityBean.cityName))
                    if (cityBean.equals(city.last())) {
                        view.stopLoadingView()
                        view.setListView(FinalData.OnSuccess, returnData, "")
                    }
                }
            }
        })
    }

    private fun getDataFormService(city: ArrayList<CityBean>, mCall: callbackForService) {
        for (cityBean in city) {
            var nowData = Date().time
            val loadCityData = WeatherNowDataBeanManager.LoadCityData(cityBean.cityName)
            //每3h更新一次，如果是在三小时以内并且有这个城市的数据，就返回数据库里的
            if (loadCityData == null || nowData - loadCityData.lastTime > 1000 * 60 * 60 * 3) {
                getRetrofit().getNowData(cityBean.cityName, key).
                        subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread()).
                        subscribe(object : RetrofitSubscriber<WeatherDataBean>() {
                            override fun onSuccess(response: WeatherDataBean?) {
                                var mWeatherNowDataBean = WeatherNowDataBean()
                                mWeatherNowDataBean.weatherNowDataId = null
                                mWeatherNowDataBean.cityId = cityBean.cityBeanId
                                mWeatherNowDataBean.cityName = cityBean.cityName
                                mWeatherNowDataBean.lastTime = nowData

                                mWeatherNowDataBean.httpCode = response!!.HeWeather6[0].status
                                mWeatherNowDataBean.updateTime = response!!.HeWeather6[0].update.loc
                                mWeatherNowDataBean.cloudCode = response!!.HeWeather6[0].now.cond_code
                                mWeatherNowDataBean.cloudTxt = response!!.HeWeather6[0].now.cond_txt
                                mWeatherNowDataBean.fl = response!!.HeWeather6[0].now.fl
                                mWeatherNowDataBean.hum = response!!.HeWeather6[0].now.hum
                                mWeatherNowDataBean.pcpn = response!!.HeWeather6[0].now.pcpn
                                mWeatherNowDataBean.tmp = response!!.HeWeather6[0].now.tmp
                                mWeatherNowDataBean.windDir = response!!.HeWeather6[0].now.wind_dir
                                mWeatherNowDataBean.windSc = response!!.HeWeather6[0].now.wind_sc
                                WeatherNowDataBeanManager.UpdateCityWeather(mWeatherNowDataBean)
                                if (cityBean.equals(city.last())) {
                                    mCall.myCallBack()
                                }
                            }

                            override fun onFailure(e: Throwable?) {
                                var mWeatherNowDataBean = WeatherNowDataBean()
                                mWeatherNowDataBean.weatherNowDataId = null
                                mWeatherNowDataBean.cityId = cityBean.cityBeanId
                                mWeatherNowDataBean.cityName = cityBean.cityName
                                mWeatherNowDataBean.lastTime = nowData
                                mWeatherNowDataBean.httpCode = e.toString()
                                mWeatherNowDataBean.updateTime = null
                                mWeatherNowDataBean.cloudCode = null
                                mWeatherNowDataBean.cloudTxt = null
                                mWeatherNowDataBean.fl = null
                                mWeatherNowDataBean.hum = null
                                mWeatherNowDataBean.pcpn = null
                                mWeatherNowDataBean.tmp = null
                                mWeatherNowDataBean.windDir = null
                                mWeatherNowDataBean.windSc = null
                                WeatherNowDataBeanManager.UpdateCityWeather(mWeatherNowDataBean)
                                if (cityBean.equals(city.last())) {
                                    mCall.myCallBack()
                                }
                            }
                        })
            }else{
                if (cityBean.equals(city.last())) {
                    mCall.myCallBack()
                }
            }

        }
    }


    interface callbackForService {
        fun myCallBack()
    }


    //单独查询
    override fun getData(city: CityBean) {
        val view = getView()
        view.startLoadingView()
        var nowData = Date().time
        val loadCityData = WeatherNowDataBeanManager.LoadCityData(city.cityName)
        //每3h更新一次，如果是在三小时以内并且有这个城市的数据，就返回数据库里的
        if (loadCityData != null && nowData - loadCityData.lastTime < 1000 * 60 * 60 * 3) {
            view.stopLoadingView()
            view.setView(FinalData.OnSuccess, loadCityData!!, "")
        } else {
            getRetrofit().getNowData(city.cityName, key).subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(object : RetrofitSubscriber<WeatherDataBean>() {
                        override fun onSuccess(response: WeatherDataBean?) {
                            if (response == null) {
                                view.stopLoadingView()
                                view.setView(FinalData.OnError, null, "请求错误")
                                return
                            }
                            if (response!!.HeWeather6[0].status.equals("ok")) {//请求成功了
                                var mWeatherNowDataBean = WeatherNowDataBean()

                                mWeatherNowDataBean.weatherNowDataId = null
                                mWeatherNowDataBean.cityId = city.cityBeanId
                                mWeatherNowDataBean.cityName = city.cityName
                                mWeatherNowDataBean.lastTime = nowData
                                mWeatherNowDataBean.httpCode = response!!.HeWeather6[0].status

                                mWeatherNowDataBean.updateTime = response!!.HeWeather6[0].update.loc
                                mWeatherNowDataBean.cloudCode = response!!.HeWeather6[0].now.cond_code
                                mWeatherNowDataBean.cloudTxt = response!!.HeWeather6[0].now.cond_txt
                                mWeatherNowDataBean.fl = response!!.HeWeather6[0].now.fl
                                mWeatherNowDataBean.hum = response!!.HeWeather6[0].now.hum
                                mWeatherNowDataBean.pcpn = response!!.HeWeather6[0].now.pcpn
                                mWeatherNowDataBean.tmp = response!!.HeWeather6[0].now.tmp
                                mWeatherNowDataBean.windDir = response!!.HeWeather6[0].now.wind_dir
                                mWeatherNowDataBean.windSc = response!!.HeWeather6[0].now.wind_sc

                                WeatherNowDataBeanManager.UpdateCityWeather(mWeatherNowDataBean)
                                view.stopLoadingView()
                                view.setView(FinalData.OnSuccess, WeatherNowDataBeanManager.LoadCityData(city.cityName)!!, "")
                            } else {
                                view.stopLoadingView()
                                view.setView(FinalData.OnError, null, HttpCode.ToMessage(response!!.HeWeather6[0].status))
                            }
                        }

                        override fun onFailure(e: Throwable?) {
                            view.stopLoadingView()
                            view.setView(FinalData.OnError, null, e.toString())
                        }
                    })


        }
    }


}


