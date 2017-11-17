package com.example.lql.kotlindemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.bean.TestBean
import com.example.lql.kotlindemo.utils.Glide.GlidePicUtils
import com.example.lql.kotlindemo.utils.LogUtils
import com.example.lql.kotlindemo.utils.RecyclerView.OnItemClickListener
import com.example.lql.kotlindemo.utils.T
import org.jetbrains.anko.find


/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/13
 * 修改备注：
 */

//mList是TestAdapter的构造方法的入参
class TestAdapter(mContextView: Context) : RecyclerView.Adapter<TestAdapter.MyViewHolder>() {

    private var mContext = mContextView
    private var mList = ArrayList<TestBean>()

    private var mClick: OnItemClickListener? = null

    fun setOnItemClickListener(recyclerviewOnItemClick: OnItemClickListener) {
        mClick = recyclerviewOnItemClick
    }

    fun setList(mListView: ArrayList<TestBean>) {
        mList.clear()
        mList.addAll(mListView)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return TestAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_testadapter, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        if (holder != null) {
            if (mClick != null) {
                holder.item.setOnClickListener(View.OnClickListener {
                    mClick!!.onItemClick(holder.item, position)
                })
            }

            holder.textview.text = ("  <----看左边的美女" + mList.get(position).nameStr)
            GlidePicUtils.LoadImg(mContext, holder.imageview, mList.get(position).picStr)
            holder.textview.setOnClickListener(TextViewClick(position))
        } else {
            LogUtils.Loge("holder是空的")
        }
    }


    /**
     * adapter中的点击事件，这里需要注意，在内部类中不能访问外部类的属性，需要在内部类前添加“inner”关键字
     */
    inner class TextViewClick(private val index: Int) : View.OnClickListener {
        override fun onClick(v: View?) {
            T.shortToast(mContext, "适配器里边：点击了第${index}个" + mList.get(index).nameStr)
        }
    }


    override fun getItemCount(): Int {
        return mList.size
    }


    class MyViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        var imageview: ImageView = item.find(R.id.itemAdapterImg)
        var textview: TextView = item.find(R.id.itemAdapterTv)
    }

}