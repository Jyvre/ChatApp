package com.android.teaching.chatapp.ViewSupport;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.teaching.chatapp.Models.MessageModel;
import com.android.teaching.chatapp.R;

import java.util.LinkedHashMap;

public class ChatAppRecyclerViewAdapter extends RecyclerView.Adapter {

    private LinkedHashMap<Integer, MessageModel> dataSet;

    public ChatAppRecyclerViewAdapter(LinkedHashMap dataSet){
        this.dataSet = dataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.view_holder_item,parent,false );
        return new ChatAppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChatAppViewHolder) holder).bind( dataSet.get( position ));
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

}
