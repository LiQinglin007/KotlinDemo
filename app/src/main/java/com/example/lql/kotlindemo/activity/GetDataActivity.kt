package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.bean.MovieEntity
import com.example.lql.kotlindemo.bean.WeatherDataBean
import com.example.lql.kotlindemo.http.okhttpUtils.MOkCallBack
import com.example.lql.kotlindemo.http.okhttpUtils.SendRequest
import com.example.lql.kotlindemo.http.retrofitUtils.RetrofitHttpUtils
import com.example.lql.kotlindemo.http.retrofitUtils.RetrofitSubscriber
import com.example.lql.kotlindemo.utils.LogUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_getdata.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/23
 * 修改备注：
 */
class GetDataActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.okhttpButton -> okhttpGetData()
            R.id.retrofitButton -> retrofitGetData()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getdata)
        initView()
    }

    fun initView() {
        okhttpButton.setOnClickListener(this)
        retrofitButton.setOnClickListener(this)
    }


    /**
     * 这里有个问题，不能用fastjson解析kotlin对象，因为fastjson解析的对象许需要一个无参的构造方法
     */
    fun okhttpGetData() {
        SendRequest.getWeatherData("石家庄", object : MOkCallBack() {
            override fun onSuccess(response: String?) {
                if (response != null) {
                    if (response.contains("</html>")) {
                        getDataTv.text = "服务器异常"
                        return
                    }
                    LogUtils.Loge(response + "response")
                    val mWeatherDataBean = Gson().fromJson<WeatherDataBean>(response, WeatherDataBean::class.java)
                    getDataTv.text = mWeatherDataBean.toString()
                }
            }

            override fun onFailure(e: Throwable?) {
                getDataTv.text = "请检查网络" + e.toString()
            }
        })
    }

    fun retrofitGetData() {
        val baseUrl = "https://api.douban.com/v2/movie/"
        val instance = RetrofitHttpUtils.getInstance(baseUrl)
        instance.getTopMovie(0, 10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : RetrofitSubscriber<MovieEntity>() {
            override fun onSuccess(response: MovieEntity?) {
                getDataTv.text = "rxjavaUtils()请求成功了：" + response.toString()
            }

            override fun onFailure(e: Throwable?) {
                getDataTv.text = "rxjavaUtils()请求报错了：" + e.toString()
            }
        })
    }

}