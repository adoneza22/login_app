package com.example.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.MainActivity;
import com.example.login.R;
import com.example.login.item_list.Users;

import org.w3c.dom.Text;

import java.util.List;

public  class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    List<Users> usersList;
    Context context;
    public UsersAdapter(List<Users> usersList){

        this.usersList =  usersList;
        this.context = MainActivity.activity;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = usersList.get(position);

        String username, fullname;
        username = users.getUsername();
        fullname = users.getFullname();

        holder.tv_username.setText(username);
        holder.tv_fullname.setText(fullname);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_username, tv_fullname;
        public ViewHolder (@NonNull View itemView){
            super(itemView);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);

        }
    }
}
