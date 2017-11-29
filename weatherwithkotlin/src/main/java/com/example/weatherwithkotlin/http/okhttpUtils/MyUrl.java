package com.example.weatherwithkotlin.http.okhttpUtils;


/**
 * 类描述：网络请求相关设置,配置请求地址及参数
 * 作  者：李清林
 * 时  间：2017.5.8
 * 修改备注：
 */

public class MyUrl {
    //我的收藏
    public static String UserFavoriteList = "https://www.51cnkicheck.com/usercenter/UserFavoriteList";
    //下载地址
    public static String DownLoad = "";

    //文件上传
    public static String Upload = "https://www.51cnkicheck.com/usercenter/Upload";

    private static String NbaBaaseUrl = "http://sportsnba.qq.com/";

    /**
     * 每条请求后面都要带的信息 也可以不带
     */
    public static final String DefaulttUrl = "&appver=2.2.1&appvid=2.2.1&deviceId=07C5097900E081E142ED046B56925CC0&from=app&guid=07C5097900E081E142ED046B56925CC0&height=1830&network=WIFI&os=Android&osvid=6.0.1&width=1080";
    /**
     * 获取视频真正地址的
     */
    public static final String BaseVideoUrl = "http://h5vv.video.qq.com/";

    /**
     * @return 获取集锦视频 articleId 这里会返回二百条
     */
    public static String getNBAVideoArticleId() {
        return NbaBaaseUrl + "news/index?column=videos" + DefaulttUrl;
    }


    /**
     * 拿到每一条视频的详情
     *
     * @param ArticleId
     * @return
     */
    public static String getNBAVideoData(String ArticleId) {
        return NbaBaaseUrl + "news/item?column=videos&articleIds=" + ArticleId + DefaulttUrl;
    }


    /**
     * 获取视频真正url
     * @param vid
     * @return
     */
    public static String getNBAVideoRealUrl(String vid){
        return BaseVideoUrl + "getinfo?platform=11001&charge=0&otype=json&vids=" + vid +"&appver=1.0.2.2&appvid=1.0.2.2&network=wifi";
    }



}
