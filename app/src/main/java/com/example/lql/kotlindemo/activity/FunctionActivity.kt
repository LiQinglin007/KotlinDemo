package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/14
 * 修改备注：
 */

class FunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        init()
    }

    fun init() {
        /**
         * 调用一个方法
         */
        LogUtils.Loge("调用一个方法：" + makeIntData(1))

        LogUtils.Loge("调用求和方法：" + sum(1, 2).toString())

        LogUtils.Loge("调用求和方法，第二个参数不传递：" + sum(1).toString())

        LogUtils.Loge("调用求和方法，可变参数,第一个：" + sum1(1, 2, 3, 4, 5).toString() + ",第二个：" + sum1(1, 2, 3))

        var intArrayOf = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        LogUtils.Loge("调用求和方法，可变参数,也可以穿一个数组进去：" + sum1(*intArrayOf).toString())

    }


    /**
     * 定义一个入参为int类型的，返回值为String 类型的方法
     */
    private fun makeIntData(number: Int): String {
        return (number + 1).toString()
    }

    /**
     * 定义一个入参为两个int类型 ,第一个必选，第二个不传的时候默认为0,返回只为int 类型，但是可以为null
     * 以及三元运算符的使用
     */
    private fun sum(number: Int?, number1: Int = 0): Int? {
//        if (number != null) {
//            return number + number1
//        } else {
//            return null
//        }

        return if (number != null) number + number1 else null
    }


    /**
     * 定义一个可变参数
     */
    private fun sum1(vararg x: Int): Int {
        var sumNumber = 0
        for (i in x) {
            sumNumber += i
        }
        return sumNumber
    }


}