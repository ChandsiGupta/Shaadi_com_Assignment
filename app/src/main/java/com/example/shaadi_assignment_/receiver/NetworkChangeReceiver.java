package com.example.shaadi_assignment_.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;

import com.example.shaadi_assignment_.utilities.NetworkUtility;

public class NetworkChangeReceiver extends BroadcastReceiver {
    
    @Override
    public void onReceive(final Context context, final Intent intent) {
        final ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        
        final android.net.NetworkInfo wifi = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        
        final android.net.NetworkInfo mobile = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        
        if (wifi.isConnected() || mobile.isConnected()) {
            NetworkUtility.syncProfiles(context);
            Log.d("Network Available ", "Flag No 1");
        }
    }
}