package com.example.itube2;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList id;
    ArrayList url;
    Activity activity;

    public MyAdapter(Activity activity, Context context, ArrayList id, ArrayList url) {
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.url = url;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recvlayout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.URL.setText(String.valueOf(url.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView URL;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            URL = itemView.findViewById(R.id.textView);
        }
    }
}

