package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：函数以及高阶函数
 * 作  者：dell or 李小米
 * 时  间：2017/11/14
 * 修改备注：
 */

class FunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        init()
        initAdvanced()
    }

    //高阶函数
    fun initAdvanced() {
        /**
         * 高阶函数：  1、参数或者返回这的类型是函数型
         * 函数型：（参数）--》返回值
         * lambda: 一种无名函数的简写{ （参数）--》函数执行语句}
         * 其他语言称为闭包，即有能力访问其自身范围外的变量
         */


        //高阶函数：2 、描述任务的结果，而不是使用循环详细推算
        //map：常用于对集合类型的元素类型整体元转
        //其lambda中的参数的约定称为it

        //想要把数字转化为汉字
        val a = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val b = a.map { "第${it}" }

        for (s in b) {
            LogUtils.Loge("整数转换位字符串" + s)
        }


        //闭包
        //filter:对集合类型进行筛选

        //把偶数筛选出来
        var sum = 0
        val c = a.filter {
            it % 2 == 0
        }.forEach {
            sum += it
            LogUtils.Loge("闭包中的：" + sum)
        }

        //分组
        val groupBy = a.groupBy { it % 2 == 0 }
        LogUtils.Loge("groupBy" + groupBy)

    }


    //基本函数
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