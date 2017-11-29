package com.example.weatherwithkotlin.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/28
 * 内容：
 * 最后修改：
 */
open class BaseActivity : AppCompatActivity() {
    var mSweetAlertDialog: SweetAlertDialog? = null

    fun startLoading(message: String) {
        if (mSweetAlertDialog == null) {
            mSweetAlertDialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
        }
        mSweetAlertDialog!!.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"))
        mSweetAlertDialog!!.setTitleText(message)
        mSweetAlertDialog!!.setCancelable(false)
        mSweetAlertDialog!!.show()
    }

    fun stopLoading() {
        if (mSweetAlertDialog != null) {
            mSweetAlertDialog!!.hide()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (mSweetAlertDialog != null) {
            mSweetAlertDialog!!.dismiss()
        }
    }
}