package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Quiz_Name_Form1 extends AppCompatActivity {

    private EditText quizName;
    private Button btn_makeQuiz;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_name_form1);

        quizName= findViewById(R.id.quizName);
        btn_makeQuiz = findViewById(R.id.makeQuizBtn);
        openHelper = new DatabaseHelper(this);



        btn_makeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = openHelper.getWritableDatabase();
                String name = quizName.getText().toString();
                insertData(name);
                Intent i=new Intent(Quiz_Name_Form1.this , Fill_in_the_blank_quiz.class);
                i.putExtra("Quiz Name", quizName.getText().toString());
                startActivity(i);

            }
        });


    }

    private void insertData(String name) {


        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_16,name);
        contentValues.put(DatabaseHelper.COL_17,name);

        long id=db.insert(DatabaseHelper.TABLE_NAME4, null,contentValues);

        if(id == -1){

            Toast.makeText(this, "data write failed", Toast.LENGTH_SHORT).show();

        }

        else{


            Toast.makeText(this, "data write successful", Toast.LENGTH_SHORT).show();
        }


    }
}