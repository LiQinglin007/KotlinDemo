package com.example.weatherwithkotlin.http.bean

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/29
 * 内容：
 * 最后修改：
 */


data class WeatherDetailsBean(
		val HeWeather6: List<HeWeather6Details>
)

data class HeWeather6Details(
		val basic: BasicDetails,
		val update: UpdateDetails,
		val status: String, //ok
		val now: NowDetails,
		val daily_forecast: List<DailyForecast>,
		val lifestyle: List<Lifestyle>
)

data class BasicDetails(
		val cid: String, //CN101010100
		val location: String, //北京
		val parent_city: String, //北京
		val admin_area: String, //北京
		val cnty: String, //中国
		val lat: String, //39.90498734
		val lon: String, //116.4052887
		val tz: String //+8.0
)

data class NowDetails(
		val cloud: String, //0
		val cond_code: String, //101
		val cond_txt: String, //多云
		val fl: String, //1
		val hum: String, //16
		val pcpn: String, //0
		val pres: String, //1034
		val tmp: String, //0
		val vis: String, //8
		val wind_deg: String, //264
		val wind_dir: String, //西风
		val wind_sc: String, //微风
		val wind_spd: String //8
)

data class Lifestyle(
		val brf: String, //较不舒适
		val txt: String, //白天天气晴好，但仍会使您感觉偏冷，不很舒适，请注意适时添加衣物，以防感冒。
		val type: String //comf
)

data class DailyForecast(
		val cond_code_d: String, //101
		val cond_code_n: String, //101
		val cond_txt_d: String, //多云
		val cond_txt_n: String, //多云
		val date: String, //2017-11-29
		val hum: String, //14
		val mr: String, //14:18
		val ms: String, //01:41
		val pcpn: String, //0.0
		val pop: String, //0
		val pres: String, //1036
		val sr: String, //07:14
		val ss: String, //16:52
		val tmp_max: String, //1
		val tmp_min: String, //-6
		val uv_index: String, //1
		val vis: String, //20
		val wind_deg: String, //197
		val wind_dir: String, //西南风
		val wind_sc: String, //微风
		val wind_spd: String //5
)

data class UpdateDetails(
		val loc: String, //2017-11-29 14:50
		val utc: String //2017-11-29 06:50
)