package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：泛型
 * 作  者：dell or 李小米
 * 时  间：2017/11/16
 * 修改备注：
 */

class GenericsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        init()
    }

    private fun init() {
        /**
         * 让一个类型能被广泛使用，即通用化，称之为泛型
         * 一般用于函数的参数的定义，让函数更加通用
         */
        showText(3)
        showText("123")

        var stringList = arrayOf("1","2","3","4","5","6","7","9")
        //泛型约束
        //求和
        var sum = arrayOf(1, 2, 3, 4, 5, 6, 7, 10).sum()
        LogUtils.Loge("求和：" + sum)
        //但是有不同类型的时候就报错了
//        var sum2 = arrayOf(1, 2, 3, 4, 5, 6, 7, 10.11).sum()
        val sum2 = sum2(1, 2, 3, 4, 5, 6, 7, 10.11)
        LogUtils.Loge("泛型约束：" + sum2)


        //多重约束
        val biggerPart = biggerPart(arrayOf(99, 1, 2, -2, 88, 1024, 888), 3)
        for (i in biggerPart) {
            LogUtils.Loge("多重约束：${i}")
        }

    }


    //下边就是泛型约束：<泛型占位符： 类型>  把泛型约束在Number类型中
    fun <T : Number> sum2(vararg number: T): Double {

        return number.sumByDouble { it.toDouble() }
    }

    //多重约束： where,各个约束用逗号分开，写在函数体之前
    //例子：把数组中大于某个元素的部分都取出来并升序排列
    //（99，1，2，-2，88，1024，888）--》（88，99，888，1024）

    //Comparable 可比较的，大于、小于、等于
    fun <T> biggerPart(list: Array<T>, threhold: T): List<T>  where T : Number, T : Comparable<T> {
        return list.filter { it >= threhold }.sorted()
    }


    //定义一个泛型函数： <T> T表示一个占位符
    fun <T> showText(para: T) {
        LogUtils.Loge("泛型入参：" + para.toString())
    }


}