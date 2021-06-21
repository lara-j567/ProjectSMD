package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

//main component appering after selection of btn 1 in teacher module and adding quiz name
public class MCQS_Quiz extends AppCompatActivity {

    private Button btn_add;
    private Button btn_publish;
    private ListView lv;
    ArrayList<Mcq> fetchedQuestions = new ArrayList<>();
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqs_quiz);

        btn_add = findViewById(R.id.btnAddQuestionType1);
        btn_publish = findViewById(R.id.btnPublish);
        lv =findViewById(R.id.list1);

        databaseHelper = new DatabaseHelper(this);
        getDatafromDB();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add_question = new Intent(MCQS_Quiz.this, Add_Quiz_1.class);
                startActivity(add_question);


            }
        });

    }

    private void getDatafromDB() {

        Cursor data = databaseHelper.getQuestionType2List();
        Mcq mcq_temp = new Mcq();

        if (data.getCount() == 0) {

            Toast.makeText(this, "No questions added.Click on add button to get started", Toast.LENGTH_SHORT).show();


        } else {
            while (data.moveToNext()) {

                mcq_temp.setStatement(data.getString(1));
                mcq_temp.setOption1(data.getString(2));
              //  Toast.makeText(this, data.getColumnName(2), Toast.LENGTH_SHORT).show();
                mcq_temp.setOption2(data.getString(3));
                mcq_temp.setOption3(data.getString(4));
                mcq_temp.setOption3(data.getString(5));

                fetchedQuestions.add(mcq_temp);

                Adapter1 mcq_adapter = new Adapter1(this , 0 , fetchedQuestions);
                lv.setAdapter(mcq_adapter);

            }

            for(Mcq m : fetchedQuestions){

                Toast.makeText(this, m.getStatement(), Toast.LENGTH_SHORT).show();

               // Toast.makeText(this, m.getStatement(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(this, m.getOption2(), Toast.LENGTH_SHORT).show();
            }


        }

    }
}