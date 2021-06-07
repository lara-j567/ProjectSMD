package com.example.projectsmd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "register";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERTYPE";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "USERNAME";
    public static final String COL_5 = "PASSWORD";

    //table 2 in database
    public static final String TABLE_NAME2 = "Fill in the blanks quiz";
    public static final String COL_6 = "Q_ID";
    public static final String COL_7 = "QUESTION_TYPE_2";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , USERTYPE TEXT , EMAIL TEXT , USERNAME TEXT , PASSWORD TEXT )");
        db.execSQL("CREATE TABLE " + TABLE_NAME2 + "(Q_ID INTEGER PRIMARY KEY AUTOINCREMENT , QUESTION_TYPE_2 TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2); //drop table if exists

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

    public Cursor getQuestionType1List(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME2 , null);
        return  data;



    }
}
