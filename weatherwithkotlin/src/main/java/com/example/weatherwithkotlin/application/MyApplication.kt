package com.example.weatherwithkotlin.application

import android.app.Activity
import android.app.Application
import com.example.weatherwithkotlin.utils.AppConstant
import com.example.weatherwithkotlin.utils.PublicStaticData
import com.example.weatherwithkotlin.utils.greendaoUtils.DBManager

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/27
 * 内容：
 * 最后修改：
 */
class MyApplication : Application() {

    companion object {
        var myApplication: MyApplication? = null

        fun getInstance(): MyApplication {
            if (myApplication == null) {
                myApplication = MyApplication()
            }
            return myApplication as MyApplication
        }

    }


    override fun onCreate() {
        getInstance()
        DBManager.getInstance().init(this)
        PublicStaticData.mySharedPreferences = getSharedPreferences(AppConstant.PREFRENCE_NAME, Activity.MODE_PRIVATE);//初始化PreferencesUtils
        super.onCreate()
    }
}