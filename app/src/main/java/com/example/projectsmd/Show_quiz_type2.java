package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Show_quiz_type2 extends AppCompatActivity {

    private Button submit;
    private ListView lv;
    DatabaseHelper databaseHelper;
    ArrayList<String> questions = new ArrayList<>();
    Adapter2 display_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quiz_type2);

        submit = findViewById(R.id.btnSubmitType2);
        lv = findViewById(R.id.type2_QuestionsList);
        databaseHelper = new DatabaseHelper(this);

        retrieveData();


    }

    private void retrieveData() {

        Cursor data = databaseHelper.getQuestionType1List();

        if(data.getCount()==0){

            Toast.makeText(this, "no quiz found.", Toast.LENGTH_SHORT).show();
        }

        else {

            while (data.moveToNext()){

                questions.add(data.getString(1));


            }

            display_adapter = new Adapter2(this , 0 ,questions);
            lv.setAdapter(display_adapter);


        }


    }
}