package com.example.itube2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class getpage extends AppCompatActivity {

    Button play,add,playlist;
    EditText input;
    String url;
    MyDatabaseHelper2 myDatabaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getpage);

        input = findViewById(R.id.editTextTextPersonName);
        add = findViewById(R.id.button3);
        playlist = findViewById(R.id.button4);


        play = findViewById(R.id.button2);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/"+ input.getText().toString()+"mp.4";
                url = input.getText().toString();
                Intent intent = new Intent(getpage.this,playpage.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseHelper2 = new MyDatabaseHelper2(getpage.this);
                myDatabaseHelper2.addURL(input.getText().toString().trim());
            }
        });
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getpage.this, playlistpage.class);
                startActivity(intent);
            }
        });
    }
}