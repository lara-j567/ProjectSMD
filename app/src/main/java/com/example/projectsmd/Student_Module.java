package com.example.projectsmd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Student_Module extends AppCompatActivity {

    private Button btnLogout;
    private Spinner quizSpinner;
    private Button solve_quiz;
    protected ArrayList<String> quiz = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_module);

        btnLogout = findViewById(R.id.LogoutBtnS);
        quizSpinner = findViewById(R.id.quizType);
        solve_quiz = findViewById(R.id.slv_quiz);

        populateQuizType();

        btnLogout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                Intent login = new Intent(Student_Module.this, MainActivity.class);
                startActivity(login);
            }
        });

        solve_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String choice = quizSpinner.getSelectedItem().toString();

                if (!isConnected(Student_Module.this)) {

                    showCustomDialog();
                }

                else {

                    if (choice.toLowerCase().equals("fill in the blanks quiz")) {

                        Intent fill_intent = new Intent(Student_Module.this, Show_quiz_type2.class);
                        startActivity(fill_intent);
                    }

                    if (choice.toLowerCase().equals("mcq's quiz")) {

                        Intent mcq_intent = new Intent(Student_Module.this, Show_quiz_type1.class);
                        startActivity(mcq_intent);
                    }

                }


            }
        });
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Student_Module.this);
        builder.setMessage("Please connect internet to solve quiz.")
                .setCancelable(false)
        .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(getApplicationContext() , Student_Module.class));
                        finish();

                    }
                }).show();





    }

    private boolean isConnected(Student_Module student_module) {

        ConnectivityManager connectivityManager = (ConnectivityManager) student_module.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {

            return true;
        } else {

            return false;

        }


    }

    private void populateQuizType() {

        quizSpinner = findViewById(R.id.quizType);
        quiz.add("Fill in the blanks Quiz");
        quiz.add("MCQ'S Quiz");

        ArrayAdapter<String> quizAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, quiz);

        quizSpinner.setAdapter(quizAdapter);


    }
}