package com.example.lql.kotlindemo.http.okhttpUtils;

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

    /**
     * 拿到视频的数据（第一步）200条
     *
     * @param mOkCallBack
     */
    public static void getHighlightVideoArticleIds(MOkCallBack mOkCallBack) {
        OkHttpUtils.MyGet(MyUrl.getNBAVideoArticleId(), mOkCallBack);
    }


    /**
     * 拿到每一条视频的数据  传进来视频的id，用逗号隔开
     *
     * @param ArticleIds
     * @param mOkCallBack
     */
    public static void getNBAVideoData(String ArticleIds, MOkCallBack mOkCallBack) {
        OkHttpUtils.MyGet(MyUrl.getNBAVideoData(ArticleIds), mOkCallBack);
    }


    public  static void getNBAVideoRealUrl(String VIds, MOkCallBack mOkCallBack){
        OkHttpUtils.MyGet(MyUrl.getNBAVideoRealUrl(VIds), mOkCallBack);
    }





}
