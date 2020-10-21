package com.example.shaadi_assignment_;

import android.view.View;

import com.example.shaadi_assignment_.dto.GenericUserDTO;

import java.util.List;

public interface UserListViewMVC {
    View getRootView();
    
    void bindData(List<GenericUserDTO> shaadiProfileList);
}
