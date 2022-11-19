package com.example.jsonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{

    private ArrayList<Models> modelsArrayList;
    private Context context;

    public MyAdapter(ArrayList<Models> modelsArrayList, Context context) {
        this.modelsArrayList = modelsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position)
    {
        holder.id.setText("Id:- " + modelsArrayList.get(position).getId()+"\n");
        holder.title.setText("Title:- " + modelsArrayList.get(position).getTitle()+"\n");
        holder.body.setText("Body:- " + modelsArrayList.get(position).getBody()+"\n");



    }

    @Override
    public int getItemCount() {
        return modelsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,title,body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
