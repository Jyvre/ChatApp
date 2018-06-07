package com.android.teaching.chatapp.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.teaching.chatapp.R;
import com.android.teaching.chatapp.ViewSupport.ChatAppRecyclerViewAdapter;

import java.util.LinkedHashMap;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView chatAppRecyclerView;
    private ChatAppRecyclerViewAdapter chatAppRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chat );
        chatAppRecyclerView = findViewById( R.id.recycler_view );

        RecyclerView.LayoutManager chatAppLayoutManager = new LinearLayoutManager( this );
        chatAppRecyclerView.setLayoutManager( chatAppLayoutManager );

        LinkedHashMap content = new LinkedHashMap(  );
        chatAppRecyclerViewAdapter = new ChatAppRecyclerViewAdapter( content );

        chatAppRecyclerView.setAdapter( chatAppRecyclerViewAdapter );

    }
}
