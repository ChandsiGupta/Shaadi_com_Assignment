package com.example.shaadi_assignment_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.example.shaadi_assignment_.api.UserListAPI;
import com.example.shaadi_assignment_.dto.GenericUserDTO;
import com.example.shaadi_assignment_.receiver.NetworkChangeReceiver;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private UserListViewMVC userListViewMVC;
    List<GenericUserDTO> genericUserDTOArrayList = new ArrayList<>();
    private NetworkChangeReceiver networkChangeReceiver;
    private UserListAPI userListAPI;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Register the event bus.
        EventBus.getDefault().register(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Check network connectivity for offline mode
        networkChangeReceiver = new NetworkChangeReceiver();
        //MVC Implementation
        userListViewMVC = new UserListViewMVCImpl(LayoutInflater.from(this), null);
        setContentView(userListViewMVC.getRootView());
       // Extract userlist from database and api as per network connectivity.
        userListAPI = new UserListAPI(this);
        userListAPI.extractUserList();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        // Add network connectivity change action.
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        // Register the broadcast receiver with the intent filter object.
        registerReceiver(networkChangeReceiver, intentFilter);
        
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        //Unregister the broadcast receiver
        unregisterReceiver(networkChangeReceiver);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        // Unregister the event bus.
        EventBus.getDefault().unregister(this);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    
    /**
     * Subscriber callback method
     * @param event
     */
    @Subscribe
    public void onEventMainThread(List<GenericUserDTO> event) {
        genericUserDTOArrayList = event;
        //bind data
        userListViewMVC.bindData(genericUserDTOArrayList);
    }
}
