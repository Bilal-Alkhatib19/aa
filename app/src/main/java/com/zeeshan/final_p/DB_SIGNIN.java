package com.zeeshan.final_p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_SIGNIN extends SQLiteOpenHelper {
    public static final String DBName = "signin_Database";

    public static final int version = 1;

    public DB_SIGNIN(Context context) {

        super(context, DBName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users(userName text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users ");
        onCreate(db);
    }

    public boolean insatrData(UserSignIn user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", user.getName());
        contentValues.put("password", user.getPassword());
        long result = database.insert("users", null, contentValues);
        return result != -1;
    }

    public boolean checkUsername(String username, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from users where userName=? and password =? ", new String[]{username, password});
        return cursor.getCount() > 0;

    }

}
