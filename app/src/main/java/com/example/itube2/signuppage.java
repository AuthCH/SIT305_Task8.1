package com.example.itube2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signuppage extends AppCompatActivity {

    Button create;
    EditText fullnameinput,usernameinput,passwordinput,conpasswordinput;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        fullnameinput = findViewById(R.id.fullnameinput);
        usernameinput = findViewById(R.id.usernameinput);
        passwordinput = findViewById(R.id.passwordinput);
        conpasswordinput = findViewById(R.id.conpasswordinput);

        create = findViewById(R.id.button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = fullnameinput.getText().toString();
                String username = usernameinput.getText().toString();
                String password = passwordinput.getText().toString();
                String conpass = conpasswordinput.getText().toString();

                myDatabaseHelper = new MyDatabaseHelper(signuppage.this);

                if (fullname.equals("") || username.equals("") || password.equals("") || conpass.equals("")) {
                    Toast.makeText(signuppage.this, "Please enter you information", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(conpass)) {
                        Boolean checkUsername = myDatabaseHelper.checkUsername(username);

                        if (checkUsername == false) {
                            Boolean insert = myDatabaseHelper.insertData(fullname, username, password);

                            if (insert == true) {
                                Toast.makeText(signuppage.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(signuppage.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(signuppage.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(signuppage.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}