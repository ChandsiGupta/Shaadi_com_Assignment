package com.example.shaadi_assignment_;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shaadi_assignment_.dto.GenericUserDTO;
import com.example.shaadi_assignment_.model.database.User;
import com.example.shaadi_assignment_.utilities.UserDatabase;
import com.example.shaadi_assignment_.utilities.NetworkUtility;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> implements View.OnClickListener {
    
    Context context;
    List<GenericUserDTO> shaadiProfileList;
    UserDatabase userDatabase;
    
    public RecyclerAdapter(Context context, List<GenericUserDTO> shaadiProfileList) {
        this.context = context;
        this.shaadiProfileList = shaadiProfileList;
    }
    
    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter, parent, false);
        return new MyviewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(RecyclerAdapter.MyviewHolder holder, int position) {
        bindView(holder, position);
        userDatabase = UserDatabase.getInstance(context);
        holder.btnAccept.setOnClickListener(v -> {
            Toast.makeText(context, "Profile Accepted", Toast.LENGTH_LONG).show();
            User user = new User(shaadiProfileList.get(position).getEmail(), shaadiProfileList.get(position).getFirst(), shaadiProfileList.get(position).getLast(), shaadiProfileList.get(position).getGender(), shaadiProfileList.get(position).getAge(), shaadiProfileList.get(position).getThumbnail(), shaadiProfileList.get(position).getLocation(), "Accept", NetworkUtility.isNetworkConnected(context));
            if (userDatabase.userDao().isUserExist(shaadiProfileList.get(position).email) == null) {
                userDatabase.userDao().insertUser(user);
            }
            holder.status_layout.setVisibility(View.GONE);
            holder.profileStatus.setVisibility(View.VISIBLE);
        });
        holder.btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Profile Rejected", Toast.LENGTH_LONG).show();
                User user = new User(shaadiProfileList.get(position).getEmail(), shaadiProfileList.get(position).getFirst(), shaadiProfileList.get(position).getLast(), shaadiProfileList.get(position).getGender(), shaadiProfileList.get(position).getAge(), shaadiProfileList.get(position).getThumbnail(), shaadiProfileList.get(position).getLocation(), "Decline", NetworkUtility.isNetworkConnected(context));
                userDatabase.userDao().insertUser(user);
                holder.status_layout.setVisibility(View.GONE);
                holder.profileStatus.setVisibility(View.VISIBLE);
                holder.profileStatus.setText(R.string.decline_status);
            }
        });
    }
    
    public void bindView(RecyclerAdapter.MyviewHolder holder, int position) {
        holder.tvName.setText(shaadiProfileList.get(position).getFirst() + shaadiProfileList.get(position).getLast());
        holder.tvAge.setText(""+shaadiProfileList.get(position).getAge());
        holder.tvGender.setText(shaadiProfileList.get(position).getGender());
        holder.tvAddress.setText(shaadiProfileList.get(position).getLocation());
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        String status = checkUserExistStatus(shaadiProfileList.get(position).getEmail());
        if (status == null) {
            holder.status_layout.setVisibility(View.VISIBLE);
            holder.profileStatus.setVisibility(View.GONE);
        } else {
            holder.status_layout.setVisibility(View.GONE);
            holder.profileStatus.setVisibility(View.VISIBLE);
            if (status.equalsIgnoreCase("Accept")) {
                holder.profileStatus.setText(R.string.accept_status);
            } else {
                holder.profileStatus.setText(R.string.decline_status);
            }
        }
        Glide.with(context).load(shaadiProfileList.get(position).getThumbnail()).apply(RequestOptions.centerCropTransform()).into(holder.image);
        
    }
    
    @Override
    public int getItemCount() {
        if (shaadiProfileList != null) {
            return shaadiProfileList.size();
        }
        return 0;
        
    }
    
    @Override
    public void onClick(View v) {
    
    
    }
    
    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAge, tvGender, tvAddress, btnAccept, btnDecline, profileStatus;
        ImageView image;
        LinearLayout status_layout;
        
        public MyviewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name);
            tvGender = (TextView) itemView.findViewById(R.id.gender);
            tvAge = (TextView) itemView.findViewById(R.id.age);
            profileStatus = (TextView) itemView.findViewById(R.id.profile_status);
            status_layout = (LinearLayout) itemView.findViewById(R.id.status_layout);
            tvAddress = (TextView) itemView.findViewById(R.id.add);
            btnAccept = (TextView) itemView.findViewById(R.id.accept);
            btnDecline = (TextView) itemView.findViewById(R.id.decline);
            image = (ImageView) itemView.findViewById(R.id.image);
            
        }
    }
    
    public String checkUserExistStatus(String email) {
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        if (userDatabase.userDao().isUserExist(email) != null) {
            User user = userDatabase.userDao().isUserExist(email);
            
            return user.getStatus();
        }
        return null;
    }
    
}
