package com.example.weatherwithkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.weatherwithkotlin.R
import com.example.weatherwithkotlin.db.bean.WeatherNowDataBean
import com.example.weatherwithkotlin.utils.Glide.GlidePicUtils
import com.example.weatherwithkotlin.utils.RecyclerView.ItemAnimHelper
import com.example.weatherwithkotlin.utils.RecyclerView.OnItemClickListener
import com.example.weatherwithkotlin.utils.WeatherCodeImg
import org.jetbrains.anko.find

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/27
 * 内容：首页城市列表的adapter
 * 最后修改：
 */
class MainActivityAdapter(mContextView: Context) : RecyclerView.Adapter<MainActivityAdapter.WeatherViewHolder>() {

    var mItemAnimHelper: ItemAnimHelper = ItemAnimHelper()
    private var mContext = mContextView
    private var mList = ArrayList<WeatherNowDataBean>()

    private var mClick: OnItemClickListener? = null

    fun setOnItemClickListener(recyclerviewOnItemClick: OnItemClickListener) {
        mClick = recyclerviewOnItemClick
    }

    fun setList(mListView: ArrayList<WeatherNowDataBean>) {
        mList.clear()
        mList.addAll(mListView)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder?, position: Int) {
        if (holder != null) {
            //点击事件
            if (mClick != null) {
                holder.item.setOnClickListener(View.OnClickListener {
                    mClick!!.onItemClick(holder.itemView, position)
                })
            }

            holder.textview.text = mList.get(position).cityName + ""
            holder.temTextView.text = mList.get(position).tmp + " ℃"
            GlidePicUtils.LoadImg(mContext, holder.imageview, WeatherCodeImg.getImg(mList.get(position).cloudCode))
            mItemAnimHelper.showItemAnim(holder!!.itemView, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherViewHolder {
        return MainActivityAdapter.WeatherViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_weater, parent, false))
    }


    class WeatherViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        var imageview: ImageView = item.find(R.id.itemWeatherImg)
        var textview: TextView = item.find(R.id.itemCityName)
        var temTextView: TextView = item.find(R.id.itemCityTem)
    }
}