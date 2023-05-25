package com.example.itube2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, "userpass.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table userpass(fullname TEXT, username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists userpass");
    }

    public Boolean insertData(String fullname, String username, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("username",username);
        contentValues.put("password",password);

        long result = MyDatabase.insert("userpass",null,contentValues);

        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Boolean checkUsername(String username){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from userpass where username = ?", new String[]{username});
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from userpass where username = ? and password = ?", new String[]{username,password});

        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
