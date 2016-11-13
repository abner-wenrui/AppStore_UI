package com.abner.appstore.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Project   com.abner.appstore.global
 *
 * @Author Abner
 * Time   2016/11/2.12:59
 */

public class AppStore extends Application {

    private static Context context;
    private static Handler handler;
    private static int mainThreadID;

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadID() {
        return mainThreadID;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadID = android.os.Process.myTid();

    }
}
