package com.android.teaching.chatapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.teaching.chatapp.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chat );
    }
}
