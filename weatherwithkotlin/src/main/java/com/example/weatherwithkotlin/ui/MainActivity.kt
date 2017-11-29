package com.example.weatherwithkotlin.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.example.weatherwithkotlin.R
import com.example.weatherwithkotlin.adapter.MainActivityAdapter
import com.example.weatherwithkotlin.db.bean.CityBean
import com.example.weatherwithkotlin.db.bean.CityBeanManager
import com.example.weatherwithkotlin.db.bean.WeatherNowDataBean
import com.example.weatherwithkotlin.presenter.GetWeatherDataPresenter
import com.example.weatherwithkotlin.utils.FinalData
import com.example.weatherwithkotlin.utils.LogUtils
import com.example.weatherwithkotlin.utils.RecyclerView.OnItemClickListener
import com.example.weatherwithkotlin.utils.SHA1Utils
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter
import com.shiqkuangsan.cityselector.CitySelectorActivity
import com.shiqkuangsan.cityselector.message.StringEventMessage
import com.shiqkuangsan.cityselector.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseActivity(), AMapLocationListener, GetWeatherDataUI {
    override fun setView(code: Int, weatherdata: WeatherNowDataBean?, message: String) {

    }


    override fun startLoadingView() {
        startLoading(resources.getString(R.string.LOADING))
    }

    override fun stopLoadingView() {
        stopLoading()
    }

    //定义Presenter
    var mGetWeatherDataPresenter: GetWeatherDataPresenter? = null
    var mainActivityAdapter: MainActivityAdapter? = null

    var mList = ArrayList<CityBean>()
    var mListName = ArrayList<String>()
    var mListWeather = ArrayList<WeatherNowDataBean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtils.Loge(SHA1Utils.sHA1(this))
        EventBus.getDefault().register(this)
        mGetWeatherDataPresenter = GetWeatherDataPresenter(this)
        initView()
        var cityname = "石家庄市"
        val substring = cityname.substring(0,cityname.length - 1)
        LogUtils.Loge("substring:"+substring)

    }


    fun initView() {
        mainLRecyclerview.layoutManager = LinearLayoutManager(this)
        mainActivityAdapter = MainActivityAdapter(this)
        mainActivityAdapter!!.setList(mListWeather)
        var mLRecyclerViewAdapter = LRecyclerViewAdapter(mainActivityAdapter)
        mainLRecyclerview.adapter = mLRecyclerViewAdapter

        //禁用下拉刷新功能
        mainLRecyclerview.setPullRefreshEnabled(false)
        //禁用自动加载更多功能
        mainLRecyclerview.setLoadMoreEnabled(false)


        mainFloatingActionButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, CitySelectorActivity::class.java))
        })

        startLocation()

        mainActivityAdapter!!.setOnItemClickListener(OnItemClickListener { view, position ->
            var mIntnet = Intent(this, CityActivity::class.java)
            mIntnet.putExtra("cityname", mList.get(position).cityName)
            startActivity(mIntnet)
            ToastUtil.showToast(this, mList.get(position).cityName)
        })

    }


    override fun setListView(code: Int, weatherdata: ArrayList<WeatherNowDataBean>?, message: String) {
        if (code == FinalData.OnSuccess) {
            LogUtils.Loge("成功了：" + weatherdata.toString())
            mListWeather.clear()
            mListWeather.addAll(weatherdata!!)
            mainActivityAdapter!!.setList(mListWeather)
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun FourthEvent(mStringEventMessage: StringEventMessage) {
        if (mStringEventMessage.code == 0) {
            if (!mListName.contains(mStringEventMessage.message)) {
                CityBeanManager.addCity(CityBean(null, mStringEventMessage.message, 1))
                updateCityList()
            }
        }
    }

    //声明mlocationClient对象
    var mlocationClient: AMapLocationClient? = null
    //声明mLocationOption对象
    var mLocationOption: AMapLocationClientOption? = null


    /**
     * 开始定位
     */
    private fun startLocation() {
        mlocationClient = AMapLocationClient(this)
        //初始化定位参数
        mLocationOption = AMapLocationClientOption()
        //设置定位监听
        mlocationClient!!.setLocationListener(this)
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption!!.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption!!.interval = 1000 * 60 * 60 * 2//每两小时更新一次定位
        //设置定位参数
        mlocationClient!!.setLocationOption(mLocationOption)
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient!!.startLocation()
    }

    /**
     * 结束定位
     */
    fun stopLocation() {
        if (mLocationOption != null) {
            mlocationClient!!.stopLocation()
        }
    }


    /**
     * 定位结束之后的
     */
    override fun onLocationChanged(aMapLocation: AMapLocation?) {
        if (aMapLocation != null) {
            if (aMapLocation.errorCode == 0) {
                var cityname = aMapLocation.city
                val substring = cityname.substring(0,cityname.length - 1)
                CityBeanManager.addLoactionCity(substring)
                LogUtils.Loge(substring + "定位成功：" + aMapLocation.city)
            }
            updateCityList()
        }
    }


    /**
     * 更新城市列表
     */
    fun updateCityList() {
        val queryLocationCity = CityBeanManager.queryLocationCity()
        val queryAllCity = CityBeanManager.queryAllCity()
        mList.clear()
        mListName.clear()

        mList.add(queryLocationCity)
        mList.addAll(queryAllCity)

        for (cityBean in mList) {
            mListName.add(cityBean.cityName)
        }
        mGetWeatherDataPresenter!!.getData(mList)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLocation()
        EventBus.getDefault().unregister(this)
    }


}
