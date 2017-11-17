package com.example.lql.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.lql.kotlindemo.R
import com.example.lql.kotlindemo.adapter.TestAdapter
import com.example.lql.kotlindemo.bean.TestBean
import com.example.lql.kotlindemo.utils.RecyclerView.OnItemClickListener
import com.example.lql.kotlindemo.utils.T
import kotlinx.android.synthetic.main.activity_recyclerview.*


/**
 * 类描述：列表页面
 * 作  者：李小米
 * 时  间：2017.11.13
 * 修改备注：
 */
class RecyclerVeiwActivity : AppCompatActivity() {

    var mTestAdapter: TestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        initView()
    }

    private fun initView() {
        var mList = ArrayList<String>()
        var mListBean = ArrayList<TestBean>()

        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205553.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205544.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205538.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205534.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205530.jpg")

        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205524.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205520.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205514.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205507.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205500.jpg")

        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205457.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205450.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205454.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205558.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205604.jpg")
        mList.add("http://img.tupianzj.com/uploads/allimg/160604/16-160604205F6.jpg")


        for (index in mList.indices) {
            var mTestBean = TestBean()
            mTestBean.nameStr = "小米${index}"
            mTestBean.picStr = mList.get(index)
            mListBean.add(mTestBean)
        }



        mRecyclerview.layoutManager = LinearLayoutManager(this)
        mTestAdapter = TestAdapter(this)
        mTestAdapter!!.setList(mListBean)
        mRecyclerview.adapter = mTestAdapter

        mTestAdapter!!.setOnItemClickListener(OnItemClickListener { view, position ->
            T.shortToast(this, "adapter的点击事件${position}")
        })
    }


}