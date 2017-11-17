package com.example.lql.kotlindemo.adapter

import java.util.*

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/17
 * 修改备注：
 */
class TestAdapterJava {
    private val mList = ArrayList<String>()

    fun setList(mListContext: ArrayList<String>) {
        mList.clear()
        mList.addAll(mListContext)
    }


}
