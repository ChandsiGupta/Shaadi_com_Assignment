package com.example.shaadi_assignment_.api;

import android.content.Context;
import android.util.Log;

import com.example.shaadi_assignment_.dto.GenericUserDTO;
import com.example.shaadi_assignment_.model.Result;
import com.example.shaadi_assignment_.model.Root;
import com.example.shaadi_assignment_.model.database.User;
import com.example.shaadi_assignment_.modelmapper.GenericUserDTOMapper;
import com.example.shaadi_assignment_.utilities.NetworkUtility;
import com.example.shaadi_assignment_.utilities.UserDatabase;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListAPI {
    private Context context;
    private List<GenericUserDTO> shaadiProfileList = new ArrayList<>();
    
    public UserListAPI(Context context) {
        this.context = context;
    }
    
    public void extractUserList() {
        if (!NetworkUtility.isNetworkConnected(context)) {
            UserDatabase userDatabase = UserDatabase.getInstance(context);
            List<User> userList = userDatabase.userDao().getUserList();
            EventBus.getDefault().post(offlineListiterate(userList));
        } else {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<Root> call = apiService.getUserList("10");
            call.enqueue(new Callback<Root>() {
                @Override
                public void onResponse(Call<Root> call, Response<Root> response) {
                    int x = 0;
                    Log.e("shaadiProfileList", response.toString());
                    List<Result> shadiProfileResult = new ArrayList<>();
                    shadiProfileResult = response.body().getResults();
                    EventBus.getDefault().post(onlineListiterate(shadiProfileResult));
                }
                
                @Override
                public void onFailure(Call<Root> call, Throwable t) {
                    int x = 0;
                }
            });
        }
    }
    
    public List<GenericUserDTO> onlineListiterate(List<Result> onlineShaadiProfileList) {
        for (Result result : onlineShaadiProfileList) {
            shaadiProfileList.add(GenericUserDTOMapper.userApiResponseToGenericUserDTOMapper(result));
        }
        return shaadiProfileList;
    }
    
    public List<GenericUserDTO> offlineListiterate(List<User> offlineShaadiProfileList2) {
        for (User user : offlineShaadiProfileList2) {
            shaadiProfileList.add(GenericUserDTOMapper.userToGenericUserDTOMapper(user));
        }
        return shaadiProfileList;
    }
}
