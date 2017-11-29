package com.example.weatherwithkotlin.http.retrofitUtils

/**
 * 作者：dell or Xiaomi Li
 * 时间： 2017/11/29
 * 内容：
 * 最后修改：
 */
class HttpCode {
    //    ok	数据正常
//    invalid key	错误的key，请检查你的key是否输入以及是否输入有误
//    unknown location	未知或错误城市/地区
//    no data for this location	该城市/地区没有你所请求的数据
//    no more requests	超过访问次数，需要等到当月最后一天24点后进行访问次数的重置或升级你的访问量
//    invalid param	参数错误，请检查你传递的参数是否正确
//    too fast	超过限定的QPM，请参考QPM说明
//    dead	无响应或超时，接口服务异常请联系我们
//    permission denied	无访问权限，你没有购买你所访问的这部分服务


    companion object {
        fun ToMessage(code: String): String {
            var message = "请求成功"
            when (code) {
                "ok" -> message = "请求成功"
                "invalid key" -> message = "错误的key，请检查你的key是否输入以及是否输入有误"
                "unknown location" -> message = "未知或错误城市/地区"
                "no data for this location" -> message = "该城市/地区没有你所请求的数据"
                "no data for this location" -> message = "该城市/地区没有你所请求的数据"
                "no more requests" -> message = "超过访问次数，需要等到当月最后一天24点后进行访问次数的重置或升级你的访问量"
                "invalid param" -> message = "参数错误，请检查你传递的参数是否正确"
                "too fast" -> message = "超过限定的QPM，请参考QPM说明"
                "too fast" -> message = "超过限定的QPM，请参考QPM说明"
                "dead" -> message = "无响应或超时，接口服务异常请联系我们"
                "permission denied" -> message = "无访问权限，你没有购买你所访问的这部分服务"
            }
            return message
        }
    }
}