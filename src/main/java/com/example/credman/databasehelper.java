package com.example.credman;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="user.db";
    public static final String TABLE_NAME="user_table";
    public static final String TABLE_NAME1="record_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="EMAIL";
    public static final String COL_4="CREDITS";
    public static final String COL_5="ID";
    public static final String COL_6="SENDER";
    public static final String COL_7="RECEIVER";
    public static final String COL_8="CREDITS";





    public databasehelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, CREDITS INTEGER) ");
        db.execSQL("create table " + TABLE_NAME1 +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, SENDER TEXT, RECEIVER TEXT, CREDITS INTEGER) ");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME + TABLE_NAME1);
        onCreate(db);

    }
    public boolean insertData(String name,String email,String credits){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,credits);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;

        }
        else
        {
            return true;
        }



    }
    public boolean insertData1(String sender,String receiver,String credit){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_6,sender);
        contentValues.put(COL_7,receiver);
        contentValues.put(COL_8,credit);
        long result=db.insert(TABLE_NAME1,null,contentValues);
        if(result==-1)
        {
            return false;

        }
        else
        {
            return true;
        }



    }


    public Cursor viewdata() {
        SQLiteDatabase db=this.getWritableDatabase();
        String quary="select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(quary,null);
        return cursor;
    }
    public Integer deletedata(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"NAME=?",new String[] {name});

    }
    public Cursor display(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor bes = db.rawQuery("SELECT * FROM user_table WHERE NAME = ? ", new String[]{name});
        return bes;
    }
    public Cursor get(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor ses = db.rawQuery("SELECT * FROM user_table WHERE NAME = ? ", new String[]{name});
        return ses;
    }
    public Cursor get1(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor kes = db.rawQuery("SELECT * FROM user_table WHERE NAME = ? ", new String[]{name});
        return kes;
    }
    public boolean updatedata(String name,String credit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, credit);
        db.update(TABLE_NAME, contentValues, "NAME=?", new String[]{name});
        return true;
    }
    public Cursor showdata1() {
        SQLiteDatabase db = this.getWritableDatabase();
        String quary1 = "select * from " + TABLE_NAME1;
        Cursor qes = db.rawQuery(quary1, null);
        return qes;
    }



}
