package com.example.weatherwithkotlin.http.bean

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/20
 * 修改备注：
 */


data class WeatherDataBean(
		val HeWeather6: List<HeWeather61>
)

data class HeWeather61(
        val basic: Basic,
        val update: Update,
        val status: String, //ok
        val now: Now
)

data class Basic(
		val cid: String, //CN101010100  地区／城市ID
		val location: String, //北京  地区／城市名称
		val parent_city: String, //北京  该地区／城市的上级城市
		val admin_area: String, //北京  该地区／城市所属行政区域
		val cnty: String, //中国   该地区／城市所属国家名称
		val lat: String, //39.90498734  地区／城市经度
		val lon: String, //116.4052887  地区／城市纬度
		val tz: String //+8.0  该地区／城市所在时区
)

data class Update(
		val loc: String, //2017-11-29 08:50  当地时间，24小时制，格式hh:mm
		val utc: String //2017-11-29 00:50  UTC时间，24小时制，格式hh:mm
)

data class Now(
		val cloud: String, //0  云量
		val cond_code: String, //104  实况天气状况代码
		val cond_txt: String, //阴   	实况天气状况代码
		val fl: String, //-10   体感温度，默认单位：摄氏度
		val hum: String, //24  相对湿度
		val pcpn: String, //0  降水量
		val pres: String, //1036  大气压强
		val tmp: String, //-4   温度，默认单位：摄氏度
		val vis: String, //8  能见度，默认单位：公里
		val wind_deg: String, //237  风向360角度
		val wind_dir: String, //西南风  风向
		val wind_sc: String, //微风  风力
		val wind_spd: String //2  风速，公里/小时
)