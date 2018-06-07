package com.android.teaching.chatapp.Views;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.teaching.chatapp.Models.MessageModel;
import com.android.teaching.chatapp.R;
import com.android.teaching.chatapp.ViewSupport.ChatAppRecyclerViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedHashMap;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView chatAppRecyclerView;
    private ChatAppRecyclerViewAdapter chatAppRecyclerViewAdapter;
    private Toolbar toolbar;
    private LinkedHashMap content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chat );



        toolbar = findViewById( R.id.mainToolbar );
        toolbar.setTitleTextColor( getResources().getColor( R.color.colorPureWhite ) );
        toolbar.setBackgroundColor( getResources().getColor( R.color.colorPrimary ) );
        setSupportActionBar( toolbar );

        chatAppRecyclerView = findViewById( R.id.recycler_view );

        RecyclerView.LayoutManager chatAppLayoutManager = new LinearLayoutManager( this );
        chatAppRecyclerView.setLayoutManager( chatAppLayoutManager );

        content = new LinkedHashMap();

        ConnectivityManager myConnectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo myNetworkInfo = myConnectivtyManager.getActiveNetworkInfo();
        boolean hasConnectivity = myNetworkInfo != null && myNetworkInfo.isConnectedOrConnecting();

        if(hasConnectivity){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference msgDatabaseReference = database.getReference("messages");
            msgDatabaseReference.addValueEventListener( new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int i = 0;
                    for(DataSnapshot msgSnapshot : dataSnapshot.getChildren()){
                        MessageModel msg = dataSnapshot.getValue(MessageModel.class);
                        content.put( i,msg );
                        i++;
                    }
                    chatAppRecyclerViewAdapter = new ChatAppRecyclerViewAdapter( content );
                    chatAppRecyclerView.setAdapter( chatAppRecyclerViewAdapter );
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            } );

        } else{
            Toast.makeText(this, "You don't have Internet connection!", Toast.LENGTH_LONG).show();
        }
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
