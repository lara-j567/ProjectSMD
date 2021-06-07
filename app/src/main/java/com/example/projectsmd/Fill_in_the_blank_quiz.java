package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fill_in_the_blank_quiz extends AppCompatActivity {

    private Button addQuizBtn;
    private ListView lv1;
    ArrayList <String> fetchedQuestions = new ArrayList<>();
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_the_blank_quiz);

        addQuizBtn= findViewById(R.id.btnAddQuestionType2);
        lv1 = findViewById(R.id.list1);
        sqLiteOpenHelper = new DatabaseHelper(this);
        db = sqLiteOpenHelper.getReadableDatabase();

        getDatafromDB();

        addQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add_question = new Intent(Fill_in_the_blank_quiz.this,Add_Quiz_2.class);
                startActivity(add_question);



            }
        });




    }

    private void getDatafromDB() {

        cursor =db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME2  , null);


        if(cursor!=null){

            Toast.makeText(this, "No questions added yet!Click on add button to add question.", Toast.LENGTH_SHORT).show();


        }
        else {


            Toast.makeText(this, "data", Toast.LENGTH_SHORT).show();

        }


    }
}