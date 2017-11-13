package com.example.lql.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.lql.kotlindemo.R
import org.jetbrains.anko.find

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/13
 * 修改备注：
 */

class TestAdapter : RecyclerView.Adapter<TestAdapter.MyViewHolder>() {




    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




    class MyViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val imageview: ImageView = item.find(R.id.itemAdapterImg)
        val textview: ImageView = item.find(R.id.itemAdapterTv)
    }

}