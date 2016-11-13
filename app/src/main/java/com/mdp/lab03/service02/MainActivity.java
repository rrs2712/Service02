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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(ACT,"onCreate()");
    }

    public void onBSStart(View view){
        Log.d(ACT,"onBSStart");
        this.startService(new Intent(this, MyBoundService.class));
    }

    public void onBSStop(View view){
        Log.d(ACT,"onBSStop");
        Intent i = new Intent(MainActivity.this, MyBoundService.class);
        this.stopService(i);
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
        Log.d(ACT,"onDestroy");
        super.onDestroy();

    }
}
