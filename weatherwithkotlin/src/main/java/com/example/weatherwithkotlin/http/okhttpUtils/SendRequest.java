package com.example.weatherwithkotlin.http.okhttpUtils;

/**
 * 类描述：请求数据的方法
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class SendRequest {

    /**
     * 天气预报
     *
     * @param CityName
     * @param mOkCallBack
     */
    public static void getWeatherData(String CityName, MOkCallBack mOkCallBack) {
        String Str1 = "http://www.sojson.com/open/api/weather/json.shtml?city=";
        OkHttpUtils.MyGet(Str1 + CityName, mOkCallBack);
    }


}
