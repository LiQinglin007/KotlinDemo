package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：异常错误处理+类型检查和转换
 * 作  者：dell or 李小米
 * 时  间：2017/11/15
 * 修改备注：
 */

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        init()
        init2()
    }

    private fun init2() {
        val a = 5
        val b = 6
        val c = if (a > b) "大于" else a - b

        //类型检查
        if (c is String) {
            LogUtils.Loge("长度" + c.length)
        }

        if (c !is String) {
            LogUtils.Loge("整数" + c)
        }


        //类型转换
        try {
            //强制转换
            var d = c as String
            LogUtils.Loge("强制转换：" + d)
        } catch (e: Exception) {
            LogUtils.Loge("强制转换报错了" + e.toString())
        }

        //安全转换
        var e = c as? String
        LogUtils.Loge("安全转换：" + e)
    }

    private fun init() {
        //捕获异常
        try {
            "g".toInt()
        } catch (e: Exception) {
            LogUtils.Loge(e.toString())
        }

        //抛出异常
        val a: Int? = try {
            "g".toInt()
        } catch (e: Exception) {
            null
        }

        LogUtils.Loge(a.toString())
    }


}