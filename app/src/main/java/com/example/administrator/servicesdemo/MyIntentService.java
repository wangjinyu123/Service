package com.example.administrator.servicesdemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;


public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    public MyIntentService() {
        super("MyIntentService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: 开启");
        if (intent != null) {
            final String action = intent.getAction();
        
        }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: 销毁");
        super.onDestroy();
    }
}
