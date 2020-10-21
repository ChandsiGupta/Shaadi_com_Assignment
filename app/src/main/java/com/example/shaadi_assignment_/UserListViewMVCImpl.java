package com.example.shaadi_assignment_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shaadi_assignment_.dto.GenericUserDTO;

import java.util.List;

public class UserListViewMVCImpl implements UserListViewMVC {
    View root;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    
    public UserListViewMVCImpl(LayoutInflater inflater, ViewGroup parent) {
        root = inflater.inflate(R.layout.activity_main, parent, false);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }
    
    private Context getContext() {
        return getRootView().getContext();
    }
    
    private View findViewById(int recycler_view) {
        return getRootView().findViewById(recycler_view);
        
    }
    
    
    @Override
    public View getRootView() {
        return root;
    }
    
    @Override
    public void bindData(List<GenericUserDTO> shaadiProfileList) {
        recyclerAdapter = new RecyclerAdapter(getContext(), shaadiProfileList);
        recyclerView.setAdapter(recyclerAdapter);
    }
    
    
}
