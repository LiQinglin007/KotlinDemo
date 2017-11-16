package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：接口
 * 作  者：dell or 李小米
 * 时  间：2017/11/16
 * 修改备注：
 */


class InterfaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initInterface()
    }


    /**
     * 接口：方法、属性或者一段功能的“蓝本”
     * 仅仅是规定实现的标准
     *
     * 接口通常对于类进行附加功能，可以让类本身保持简洁的定义
     * 通过实现接口,来实现非继承式的功能增强
     *
     * 通过继承实现的功能是必须要实现的，
     * 但是通过接口实现的功能是非必须了，可以自由选择要不要实现某个接口
     */
    fun initInterface() {
        var mForigChinese = ForigChinese()
        mForigChinese.name = "小米"
        mForigChinese.city = "北京"
        mForigChinese.hasJobOffer = true
        mForigChinese.hasSkill = true
        mForigChinese.addChina()
        mForigChinese.SpeakChinese()
        LogUtils.Loge("接口名称：" + mForigChinese.name)
        LogUtils.Loge("接口城市：" + mForigChinese.city)
        LogUtils.Loge("接口是否有工作：" + mForigChinese.hasJobOffer)
        LogUtils.Loge("接口是否有生存技能：" + mForigChinese.hasSkill)
    }

    open class Person {
        var name = ""
    }

    class ForigChinese : Person(), Livable, ChinaLivable {
        override var hasJobOffer: Boolean = true
        override var city: String = "北京"
        override var hasSkill: Boolean = true
        override fun addChina() {
            LogUtils.Loge("我叫${name}我要加入中国国籍")
        }
    }

    interface Livable {
        //接口中的属性和方法不能初始化
        var hasSkill: Boolean//接口中的属性
        fun addChina() //接口中的方法
        //接口中的方法可以有默认实现，通常指该方法是固定不变的
        fun SpeakChinese() {
            LogUtils.Loge("接口中的默认方法：我可以说中文")
        }
    }


    interface ChinaLivable {
        //接口中的属性不可初始化
        val hasJobOffer: Boolean
        //接口中可以有get方法，通常用于增加一个常量属性
        val visaCatagory: String
            get() = "工作offer"
        //接口中的属性
        var city: String
    }

}