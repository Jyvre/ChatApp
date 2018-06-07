package com.android.teaching.chatapp.Views;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.android.teaching.chatapp.R;


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
            
        }
    }
}
