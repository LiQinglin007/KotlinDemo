package com.example.weatherwithkotlin.http.retrofitUtils;

import rx.Subscriber;

/**
 * 类描述：
 * 作  者：dell or 李小米
 * 时  间：2017/11/21
 * 修改备注：
 */
public abstract class RetrofitSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onFailure(e);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }


    public abstract void onSuccess(T response);

    public abstract void onFailure(Throwable e);

}
