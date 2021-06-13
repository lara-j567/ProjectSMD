package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//adding fill in the blonk quiz here
public class Fill_in_the_blank_quiz extends AppCompatActivity {

    private Button addQuizBtn;
    private ListView lv1;
    ArrayList<String> fetchedQuestions = new ArrayList<>();
 //   SQLiteOpenHelper sqLiteOpenHelper;
  //  SQLiteDatabase db;
    Cursor cursor;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_the_blank_quiz);

        addQuizBtn = findViewById(R.id.btnAddQuestionType2);
        lv1 = findViewById(R.id.list1);
       // sqLiteOpenHelper = new DatabaseHelper(this);
        //db = sqLiteOpenHelper.getReadableDatabase();
        databaseHelper = new DatabaseHelper(this);
        getDatafromDB();
        //if not data present or want to add data
        addQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add_question = new Intent(Fill_in_the_blank_quiz.this, Add_Quiz_2.class);
                startActivity(add_question);


            }
        });


    }

    //checking if there is data in database in table
    private void getDatafromDB() {


        Cursor data = databaseHelper.getQuestionType1List();
       // cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME2, null);
        if(data.getCount()==0){

            Toast.makeText(this, "no question", Toast.LENGTH_SHORT).show();
        }

        else {

            while(data.moveToNext()){

                fetchedQuestions.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , fetchedQuestions);
                lv1.setAdapter(listAdapter);

            }
        }


    }
}