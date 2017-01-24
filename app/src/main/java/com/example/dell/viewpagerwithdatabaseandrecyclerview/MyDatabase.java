package com.example.dell.viewpagerwithdatabaseandrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 02-01-2017.
 */
public class MyDatabase {
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;
    public MyDatabase(Context c){
        myHelper = new MyHelper(c,"techpalle.db",null,1);
    }
    public void open()
    {
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    // DML operation
    public void insertStudent(String name, String sub, String email)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("sub",sub);
        contentValues.put("email",email);
        sqLiteDatabase.insert("student",null,contentValues);
    }
    public Cursor queryStudent()
    {
        Cursor c = null;
        c = sqLiteDatabase.query("student",null,null,null,null,null,null);
        return c;
    }
    public void close()
    {
        sqLiteDatabase.close();
    }

    private class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table student(_id integer primary key,name text, sub text,email text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        }
    }
}
