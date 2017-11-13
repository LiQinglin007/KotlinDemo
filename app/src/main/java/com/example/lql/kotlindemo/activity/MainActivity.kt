package com.example.dell.korlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.Log.e
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /**
     * 定义变量，这里貌似必须给出初始值，但是在局部变量里边可以不用给初始值。
     * 如果没有初始值，就给个null吧。
     */
    val a: Int = 1  // 立即初始化
    val b = 2   // 推导出Int型
    var c: Int? = null   // 当没有初始化值时必须声明类型


    /**
     * 集合的三种形式  Set<集> List<列表> Map(映射)
     * Set 无序不重复
     */
    val mStringList: Set<String> = setOf("E", "F", "B", "C", "A", "D", "F", "B")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        c = 3       // 赋值

        initView()
    }

    private fun initView() {
        /**
         * 这里是笔记，以后再也不用写findviewById了，但是在xml文件中要使用小骆峰样式的命名。
         */
        kotlinTv.setText("你好，我是小米！" + a);

        /**
         * 调用一个方法
         */
        LogUtils.Loge("调用一个方法：" + makeIntData(1))

        LogUtils.Loge("调用求和方法：" + sum(1, 2).toString())

        LogUtils.Loge("调用求和方法，第二个参数不传递：" + sum(1).toString())

        forData()
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
     * 写一个for循环
     */
    private fun forData() {
        //这个应该是增强for循环的写法
        for (item in mStringList) {
            LogUtils.Loge(item + "123")
        }

//        LogUtils.Loge("===================================================")
//        //下边这个写一个for循环的写法
//
//        for (i in mStringList.indices)
//            println(mStringList.)


    }

}
