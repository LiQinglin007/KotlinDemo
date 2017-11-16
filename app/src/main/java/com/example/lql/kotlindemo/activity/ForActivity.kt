package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：控制流  for while when
 * 作  者：dell or 李小米
 * 时  间：2017/11/15
 * 修改备注：
 */
class ForActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        init()
    }


    private fun init() {
        //循环中的控制   ： continue 结束本次循环    ，break结束整个循环
        var stringList = arrayOf("小牛", "太阳", "鹈鹕", "黄蜂" )
        //依次操作一个序列（如集合类型）中的每一项，执行次数是可预测的
        for (s in stringList) {
            LogUtils.Loge("循环：" + s)
        }

        //重复执行
        for (a in 0..10) {
            if (a == 5) {
                continue
            }
            LogUtils.Loge("一直在重复执行" + a)
        }

        //while:循环执行操作，直到条件不成立.例子：计算从1开始，加到多少，和是5050
        var sum = 0//和
        var number = 1//起始数
        var timer = 0//次数
        while (sum < 5050) {
            if (number == 5) {
                break
            }
            timer += 1
            number += 1
            sum += number + 1
            LogUtils.Loge("while:循环" + timer)
        }

        var a = 10
        if (a == 10)
            LogUtils.Loge("a等于10")
        else
            LogUtils.Loge("a不等于10")

        LogUtils.Loge(if (a == 10) "a等于10" else "a!=10")


        //在wen语句中，满足了一个条件，就不去执行下边的了
        when (a) {
//            in 0..11 -> {
//                LogUtils.Loge("a在0到11之间")
//            }

            (20 - 11) -> {
                LogUtils.Loge("a==10")
            }

            is Int->{
                LogUtils.Loge("a是Int类型")
            }

            else -> {
                LogUtils.Loge("a不在0到11之间")
            }
        }
    }


}