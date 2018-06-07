package com.android.teaching.chatapp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.teaching.chatapp.R;
import com.android.teaching.chatapp.ViewSupport.ChatAppRecyclerViewAdapter;
import java.util.LinkedHashMap;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView chatAppRecyclerView;
    private ChatAppRecyclerViewAdapter chatAppRecyclerViewAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chat );

        toolbar = findViewById( R.id.mainToolbar );
        setSupportActionBar( toolbar );

        chatAppRecyclerView = findViewById( R.id.recycler_view );

        RecyclerView.LayoutManager chatAppLayoutManager = new LinearLayoutManager( this );
        chatAppRecyclerView.setLayoutManager( chatAppLayoutManager );

        LinkedHashMap content = new LinkedHashMap(  );
        chatAppRecyclerViewAdapter = new ChatAppRecyclerViewAdapter( content );

        chatAppRecyclerView.setAdapter( chatAppRecyclerViewAdapter );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.main_toolbar,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent msgIntent = new Intent( this, NewMessageActivity.class );
        startActivity( msgIntent );
        return true;
    }
}
