package com.example.weatherwithkotlin.http.okhttpUtils;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类描述：okhttp回调
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */

public abstract class MOkCallBack implements Callback {

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(Call call, final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailure(e);
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String str = response.body().string();
        handler.post(new Runnable() {
            @Override
            public void run() {
                onSuccess(str);
            }
        });
    }


    public abstract void onSuccess(String response);

    public abstract void onFailure(Throwable e);

}
