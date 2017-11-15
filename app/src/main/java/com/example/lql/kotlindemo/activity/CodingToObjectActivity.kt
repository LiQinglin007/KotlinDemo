package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：面向对象编程
 * 作  者：dell or 李小米
 * 时  间：2017/11/15
 * 修改备注：
 */

class CodingToObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var mBook1 = ShoppingBook("如何购物", 50)
        var mBook2 = FoodBook("吃东西", 20, "food")
        LogUtils.Loge(mBook1.toString())
        LogUtils.Loge(mBook2.toString())
        LogUtils.Loge("mBook1.colors" + mBook1.colors)
        LogUtils.Loge("mBook1.address" + mBook1.address)
        LogUtils.Loge("mBook1.number" + mBook1.number)
        LogUtils.Loge("mBook1.newPrice" + mBook1.newPrice)
        mBook1.colors = "绿色"
        LogUtils.Loge("mBook1.colors" + mBook1.colors)
        LogUtils.Loge("mBook1.address" + mBook1.address)
        LogUtils.Loge("mBook1.number" + mBook1.number)
        LogUtils.Loge("mBook1.newPrice" + mBook1.newPrice)

        mBook1.cook()
        mBook2.cook()


        //数据类
        var mUser = User("小米", "123456")
        LogUtils.Loge(mUser.toString())

        //复制
        var mUser2 = mUser.copy(password = "123")
        LogUtils.Loge(mUser2.toString())

        //数据类对象的结构
        var (name, password) = mUser
        LogUtils.Loge("username:$name,$password")

        //列举熟悉
        LogUtils.Loge("${mUser.component1()}${mUser.component2()}")


        LogUtils.Loge("枚举类：" + SexType.values().joinToString())


        val sizeOrdinal = Size.valueOf("M").ordinal
        val sizeName = Size.valueOf("M").name
        LogUtils.Loge("带有构造器的枚举类：" + sizeOrdinal + sizeName)

        val joinToString = Size.values().joinToString { it.name + ":" + it.height }

        LogUtils.Loge("带有构造器的枚举类：" + joinToString)


        //对象表达式
        val baako = object : Chinese("Baako Zaid") {
            override var skin = "black"
        }

        LogUtils.Loge(baako.skin)

        //纯对象表达式：是临时用，无需继承任何类

        val temParking = object {
            var x = 100;
        }

        //封装一个类
        NetWorkRequestManager.register()
        //伴生方法与类的关联性强
        IDCard.creat()
    }


    /**
     * 伴生对象：一般用于创建一个类的实例的“工厂”方法
     * 相当于java的静态成员
     */

    class IDCard {
        companion object {
            fun creat() = IDCard()
        }
    }


    //对象声明
    object NetWorkRequestManager {
        fun register() {
            LogUtils.Loge("连接网络")
        }
    }


    /**
     * 对象表达式
     */
    open class Chinese(var name: String) {
        open var skin = "yellow"
    }


    /**
     * 定义一个书的实体
     * 关键字open   ,如果一个类想要被集成，需要在class前加上open关键字
     */

    /**
     * 访问修饰符：
     * private
     * protected  仅子类可见
     * internal  当前模块内可见
     * public
     */
    open class Book constructor(var name: String, var price: Int, var type: String) {
        //普通属性
        open var colors: String = "红色"
        var newPrice: Int = 0
        //组合属性
        var address: String = ""
            get() {
                when (this.colors) {
                    "红色" -> {
                        return "石家庄"
                    }
                    else -> {
                        return "其他"
                    }
                }
            }

        //组合属性也可以影响其他属性
        var number: Int
            get() {
                when (this.address) {
                    "石家庄" -> {
                        return 100
                    }
                    else -> {
                        return 200
                    }
                }
            }
            set(value) {
                when (value) {
                    in 0..199 -> {
                        newPrice = 100
                    }
                    else -> {
                        newPrice = 200
                    }
                }
            }


        //类中的方法
        open fun cook() {
            val menu = arrayOf("番茄炒蛋", "炒土豆", "小米粥")
            val reduce = menu.reduce { s1, s2 -> s1 + "," + s2 }
            LogUtils.Loge("类中的方法：${reduce}")
        }


    }


    /**
     * 类的继承
     */
    class ShoppingBook(name: String, price: Int, type: String = "shopping") : Book(name, price, type) {
        var content = "教你如何购物"

        override fun cook() {
            super.cook()
            var menu = arrayOf("毛血旺", "烤鱼")
            val reduce = menu.reduce { s1, s2 -> s1 + "," + s2 }
            LogUtils.Loge("子类继承父类的方法：${reduce}")
        }
    }

    /**
     * 类的继承
     */
    class FoodBook(name: String, price: Int, type: String) : Book(name, price, type) {
        var content = "如何吃东西才健康"
        //在子类中如果要重写父类的属性，要在父类属性中添加open关键字
        override var colors = "食物黄色"
    }

    /**
     * 数据类
     */
    data class User(var username: String, var password: String)

    /**
     * 枚举类
     */
    enum class SexType {
        男, 女
    }

    /**
     * 带有构造器的枚举类
     */
    enum class Size(val height: Int) {
        S(150), M(160), L(170), XL(180)
    }


}