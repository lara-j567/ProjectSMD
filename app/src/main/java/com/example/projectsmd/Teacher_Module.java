package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//after login as teacher , teacher comes here
public class Teacher_Module extends AppCompatActivity {

    private Button btn1; //log out button
    private Button btn2; //button 1 mcqs
    private Button btn3; //button fill in the blanks

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_module);
        setTitle("Make Quizzes");
        btn1 = findViewById(R.id.LogoutBtnT);
        btn2 = findViewById(R.id.QuizBtn1);
        btn3 = findViewById(R.id.QuizBtn2);

        //logout redirecting to main screen
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(Teacher_Module.this, MainActivity.class);
                startActivity(login);
            }
        });

        //mcqs button will redirect to mcsq page
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mcqs_intent = new Intent(Teacher_Module.this, Quiz_Name_Form1.class);
                startActivity(mcqs_intent);
            }
        });

        //mcqs button will redirect to fill in the blanks page
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent page1 = new Intent(Teacher_Module.this , Quiz_Name_Form1.class);
                startActivity(page1);

            }
        });

    }
}