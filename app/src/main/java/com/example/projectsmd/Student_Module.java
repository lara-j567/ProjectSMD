package com.example.projectsmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student_Module extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_module);

        btnLogout = findViewById(R.id.LogoutBtnS);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(Student_Module.this, MainActivity.class);
                startActivity(login);
            }
        });
    }
}