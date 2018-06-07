package com.android.teaching.chatapp.Views;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.teaching.chatapp.Models.MessageModel;
import com.android.teaching.chatapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;


public class NewMessageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText user;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_new_message );

        user = findViewById( R.id.editTextUSR );
        message = findViewById( R.id.toolbarMSG );

        toolbar = findViewById( R.id.toolbarMSG );
        toolbar.setTitle( getResources().getString( R.string.anewmessage ) );
        setSupportActionBar( toolbar );
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled( true );


    }

    public void onClickEnviar(View view) {
        if(user.getText().toString().isEmpty()){
            user.setError( getResources().getString( R.string.errorUser ) );
        }else if(message.getText().toString().isEmpty()){
            message.setError( getResources().getString( R.string.errorMsg ) );
        }else{
            MessageModel msg = new MessageModel();
            msg.setUsername( user.getText().toString() );
            msg.setText( message.getText().toString() );


            ConnectivityManager myConnectivtyManager = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
            NetworkInfo myNetworkInfo = myConnectivtyManager.getActiveNetworkInfo();
            boolean hasConnectivity = myNetworkInfo != null && myNetworkInfo.isConnectedOrConnecting();

            if(hasConnectivity){
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference chatAppRef = database.getReference("messages").child( FirebaseInstanceId.getInstance().getId() );
                chatAppRef.setValue( msg );

                Intent msgSendIntent = new Intent( this, ChatActivity.class );
                startActivity( msgSendIntent );
            }
            else {
                Toast.makeText(this, "You don't have Internet connection!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
