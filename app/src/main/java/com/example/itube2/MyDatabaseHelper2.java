package com.example.itube2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class MyDatabaseHelper2 extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "videoURL.db";
    private static final int DATABASE_VERSION = 1;
    String TABLE_NAME = "URL";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_URL = "url";

    public MyDatabaseHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_URL + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void addURL(String url){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(COLUMN_URL, url);

        long result = database.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show();
        }

    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);

        }
        return cursor;
    }
    public void changetable(String tablename){
        TABLE_NAME = tablename;
    }
}
