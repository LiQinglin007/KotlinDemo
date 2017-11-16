package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：扩展
 * 作  者：dell or 李小米
 * 时  间：2017/11/16
 * 修改备注：
 */

class ExtendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        init()
    }


    /**
     * 对既有的类新增加功能而无需继承该类，即时无法获取其源代码。
     * 主要作用是“立即”为相关类整体上添加工具类  方法或者属性，高效优雅
     *
     * 扩展函数、扩展方法
     * 与接受者中参数、名称都一样的扩展是无效的
     * 尽量避免与已有的名字重明，如果一定要重名，参数名和类型也不要一样
     *
     *
     */
    private fun init() {

        LogUtils.Loge("函数扩展：" + 3.square())

        val a = arrayOf(1, 2, 3, 4, 5, 8)
        LogUtils.Loge("求最大" + a.max())
        val biggest = a.biggest()
        LogUtils.Loge("自己写一个求最大：" + biggest)

        LogUtils.Loge("属性扩展：" + 3.next)
        LogUtils.Loge("属性泛型扩展：" + 3.area)
        LogUtils.Loge("属性泛型扩展：" + 'B'.toByte().area)

    }


    //扩展函数：fun 接受者类型.新扩展函数名（参数类别）{//函数实现}
    //1、函数扩展
    fun Int.square(): Int {
        return this * this
    }

    //2、泛型函数扩展：求数字型数组中的最大元素
    fun <T> Array<T>.biggest(): T
            where T : Number,
                  T : Comparable<T> {

        var biggest = this[0]
        for (t in this) {
            if (t > biggest) {
                biggest = t
            }
        }
        return biggest
    }


    //    3、属性的扩展（普通属性）
    val Int.next: Int
        get() = this + 1

    //4、泛型属性    数字类型的半径   的面积
    val <T : Number> T.area: Double
        get() = 3.1425926 * this.toDouble() * this.toDouble()

}