package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.utils.LogUtils

/**
 * 类描述：集合
 * 作  者：dell or 李小米
 * 时  间：2017/11/13
 * 修改备注：
 */


/**
 * 集合的三种形式  Set<集>: 无序不重复
 *                 List<列表>：有序可重复，索引从0开始
 *                 Map(映射)：无序不重复，键值对
 */


class MyListActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        initSet()
//        initList()
        initMap()
    }

    /**
     * Map映射。类似于"字典"的概念
     */
    fun initMap() {
        //创建一个map
        var stationMap = mapOf(Pair("shijiazhuang", "石家庄"), Pair("nanjing", "南京"),
                Pair("suzhou", "苏州"), Pair("shanghai", "上海"), Pair("zhangjiakou", "张家口")
                , Pair("taiyuan", "太原"), Pair("tianjin", "天津"))

        LogUtils.Loge("map数量：" + stationMap.count())
        LogUtils.Loge("map是否位空：" + stationMap.isEmpty())

        //根据key获取values
        LogUtils.Loge(stationMap.get("tianjin"))
        //获取所有的key
        val keys = stationMap.keys
        for (s in keys) {
            LogUtils.Loge("所有的key:" + s)
        }
        //获取所有的values
        val values = stationMap.values
        for (s in values) {
            LogUtils.Loge("所有的values:" + s)
        }

        val toMutableMap = stationMap.toMutableMap()

        toMutableMap.remove("shijiazhuang")
        for (mutableEntry in toMutableMap) {
            LogUtils.Loge("移除某一个:" + mutableEntry)
        }

        toMutableMap["nanjing"] = "南京市"
        for (mutableEntry in toMutableMap) {
            LogUtils.Loge("根据key修改values:" + mutableEntry)
        }
        toMutableMap["cangzhou"] = "沧州"
        for (mutableEntry in toMutableMap) {
            LogUtils.Loge("这样能新增一个:" + mutableEntry)
        }


    }

    /**
     * List集合
     */
    fun initList() {
        //定义一个数组
        var stationsList = arrayOf("石家庄", "北京", "南京", "上海", "苏州", "上海")
        for (s in stationsList) {
            LogUtils.Loge("stationList:" + s)
        }
        //创建一个有默认值的数组
        var stationList2 = Array(20, { "默认站的名字" })
        for (s in stationList2) {
            LogUtils.Loge("默认名称：stationList2:" + s)
        }

        //创建一个从1--100的数组
        var oneToHundred = Array(100, { i -> i + 1 })
        for (s in oneToHundred) {
            LogUtils.Loge("0到100》oneToHundred:" + s)
        }

        //元素的个数  判断是否为空
        if (oneToHundred.isNotEmpty()) {
            LogUtils.Loge(oneToHundred.count().toString())
        }

        //获取某一个数据
        LogUtils.Loge("站名的第一个" + stationsList.first())
        LogUtils.Loge("站名的最后一个" + stationsList.last())
        LogUtils.Loge("前两个" + stationsList.component1() + stationsList.component2())
        LogUtils.Loge("第两个" + stationsList[2 - 1])
        LogUtils.Loge("第两个" + stationsList.get(2 - 1))

        //筛选重复（把重复的去掉）
        var stationList3 = stationsList.distinct()
        for (s in stationsList) {
            LogUtils.Loge("不重复的数组" + s)
        }

        //把一个数组转化成集合
        val toSet = stationsList.toSet()
        for (s in toSet) {
            LogUtils.Loge("不重复的集合" + s)
        }


        //数组切割  从第二个到第三个，包含前边，不包含后边
        val subList = stationList3.subList(2, 4)
        for (s in subList) {
            LogUtils.Loge("截取数组：" + s)
        }

        //切割数组  从第二个到第三个,包含前边，也包含后边
        val slice = stationList3.slice(2..3)
        for (s in slice) {
            LogUtils.Loge("切割数组：" + s)
        }
//#################################################以上是不可变的数组#############################


        //定义大小可变的数组
        val mutableList2 = mutableListOf("a", "b", "c")
        for (s in mutableList2) {
            LogUtils.Loge("可变数组：" + s)
        }

        //增加一个
        mutableList2.add(2, "e")
        for (s in mutableList2) {
            LogUtils.Loge("可变数组，新增加一个：" + s)
        }

        val mutableList1 = mutableListOf("1", "2", "3")
        //增加一堆
        mutableList2.addAll(mutableList1)
        for (s in mutableList2) {
            LogUtils.Loge("可变数组，新增加一堆：" + s)
        }

        //移除第几个
        mutableList2.removeAt(0)
        for (s in mutableList2) {
            LogUtils.Loge("可变数组，移除第几个：" + s)
        }

        //移除某一个
        mutableList2.remove("e")
        for (s in mutableList2) {
            LogUtils.Loge("可变数组，移除某一个：" + s)
        }

        for (index in mutableList2.indices) {
            LogUtils.Loge("换种写法写循环：" + mutableList2.get(index))
        }

        val list3 = ArrayList<String>()

        list3.add("李")
        list3.add("小")
        list3.add("米")

        list3.remove("李")
        list3.add(0, "牛")
        list3.removeAt(1)
        for (item in list3) {
            LogUtils.Loge("List3集合：" + item)
        }

    }


    /**
     * Set集合
     */
    fun initSet() {

        //定义一个不可变的Set集合
        var mStringSet1: Set<String> = setOf("E", "F", "B", "C", "A", "D", "F", "B")

        //定义一个可以边的Set集合
        var mStringSet2: Set<String> = mutableSetOf("E", "F", "B", "C", "A", "Z")
        //创建一个空的Set集合
        var mStringSet3: Set<String> = emptySet()

        LogUtils.Loge("数量：" + mStringSet1.count())
        LogUtils.Loge("是否为空：" + mStringSet3.isEmpty())
        for (item in mStringSet1) {
            LogUtils.Loge(item + "mStringSet1")
        }
        //是否包含某个元素
        LogUtils.Loge("判断是否包含某个元素：" + mStringSet1.contains("A"))
        //是否包含某个集合
        LogUtils.Loge("判断是否包含某个集合：" + mStringSet1.containsAll(mStringSet2))
        //转换成list
        val toTypedArray = mStringSet1.toTypedArray()
        for (s in toTypedArray) {
            LogUtils.Loge("集合转换成数组：" + s)
        }

        //集合之间的操作
        val intersect = mStringSet1.intersect(mStringSet2)
        LogUtils.Loge("交集：" + intersect)

        val union = mStringSet1.union(mStringSet2)
        LogUtils.Loge("全集：" + union)

        val subtract = mStringSet1.subtract(mStringSet2)
        LogUtils.Loge("差集：" + subtract)

        val minus = mStringSet1.minus(mStringSet2)
        for (minus1 in minus) {
            LogUtils.Loge("补集：" + minus1)
        }

        //转换成ToMutableSet
        val toMutableList = mStringSet2.toMutableList()
        for (s in toMutableList) {
            LogUtils.Loge("toMutableList：" + s)
        }

        //MutableSet:大小可变的集合

        //增加一个
        toMutableList.add("K")
        for (s in toMutableList) {
            LogUtils.Loge("新增加了一个：" + s)
        }

        //增加一堆
        toMutableList.addAll(mStringSet1)
        for (s in toMutableList) {
            LogUtils.Loge("新增加了一堆：" + s)
        }

        //删除第0个
        toMutableList.removeAt(0)
        for (s in toMutableList) {
            LogUtils.Loge("删除第0个：" + s)
        }
        //删除某一个
        toMutableList.remove("K")
        for (s in toMutableList) {
            LogUtils.Loge("删除某一个：" + s)
        }
    }

}