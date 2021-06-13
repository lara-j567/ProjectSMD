package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

//this is main page appears having login and sign in buttons
public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.logInBtn);
        btn2 = findViewById(R.id.signInBtn);

        //login intent
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);
            }
        });

        //sign in intent
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signin = new Intent(MainActivity.this, SignIn.class);
                startActivity(signin);

            }
        });
    }


}