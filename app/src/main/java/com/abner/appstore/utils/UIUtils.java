package com.abner.appstore.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.abner.appstore.global.AppStore;

/**
 * Project   com.abner.appstore.utils
 *
 * @Author Abner
 * Time   2016/11/2.13:05
 */

public class UIUtils {

    public static Context getContext() {
        return AppStore.getContext();
    }

    public static Handler getHandler() {
        return AppStore.getHandler();
    }

    public static int getMainThreadId() {
        return AppStore.getMainThreadID();
    }

    /////////////////获取资源///////////////////////////////

    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }

    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    public static Drawable getDrawable(int id) {
        return ContextCompat.getDrawable(getContext(), id);
    }

    public static int getColor(int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    public static ColorStateList getColorStateList(int id) {
        return ContextCompat.getColorStateList(getContext(), id);
    }

    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id);  //返回像素值
    }

    //////////////////dip和px转换///////////////////////////
    public static int dip2px(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f);
    }

    public static float px2dip(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

    /////////////////家在布局文件///////////////////////////////////
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    /////////////////主线程///////////////////////////////////
    public static boolean isRunOnUIThread() {
        return android.os.Process.myTid() == AppStore.getMainThreadID();
    }

    public static void runOnMainThread(Runnable r) {
        if (isRunOnUIThread()) {
            r.run();
        } else {
            getHandler().post(r);
        }
    }


}
