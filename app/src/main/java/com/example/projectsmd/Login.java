package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private Spinner userSpinner;
    private Button btn;
    EditText username;
    EditText password;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    protected ArrayList<String> user = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");
        btn = findViewById(R.id.logInBtn2);
        userSpinner = findViewById(R.id.userType);
        username = findViewById(R.id.username);
        password = findViewById(R.id.pwd);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();


        populate_UserType();


        //getting text from text boxes and checking if exists in database
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String choice = userSpinner.getSelectedItem().toString();
                String name = username.getText().toString();
                String pass = password.getText().toString();
                /*cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME +
                        "WHERE " + DatabaseHelper.COL_4 + "=? AND " +  DatabaseHelper.COL_5 + " =?" ,new String[]{name , pass} );*/
                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_2 + "=? AND " + DatabaseHelper.COL_4 + "=? AND " + DatabaseHelper.COL_5 + "=?", new String[]{choice, name, pass});

                if (cursor != null) {

                    if (cursor.getCount() > 0) {

                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        if (choice.toLowerCase().equals("teacher")) {

                            Intent teacher_intent = new Intent(Login.this, Teacher_Module.class);
                            startActivity(teacher_intent);
                        }

                        if (choice.toLowerCase().equals("student")) {

                            Intent student_intent = new Intent(Login.this, Student_Module.class);
                            startActivity(student_intent);
                        }

                    } else {

                        Toast.makeText(Login.this, "You are not registered.Sign In to get started", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
    }

    //setting spinner data
    private void populate_UserType() {

        userSpinner = findViewById(R.id.userType);

        user.add("Teacher");
        user.add("Student");

        ArrayAdapter<String> userAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, user);

        userSpinner.setAdapter(userAdapter);
    }


}