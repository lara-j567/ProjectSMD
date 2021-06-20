package com.example.projectsmd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//database helper class
//this class contains all the tables and colums names in database
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "register";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERTYPE";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "USERNAME";
    public static final String COL_5 = "PASSWORD";

    //table 2 in database for quiz type 2
    public static final String TABLE_NAME2 = "quizOne";
    public static final String COL_6 = "qID";
    public static final String COL_7 = "QUESTION_TYPE_2";
    public static final String COL_8 = "quizTitle";


    //table 3 in database for type 1
    public static final String TABLE_NAME3 = "quizTwo";
    public static final String COL_9 = "mID";
    public static final String COL_10 = "QUESTION_TYPE_1";
    public static final String COL_11 = "op1";
    public static final String COL_12 = "op2";
    public static final String COL_13 = "op3";
    public static final String COL_14 = "op4";
    public static final String COL_15 = "quizTitle";


    //table 4 in database for quiz names list
    public static final String TABLE_NAME4 = "quizList";
    public static final String COL_16 = "quizID";
    public static final String COL_17 = "TITLE";

    //quiz types
    public static final String COL_18 = "QUIZ_TYPE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //user table for login and sign up
        String sql1 = "CREATE TABLE " +
                TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "USERTYPE TEXT ," +
                "EMAIL TEXT , " +
                "USERNAME TEXT , " +
                "PASSWORD TEXT )";

        db.execSQL(sql1);


        //quiz list table
        String sql4 = "CREATE TABLE " +
                TABLE_NAME4 +
                "(quizID TEXT PRIMARY KEY," +
                "TITLE TEXT )";


        db.execSQL(sql4);



        //quiz type 1
        String sql2 = "CREATE TABLE " +
                TABLE_NAME2 +
                "(qID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "QUESTION_TYPE_2 TEXT,"+
                "QUIZ_TYPE TEXT)";

        db.execSQL(sql2);

        //quiz type 2
        String sql3 = "CREATE TABLE " +
                TABLE_NAME3 +
                "(mID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "QUESTION_TYPE_1 TEXT  ," +
                "OP1 TEXT," +
                "OP2 TEXT," +
                "OP3 TEXT ," +
                "OP4 TEXT )";


        db.execSQL(sql3);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2); //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3); //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4); //drop table if exists

        onCreate(db);

    }

    public boolean addData(String userType, String email, String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, userType);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, username);
        contentValues.put(COL_5, password);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {

            return false;

        } else {

            return true;
        }
    }

    public Cursor getQuestionType1List() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null);
        return data;


    }

    public Cursor getQuestionType2List() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME3, null);
        return data;


    }

    public Cursor getQuizList() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME4, null);
        return data;


    }


}
