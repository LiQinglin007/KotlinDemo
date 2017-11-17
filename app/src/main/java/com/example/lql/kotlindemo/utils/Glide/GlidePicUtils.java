package com.example.lql.kotlindemo.utils.Glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.lql.kotlindemo.R;


/**
 * 类描述：glide加载图片
 * 作  者：李清林
 * 时  间：
 * 修改备注：
 */
public class GlidePicUtils {
    private static RequestOptions requestOptions;

    /**
     * 加载普通图片
     *
     * @param mContext
     * @param imageView
     * @param url
     */
    public static void LoadImg(Context mContext, ImageView imageView, String url) {
        if (check(mContext, imageView, url)) {
            GlideApp.with(mContext).asBitmap()
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .preload();

            GlideApp.with(mContext)
                    .asBitmap()
                    .load(url)
                    .error(R.drawable.errorpic)
                    .placeholder(R.drawable.errorpic)
                    .fallback(R.drawable.errorpic)//当url为空时，显示图片
                    .into(imageView);
        } else {
            Toast.makeText(mContext, "参数不正确", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 加载圆形图片
     *
     * @param mContext
     * @param imageView
     * @param url
     */
    public static void LoadCircleImg(Context mContext, ImageView imageView, String url) {
        if (check(mContext, imageView, url)) {

            GlideApp.with(mContext).asBitmap()
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .preload();

            RequestBuilder<Bitmap> bitmapRequestBuilder = CreatRequestBuilder(mContext, url);

            if (requestOptions == null) {
                requestOptions = CreateOption();
            }

            //在RequestOptions中使用Transformations
            requestOptions.transform(new CircleTransform(mContext));

            //RequestBuilder<Bitmap> 中添加RequestOptions
            bitmapRequestBuilder.apply(requestOptions).into(imageView);
        } else {
            Toast.makeText(mContext, "参数不正确", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 加载圆角图片
     *
     * @param mContext
     * @param imageView
     * @param url
     */
    public static void LoadRoundImg(Context mContext, ImageView imageView, String url, int radius) {
        if (check(mContext, imageView, url)) {

            GlideApp.with(mContext).asBitmap()
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .preload();

            RequestBuilder<Bitmap> bitmapRequestBuilder = CreatRequestBuilder(mContext, url);

            if (requestOptions == null) {
                requestOptions = CreateOption();
            }

            //在RequestOptions中使用Transformations
            requestOptions.transform(new RoundTransform(mContext, radius));

            //RequestBuilder<Bitmap> 中添加RequestOptions
            bitmapRequestBuilder.apply(requestOptions).into(imageView);
        } else {
            Toast.makeText(mContext, "参数不正确", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 加载资源文件
     *
     * @param mContext
     * @param imageView
     * @param requestId
     */
    public static void LoadRequest(Context mContext, ImageView imageView, int requestId) {
        RequestBuilder<Drawable> drawableRequestBuilder = GlideApp.with(mContext).
                load(requestId);
        drawableRequestBuilder.into(imageView);
    }


    private static RequestBuilder<Bitmap> CreatRequestBuilder(Context mContext, String url) {
        RequestBuilder<Bitmap> bitmapRequestBuilder = GlideApp.with(mContext)
                .asBitmap()//指定Bitmap类型的RequestBuilder
                .load(url)//网络URL
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
                .error(R.drawable.errorpic)
                .placeholder(R.drawable.errorpic)
                .fallback(R.drawable.errorpic);//当url为空时，显示图片
        return bitmapRequestBuilder;
    }


    private static RequestOptions CreateOption() {
        return new RequestOptions();
    }


    /**
     * 检查参数是否为空
     *
     * @param mContext
     * @param img
     * @param url
     * @return
     */
    private static boolean check(Context mContext, ImageView img, String url) {
        if (null == mContext || null == img || null == url || TextUtils.isEmpty(url)) {
            return false;
        } else {
            return true;
        }
    }
}
