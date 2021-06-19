package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Add_Quiz_2 extends AppCompatActivity {

    EditText question;
    Button btn_add_question;
    Button view_question;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz2);
        question = findViewById(R.id.question_type_2);
        btn_add_question =findViewById(R.id.add_btn);
        view_question = findViewById(R.id.view_btn);
        openHelper = new DatabaseHelper(this);
        Intent key_intent=getIntent();
        key= key_intent.getExtras().getString("Key");

        //type and add question here
        btn_add_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String statement = question.getText().toString();


                if(statement.length()!=0){

                    db = openHelper.getWritableDatabase();
                    insertData(statement,key);
                    question.setText("");


                }
                else{

                    Toast.makeText(Add_Quiz_2.this, "ADD QUESTION IN THE TEXT BOX.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //view remaining questions
        view_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Add_Quiz_2.this , Fill_in_the_blank_quiz.class);
                startActivity(intent);
            }
        });
    }

    //adding data in database
    private void insertData(String statement,String key) {

        ContentValues contentValues = new ContentValues();
       // contentValues.put(DatabaseHelper.COL_2 , type);
        contentValues.put(DatabaseHelper.COL_6, key);
        contentValues.put(DatabaseHelper.COL_8 , statement);

        long id=db.insert(DatabaseHelper.TABLE_NAME2,null , contentValues);

        if(id == -1){

            Toast.makeText(this, "data write failed", Toast.LENGTH_SHORT).show();

        }

        else{


            Toast.makeText(this, "data write successful", Toast.LENGTH_SHORT).show();
        }



    }
}