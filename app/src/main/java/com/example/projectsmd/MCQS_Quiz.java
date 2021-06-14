package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MCQS_Quiz extends AppCompatActivity {

    private Button btn_add;
    private Button btn_publish;
    private ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqs_quiz);

        btn_add = findViewById(R.id.add_btn);
        btn_publish = findViewById(R.id.btnPublish);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add_question = new Intent(MCQS_Quiz.this, Add_Quiz_1.class);
                startActivity(add_question);


            }
        });

    }
}