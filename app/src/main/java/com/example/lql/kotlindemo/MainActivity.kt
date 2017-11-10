package com.example.dell.korlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.lql.kotlindemo.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        /**
         * 这里是笔记，以后再也不用写findviewById了，但是在xml文件中要使用小骆峰样式的命名。
         */
        kotlinTv.setText("你好，我是小米！")

        /**
         * 调用一个方法
         */
        Log.e("###", "调用一个方法："+makeIntData(1))

        Log.e("###","调用求和方法："+sum(1,2).toString())

        Log.e("###","调用求和方法，第二个参数不传递："+sum(1).toString())


    }

    /**
     * 定义一个入参为int类型的，返回值为String 类型的方法
     */
    private fun makeIntData(number: Int): String {
        return (number + 1).toString()
    }

    /**
     * 定义一个入参为两个int类型 ,第一个必选，第二个不传的时候默认为0,返回只为int 类型，但是可以为null
     */
    private fun sum(number: Int?, number1: Int = 0): Int? {
        if (number != null) {
            return number + number1
        } else {
            return null
        }
//        return if (number != null) ? number + number1:null
    }


}
