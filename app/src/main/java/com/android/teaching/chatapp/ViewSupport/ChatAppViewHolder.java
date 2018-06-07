package com.android.teaching.chatapp.ViewSupport;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.teaching.chatapp.Models.MessageModel;
import com.android.teaching.chatapp.R;

public class ChatAppViewHolder extends RecyclerView.ViewHolder {

    private TextView userTextView;
    private TextView msgTextView;

    public ChatAppViewHolder(View itemView) {
        super( itemView );
        userTextView = itemView.findViewById( R.id.userTextViewHolder );
        msgTextView = itemView.findViewById( R.id.msgTextViewHolder );

    }

    public void bind(MessageModel message){
        userTextView.setText( message.getUsername() );
        msgTextView.setText( message.getText() );
    }


}
