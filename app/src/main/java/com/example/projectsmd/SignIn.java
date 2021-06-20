package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

//this is sign in class
//student and teacher go to thier pages afer clicking on sign in btn
public class SignIn extends AppCompatActivity {

    private Spinner userSpinner;
    private Button btn;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText email , username,password;


    ArrayList <String> user = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        setTitle("Sign In");
        openHelper = new DatabaseHelper(this);
        btn = findViewById(R.id.signInBtn2);
        userSpinner = findViewById(R.id.userType);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.pwd);



        populate_UserType();

        //getting inputs on sign in button click
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = openHelper.getWritableDatabase();

                String choice = userSpinner.getSelectedItem().toString();
                String userEmail = email.getText().toString();
                String userName = username.getText().toString();
                String userPassword = password.getText().toString();
                insertData(choice , userEmail,userName , userPassword);

                Toast.makeText(SignIn.this, "register successfully", Toast.LENGTH_SHORT).show();
                if (choice.toLowerCase().equals("teacher")) {

                    Intent teacher_intent = new Intent(SignIn.this, Teacher_Module.class);
                    startActivity(teacher_intent);
                }

                if (choice.toLowerCase().equals("student")) {

                    Intent student_intent = new Intent(SignIn.this, Student_Module.class);
                    startActivity(student_intent);
                }

            }
        });


    }

    //this function writes user credentials to database
    public void insertData(String type , String userEmail , String userName , String userPassword){

        //this class is putting values in database
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2 , type);
        contentValues.put(DatabaseHelper.COL_3 , userEmail);
        contentValues.put(DatabaseHelper.COL_4 , userName);
        contentValues.put(DatabaseHelper.COL_5 , userPassword);
        long id=db.insert(DatabaseHelper.TABLE_NAME,null , contentValues);

        if(id == -1){

            Toast.makeText(this, "data write failed", Toast.LENGTH_SHORT).show();

        }

        else{


            Toast.makeText(this, "data write successful", Toast.LENGTH_SHORT).show();
        }




    }

    //setting user types here
    private void populate_UserType() {


        userSpinner = findViewById(R.id.userType);

        user.add("Teacher");
        user.add("Student");

        ArrayAdapter<String> userAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, user);

        userSpinner.setAdapter(userAdapter);
    }
}