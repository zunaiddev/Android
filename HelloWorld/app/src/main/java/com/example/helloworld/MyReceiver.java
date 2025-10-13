package com.example.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isOn = intent.getBooleanExtra("state", false);
        System.out.println("Airplane Mode: " + isOn);
    }
}
