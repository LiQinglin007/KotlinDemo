package com.example.weatherwithkotlin.utils

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/29
 * 内容：根据天气拿到天气图片
 * 最后修改：
 */
class WeatherCodeImg {
    companion object {
        fun getImg(code: String): String {
            return "https://cdn.heweather.com/cond_icon/${code}.png"
        }
//        和风天气状况代码和图标对照表2017-04-15
//        代码	中文	英文	ICON
//        100	晴	Sunny/Clear	https://cdn.heweather.com/cond_icon/100.png
//        101	多云	Cloudy	https://cdn.heweather.com/cond_icon/101.png
//        102	少云	Few Clouds	https://cdn.heweather.com/cond_icon/102.png
//        103	晴间多云	Partly Cloudy	https://cdn.heweather.com/cond_icon/103.png
//        104	阴	Overcast	https://cdn.heweather.com/cond_icon/104.png
//        200	有风	Windy	https://cdn.heweather.com/cond_icon/200.png
//        201	平静	Calm	https://cdn.heweather.com/cond_icon/201.png
//        202	微风	Light Breeze	https://cdn.heweather.com/cond_icon/202.png
//        203	和风	Moderate/Gentle Breeze	https://cdn.heweather.com/cond_icon/203.png
//        204	清风	Fresh Breeze	https://cdn.heweather.com/cond_icon/204.png
//        205	强风/劲风	Strong Breeze	https://cdn.heweather.com/cond_icon/205.png
//        206	疾风	High Wind, Near Gale	https://cdn.heweather.com/cond_icon/206.png
//        207	大风	Gale	https://cdn.heweather.com/cond_icon/207.png
//        208	烈风	Strong Gale	https://cdn.heweather.com/cond_icon/208.png
//        209	风暴	Storm	https://cdn.heweather.com/cond_icon/209.png
//        210	狂爆风	Violent Storm	https://cdn.heweather.com/cond_icon/210.png
//        211	飓风	Hurricane	https://cdn.heweather.com/cond_icon/211.png
//        212	龙卷风	Tornado	https://cdn.heweather.com/cond_icon/212.png
//        213	热带风暴	Tropical Storm	https://cdn.heweather.com/cond_icon/213.png
//        300	阵雨	Shower Rain	https://cdn.heweather.com/cond_icon/300.png
//        301	强阵雨	Heavy Shower Rain	https://cdn.heweather.com/cond_icon/301.png
//        302	雷阵雨	Thundershower	https://cdn.heweather.com/cond_icon/302.png
//        303	强雷阵雨	Heavy Thunderstorm	https://cdn.heweather.com/cond_icon/303.png
//        304	雷阵雨伴有冰雹	Hail	https://cdn.heweather.com/cond_icon/304.png
//        305	小雨	Light Rain	https://cdn.heweather.com/cond_icon/305.png
//        306	中雨	Moderate Rain	https://cdn.heweather.com/cond_icon/306.png
//        307	大雨	Heavy Rain	https://cdn.heweather.com/cond_icon/307.png
//        308	极端降雨	Extreme Rain	https://cdn.heweather.com/cond_icon/308.png
//        309	毛毛雨/细雨	Drizzle Rain	https://cdn.heweather.com/cond_icon/309.png
//        310	暴雨	Storm	https://cdn.heweather.com/cond_icon/310.png
//        311	大暴雨	Heavy Storm	https://cdn.heweather.com/cond_icon/311.png
//        312	特大暴雨	Severe Storm	https://cdn.heweather.com/cond_icon/312.png
//        313	冻雨	Freezing Rain	https://cdn.heweather.com/cond_icon/313.png
//        400	小雪	Light Snow	https://cdn.heweather.com/cond_icon/400.png
//        401	中雪	Moderate Snow	https://cdn.heweather.com/cond_icon/401.png
//        402	大雪	Heavy Snow	https://cdn.heweather.com/cond_icon/402.png
//        403	暴雪	Snowstorm	https://cdn.heweather.com/cond_icon/403.png
//        404	雨夹雪	Sleet	https://cdn.heweather.com/cond_icon/404.png
//        405	雨雪天气	Rain And Snow	https://cdn.heweather.com/cond_icon/405.png
//        406	阵雨夹雪	Shower Snow	https://cdn.heweather.com/cond_icon/406.png
//        407	阵雪	Snow Flurry	https://cdn.heweather.com/cond_icon/407.png
//        500	薄雾	Mist	https://cdn.heweather.com/cond_icon/500.png
//        501	雾	Foggy	https://cdn.heweather.com/cond_icon/501.png
//        502	霾	Haze	https://cdn.heweather.com/cond_icon/502.png
//        503	扬沙	Sand	https://cdn.heweather.com/cond_icon/503.png
//        504	浮尘	Dust	https://cdn.heweather.com/cond_icon/504.png
//        507	沙尘暴	Duststorm	https://cdn.heweather.com/cond_icon/507.png
//        508	强沙尘暴	Sandstorm	https://cdn.heweather.com/cond_icon/508.png
//        900	热	Hot	https://cdn.heweather.com/cond_icon/900.png
//        901	冷	Cold	https://cdn.heweather.com/cond_icon/901.png
//        999	未知	Unknown	https://cdn.heweather.com/cond_icon/999.png
    }
}