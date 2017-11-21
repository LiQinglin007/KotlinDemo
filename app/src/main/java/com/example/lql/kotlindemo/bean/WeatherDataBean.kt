package com.example.lql.kotlindemo.bean
import com.alibaba.fastjson.annotation.JSONField


/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/20
 * 修改备注：
 */
data class WeatherDataBean(
		@JSONField(name = "date") val date: String,
		@JSONField(name = "message") val message: String,
		@JSONField(name = "status") val status: Int,
		@JSONField(name = "city") val city: String,
		@JSONField(name = "count") val count: Int,
		@JSONField(name = "data") val data: Data
)

data class Data(
		@JSONField(name = "shidu") val shidu: String,
		@JSONField(name = "pm25") val pm25: Double,
		@JSONField(name = "pm10") val pm10: Double,
		@JSONField(name = "quality") val quality: String,
		@JSONField(name = "wendu") val wendu: String,
		@JSONField(name = "ganmao") val ganmao: String,
		@JSONField(name = "yesterday") val yesterday: Yesterday,
		@JSONField(name = "forecast") val forecast: List<Forecast>
)

data class Yesterday(
		@JSONField(name = "date") val date: String,
		@JSONField(name = "sunrise") val sunrise: String,
		@JSONField(name = "high") val high: String,
		@JSONField(name = "low") val low: String,
		@JSONField(name = "sunset") val sunset: String,
		@JSONField(name = "aqi") val aqi: Double,
		@JSONField(name = "fx") val fx: String,
		@JSONField(name = "fl") val fl: String,
		@JSONField(name = "type") val type: String,
		@JSONField(name = "notice") val notice: String
)

data class Forecast(
		@JSONField(name = "date") val date: String,
		@JSONField(name = "sunrise") val sunrise: String,
		@JSONField(name = "high") val high: String,
		@JSONField(name = "low") val low: String,
		@JSONField(name = "sunset") val sunset: String,
		@JSONField(name = "aqi") val aqi: Double,
		@JSONField(name = "fx") val fx: String,
		@JSONField(name = "fl") val fl: String,
		@JSONField(name = "type") val type: String,
		@JSONField(name = "notice") val notice: String
)