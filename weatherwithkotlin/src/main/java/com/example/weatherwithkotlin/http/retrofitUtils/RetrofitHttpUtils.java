package com.example.weatherwithkotlin.http.retrofitUtils;


import com.example.weatherwithkotlin.http.okhttpUtils.HttpUtils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/21
 * 修改备注：
 */
public class RetrofitHttpUtils {

    private static RetrofitApi retrofitApi;

    public static RetrofitApi getInstance(String baseUrl) {
        if (retrofitApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
                    .baseUrl(baseUrl)
                    .client(HttpUtils.getInstance())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            retrofitApi = retrofit.create(RetrofitApi.class);
        }
        return retrofitApi;
    }
}
