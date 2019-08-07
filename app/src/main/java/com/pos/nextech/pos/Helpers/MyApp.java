package com.pos.nextech.pos.Helpers;

import android.app.Application;
import android.content.Context;


import com.zcs.sdk.DriverManager;
import com.zcs.sdk.card.CardInfoEntity;

/**
 * Created by yyzz on 2018/5/18.
 */

public class MyApp extends Application {
    public static DriverManager sDriverManager;
    public  static CardInfoEntity cardInfoEntity;
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        sDriverManager = DriverManager.getInstance();
        cardInfoEntity = new CardInfoEntity();
        context = getApplicationContext();
        //在这里为应用设置异常处理程序，然后我们的程序才能捕获未处理的异常

    }
}
