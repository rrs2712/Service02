package com.mdp.lab03.service02;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final private String ACT = "Act01 MainActivity";
    private MyBoundService.MyBinder myService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bindService(new Intent(this,MyBoundService.class), serviceConnection, Context.BIND_AUTO_CREATE);
        Log.d(ACT,"onCreate()");
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(ACT, "onServiceConnected()");
            myService = (MyBoundService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(ACT,"onServiceDisconnected");
            myService = null;
        }
    };

    // on Bound Service Up
    public void onBSUp(View v){
        myService.countUp();
    }

    // on Bound Service Down
    public void onBSDown(View v){
        myService.countDown();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ACT,"onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ACT,"onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ACT,"onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ACT,"onStop");
    }
    @Override
    protected void onDestroy() {
        if(serviceConnection!=null){
            unbindService(serviceConnection);
            serviceConnection = null;
        }
        super.onDestroy();
        Log.d(ACT,"onDestroy");
    }
}
