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
import android.widget.TextView;
import android.widget.Toast;

public class Add_Quiz_1 extends AppCompatActivity {

    EditText statement ;
    EditText option1;
    EditText option2;
    EditText option3;
    EditText option4;
    Button add_question;
    Button view_question;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz1);
        statement = findViewById(R.id.question_statement);
        option1 = findViewById(R.id.op1);
        option2 = findViewById(R.id.op2);
        option3 = findViewById(R.id.op3);
        option4 = findViewById(R.id.op4);
        add_question = findViewById(R.id.add_btn);
        view_question = findViewById(R.id.view_btn);
        openHelper = new DatabaseHelper(this);
        databaseHelper = new DatabaseHelper(this);

        add_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String main_text = statement.getText().toString();
                String op1 = option1.getText().toString();
                String op2 = option2.getText().toString();
                String op3 = option3.getText().toString();
                String op4 = option4.getText().toString();

                if(main_text.length()!=0 && op1.length()!=0 && op2.length()!=0 && op3.length()!=0 && op4.length()!=0 ){

                    insertData(main_text , op1 , op2 , op3 , op4);

                }

                else{

                    Toast.makeText(Add_Quiz_1.this, "Fill all the blanks", Toast.LENGTH_SHORT).show();


                }


            }
        });

        view_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mcq_intent  =  new Intent(Add_Quiz_1.this , MCQS_Quiz.class);
                startActivity(mcq_intent);
            }
        });

    }

    public void insertData(String main_text , String op1 , String op2 ,String op3 ,String op4){

        db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_10 , main_text);
        contentValues.put(DatabaseHelper.COL_11 , op1);
        contentValues.put(DatabaseHelper.COL_12 , op2);
        contentValues.put(DatabaseHelper.COL_13 , op3);
        contentValues.put(DatabaseHelper.COL_14 , op4);

        long id = db.insert(DatabaseHelper.TABLE_NAME3, null, contentValues);

        if(id== -1){

            Toast.makeText(this, "Data write failed", Toast.LENGTH_SHORT).show();
        }

        else{

            Toast.makeText(this, "Data write success", Toast.LENGTH_SHORT).show();
        }



    }
}