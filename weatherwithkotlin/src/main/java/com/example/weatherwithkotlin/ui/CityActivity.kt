package com.example.weatherwithkotlin.ui

import android.os.Bundle
import com.example.weatherwithkotlin.R
import com.example.weatherwithkotlin.http.bean.WeatherDetailsBean
import com.example.weatherwithkotlin.presenter.GetWeatherDetailsPresenter
import com.example.weatherwithkotlin.utils.*
import com.example.weatherwithkotlin.utils.Glide.GlidePicUtils
import kotlinx.android.synthetic.main.activity_city.*
import java.util.*

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：
 * 最后修改：
 */
class CityActivity : BaseActivity(), CityActivityUI {
    override fun setView(code: Int, weatherdata: WeatherDetailsBean?, message: String) {
//        WeatherDetailsBean(HeWeather6=[(
//                HeWeather6Details(basic = BasicDetails(cid = CN101090101, location = 石家庄, parent_city = 石家庄, admin_area = 河北, cnty = 中国, lat = 38.04547501, lon = 114.50246429, tz = +8.0),
//                                  update = UpdateDetails(loc = 2017 - 12 - 18 08):52, utc=2017-12-18 00:52), status=ok, now=NowDetails(cloud=0, cond_code=100, cond_txt=晴, fl=-6, hum=19, pcpn=0.0, pres=1028, tmp=4, vis=6, wind_deg=260, wind_dir=西风, wind_sc=3-4, wind_spd=12),
//        daily_forecast=[(
//                DailyForecast(
//                      cond_code_d = 100,//白天天气代码
//                      cond_code_n = 100,//晚上天气代码
//                      cond_txt_d = 晴,//白天天气
//                      cond_txt_n = 晴,//晚上天气
//                      date = 2017 - 12 - 18, //日期
//                      hum = 22,相对湿度
//                      mr = 07:09,//月升时间
//                      ms=17:19,//月落时间
//                      pcpn=0.0,降水量
//                      pop=0,降水概率
//                      pres=1033,大气压强
//                      sr=07:33, 日出时间
//                      ss=17:05, 日落时间
//                      tmp_max=10, 最高温度
//                      tmp_min=-2, 最低温度
//                      uv_index=1,	紫外线强度指数
//                      vis=20,能见度，单位：公里
//                      wind_deg=344,风向360角度
//                      wind_dir=西北风, 风向
//                      wind_sc=3-4,  风力
//                      wind_spd=13风速，公里/小时
// ),
//                DailyForecast(cond_code_d=100, cond_code_n=100, cond_txt_d=晴, cond_txt_n=晴, date=2017-12-19, hum=21, mr=08:00, ms=18:05, pcpn=0.0, pop=0, pres=1035, sr=07:34, ss=17:06, tmp_max=6, tmp_min=-2, uv_index=2, vis=20, wind_deg=184, wind_dir=南风, wind_sc=微风, wind_spd=4),
//                DailyForecast(cond_code_d=100, cond_code_n=100, cond_txt_d=晴, cond_txt_n=晴, date=2017-12-20, hum=22, mr=08:47, ms=18:55, pcpn=0.0, pop=0, pres=1034, sr=07:35, ss=17:06, tmp_max=7, tmp_min=-3, uv_index=2, vis=20, wind_deg=190, wind_dir=南风, wind_sc=微风, wind_spd=7)],
//        lifestyle=[ comf：舒适度指数、cw：洗车指数、drsg：穿衣指数、flu：感冒指数、sport：运动指数、trav：旅游指数、uv：紫外线指数、air：空气污染扩散条件指数
//        Lifestyle(brf=较舒适, txt=今天夜间虽然天气晴好，但会感觉偏凉，舒适、宜人。, type=comf),
//        Lifestyle(brf=较冷, txt=建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。, type=drsg),
//        Lifestyle(brf=少发, txt=各项气象条件适宜，无明显降温过程，发生感冒机率较低。, type=flu),
//        Lifestyle(brf=较适宜, txt=天气较好，但考虑风力较强且气温较低，推荐您进行室内运动，若在户外运动注意防风并适当增减衣物。, type=sport),
//        Lifestyle(brf=一般, txt=天气较好，温度稍低，加之风稍大，让人感觉有点凉，会对外出有一定影响，外出注意防风保暖。, type=trav),
//        Lifestyle(brf=中等, txt=属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。, type=uv),
//        Lifestyle(brf=较适宜, txt=较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。, type=cw),
//        Lifestyle(brf=中, txt=气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。, type=air)])])
//
        LogUtils.Loge("详情页拿到数据了：${weatherdata.toString()}")

        if (code == FinalData.OnSuccess) {
            if (weatherdata != null) {
//                Lifestyle(brf=冷, txt=天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。, type=drsg),
                nameCityNameTv.text = weatherdata.HeWeather6[0].basic.location
                weatherTv.text = weatherdata.HeWeather6[0].now.cond_txt
                templateTv.text = weatherdata.HeWeather6[0].now.tmp + " ℃"
                todayWeekTv.text = DateUtils.getWeek(Date()) + "  今天"
                todayTem.text = weatherdata.HeWeather6[0].daily_forecast[0].tmp_max + "  " + weatherdata.HeWeather6[0].daily_forecast[0].tmp_min
//
                //明天
                tomorrowWeekTv.text = DateUtils.getWeek(DateUtils.getNextDay(Date()))
                tomorrowTem.text = weatherdata.HeWeather6[0].daily_forecast[1].tmp_max + "  " + weatherdata.HeWeather6[0].daily_forecast[1].tmp_min
                GlidePicUtils.LoadImg(this, tomorrowImg, WeatherCodeImg.getImg(weatherdata.HeWeather6[0].daily_forecast[1].cond_code_d))

                //后天
                afterTomorrowWeekTv.text = DateUtils.getWeek(DateUtils.getNextNextDay(Date()))
                afterTomorrowTem.text = weatherdata.HeWeather6[0].daily_forecast[2].tmp_max + "  " + weatherdata.HeWeather6[0].daily_forecast[2].tmp_min
                GlidePicUtils.LoadImg(this, afterTomorrowImg, WeatherCodeImg.getImg(weatherdata.HeWeather6[0].daily_forecast[2].cond_code_d))

                todayTv.text = "今日：日间${weatherdata.HeWeather6[0].daily_forecast[0].cond_txt_d},最高温度${weatherdata.HeWeather6[0].daily_forecast[0].tmp_max}℃。夜间${weatherdata.HeWeather6[0].daily_forecast[0].cond_txt_n},最低温度${weatherdata.HeWeather6[0].daily_forecast[0].tmp_min}℃。"
                val lifestyle = weatherdata.HeWeather6[0].lifestyle
                for (a in lifestyle) {
                    when (a.type) {
//
//                    brf=较冷, txt=建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。, type=drsg
//                        drsg：穿衣指数
                        "drsg" -> drsgTv.text = "穿衣指数：" + a.txt


//                        flu：感冒指数
//                        brf=少发, txt=各项气象条件适宜，无明显降温过程，发生感冒机率较低。, type=flu
                        "flu" -> fluTv.text = "感冒指数：" + a.txt

//                        sport：运动指数
//                        brf=较适宜, txt=天气较好，但考虑风力较强且气温较低，推荐您进行室内运动，若在户外运动注意防风并适当增减衣物。, type=sport
                        "sport" -> sportTv.text = "运动指数：" + a.txt

//                        trav：旅游指数
//                        brf=一般, txt=天气较好，温度稍低，加之风稍大，让人感觉有点凉，会对外出有一定影响，外出注意防风保暖。, type=trav
                        "trav" -> travTv.text = "旅游指数：" + a.txt


//                        cw  ：洗车指数
//                        brf=较适宜, txt=较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。, type=cw
                        "cw" -> cwTv.text = "洗车指数：" + a.txt

//                        comf：舒适度指数
//                        brf=较舒适, txt=今天夜间虽然天气晴好，但会感觉偏凉，舒适、宜人。, type=comf
                        "comf" -> comfTv.text = "舒适度指数：" + a.txt

//                        uv：紫外线指数
//                        brf=中等, txt=属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。, type=uv
                        "uv" -> uvTv.text = "紫外线指数：" + a.txt

//                        air：空气污染扩散条件指数
//                        brf=中, txt=气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。, type=air
                        "air" -> airTv.text = "空气污染扩散条件指数：" + a.txt

                    }
                }
            } else {
                T.shortToast(this, "失败了")
            }
        } else {
            T.shortToast(this, message)
        }

    }

    var mGetWeatherDetailsPresenter: GetWeatherDetailsPresenter? = null
    var CityName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        CityName = intent.getStringExtra("cityname")

        mGetWeatherDetailsPresenter = GetWeatherDetailsPresenter(this)
        initView()
    }

    fun initView() {
        mGetWeatherDetailsPresenter!!.getWeatherDetailsData(CityName.toString())
    }


    override fun startLoadingView() {
        startLoading(resources.getString(R.string.LOADING))
    }

    override fun stopLoadingView() {
        stopLoading()
    }


}