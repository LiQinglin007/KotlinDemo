package com.example.weatherwithkotlin.http.retrofitUtils;


import com.example.weatherwithkotlin.http.bean.WeatherDataBean;
import com.example.weatherwithkotlin.http.bean.WeatherDetailsBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/21
 * 修改备注：
 */
public interface RetrofitApi {
    //    实况天气
//    实况天气即为当前时间点的天气状况以及温湿风压等气象指数，具体包含的数据：体感温度、实测温度、天气状况、风力、风速、风向、相对湿度、大气压强、降水量、能见度等。
//    https://free-api.heweather.com/s6/weather/now?parameters
//    https://free-api.heweather.com/s6/weather?parameters
//    location
//    key
    @GET("weather/now")
    Observable<WeatherDataBean> getNowData(@Query("location") String city, @Query("key") String key);

    //    常规天气数据集合
//    本接口包含了常规天气数据接口，如3-7天天气预报、实况天气、逐小时预报以及生活指数，有权限的用户可通过访问此接口一次性获取某一地区的上述所有天气数据
//    https://free-api.heweather.com/s6/weather?parameters
//    location
//    key
    @GET("weather")
    Observable<WeatherDetailsBean> getData(@Query("location") String city, @Query("key") String key);


//
//    ok	数据正常
//    invalid key	错误的key，请检查你的key是否输入以及是否输入有误
//    unknown location	未知或错误城市/地区
//    no data for this location	该城市/地区没有你所请求的数据
//    no more requests	超过访问次数，需要等到当月最后一天24点后进行访问次数的重置或升级你的访问量
//    invalid param	参数错误，请检查你传递的参数是否正确
//    too fast	超过限定的QPM，请参考QPM说明
//    dead	无响应或超时，接口服务异常请联系我们
//    permission denied	无访问权限，你没有购买你所访问的这部分服务

}
