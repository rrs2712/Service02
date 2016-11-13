package com.mdp.lab03.service02;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by rrs27 on 2016-10-30.
 */

public class MyBoundService extends Service {

    final private String ACT ="Act02 MyBoundService";
    final private IBinder iBinder = new MyBinder();
    private  int counter =1;

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(ACT, "onBind");
        return iBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(ACT,"onCreate(); Therefore counter = 1");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(ACT,"onDestroy");
    }

    public class MyBinder extends Binder{

        void  countUp(){
            MyBoundService.this.countUp();
        }

        void countDown(){
            MyBoundService.this.countDown();
        }
    }

    public void countUp() {
        counter++;
        Log.d(ACT,"countUp called, counter = " + counter);
    }

    public void countDown() {
        counter--;
        Log.d(ACT,"countDown called, counter = " + counter);
    }
}
