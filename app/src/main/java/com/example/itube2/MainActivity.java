package com.example.itube2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button login;
    Button signup;
    EditText username,password;
    String usernametext = "";
    String passwordtext = "";
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);


        myDatabaseHelper = new MyDatabaseHelper(this);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernametext = username.getText().toString();
                passwordtext = password.getText().toString();

                if (usernametext.equals("") || passwordtext.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter your username and password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean check = myDatabaseHelper.checkUsernamePassword(usernametext, passwordtext);

                    if (check == true){
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, getpage.class);

                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,signuppage.class);
                startActivity(intent);
            }
        });

    }
}