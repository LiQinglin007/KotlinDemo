package com.example.lql.kotlindemo.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 类描述：首页以及定义变量、点击事件、元组的用法
 * 作  者：李小米
 * 时  间：
 * 修改备注：
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * 给view设置点击事件
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonList -> startActivity(Intent(this, MyListActivity1::class.java))
            R.id.buttonFunction -> startActivity(Intent(this, FunctionActivity::class.java))
            R.id.buttonFor -> startActivity(Intent(this, ForActivity::class.java))
            R.id.buttonObject -> startActivity(Intent(this, CodingToObjectActivity::class.java))
        }
    }

    /**
     * 定义变量，这里貌似必须给出初始值，但是在局部变量里边可以不用给初始值。
     * 如果没有初始值，就给个null吧。
     *
     * 说一个var和val的区别
     * var是定义一个变量,以后这个值是可以变的
     * val是定义一个常量,在以后的操作过程中,这个值是不能变的.
     */
    val a: Int = 1  // 立即初始化
    val b = 2   // 推导出Int型
    val d = 2.357   // 小数，默认为doulbe类型
    var c: Int? = null    // 当没有初始化值时必须声明类型


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        c = 3       // 赋值

        /**
         * 元组   三元元组
         */
        var (name, move, number) = kotlin.Triple("小米", "左", 3)
        LogUtils.Loge("${name}向${move}边移动了${number}步")

        /**
         * 二元元组
         */
        var (name1, move2) = Pair("小明", "右")
        LogUtils.Loge("${name1}向${move2}边移动了5步")

        /**
         * 二元元组
         */
        var move3 = Pair("小红", "前")
        LogUtils.Loge("${move3.first}向${move3.second}边移动了10步")



        initView()
    }

    private fun initView() {
        /**
         * 这里是笔记，以后再也不用写findviewById了，但是在xml文件中要使用小骆峰样式的命名。
         */
        kotlinTv.setText("你好，我是小米！" + a);
        kotlinTv.setOnClickListener {
            LogUtils.Loge("我是小米，您点击了textview")
        }
        buttonList.setOnClickListener(this)
        buttonFunction.setOnClickListener(this)
        buttonFor.setOnClickListener(this)
        buttonObject.setOnClickListener(this)


        LogUtils.Loge("每天跑步${c}公里")

    }



}
