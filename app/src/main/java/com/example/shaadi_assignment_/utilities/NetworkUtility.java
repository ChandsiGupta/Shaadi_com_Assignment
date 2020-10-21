package com.example.shaadi_assignment_.utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;

import com.example.shaadi_assignment_.model.UserProfile;

import java.util.List;

public class NetworkUtility {
    
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    
    public static void syncProfiles(Context context) {
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        List<UserProfile> userList = userDatabase.userDao().syncProfile();
        iterateList(userList, context);
        
    }
    
    private static void iterateList(List<UserProfile> userList, Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        for (UserProfile user : userList) {
            //dummy api call to send profile status
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 300);
    }
    
}
