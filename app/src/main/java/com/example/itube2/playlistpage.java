package com.example.itube2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class playlistpage extends AppCompatActivity {
    RecyclerView recyclerView;
    MyDatabaseHelper2 myDatabase2;
    ArrayList<String> id,url;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        recyclerView = findViewById(R.id.recv);

        myDatabase2 = new MyDatabaseHelper2(getApplicationContext());
        id = new ArrayList<>();
        url = new ArrayList<>();

        ArrayData();

        myAdapter = new MyAdapter(playlistpage.this,getApplicationContext(),id,url);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
    void ArrayData(){

        //Add information to arrays
        Cursor cursor = myDatabase2.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                url.add(cursor.getString(1));

            }
        }

    }
}