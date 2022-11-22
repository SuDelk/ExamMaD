package com.example.exam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{
    private ArrayList<Userss> userList;

    public recyclerAdapter(ArrayList<Userss> userList) {
        this.userList = userList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nametxt;
        public MyViewHolder(final View view){
            super(view);
            nametxt = view.findViewById(R.id.newName);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = userList.get(position).getUsername();
        holder.nametxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
