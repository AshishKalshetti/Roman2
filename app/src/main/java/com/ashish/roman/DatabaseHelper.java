package com.ashish.roman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context, @Nullable String dbname, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table users(name varchar(20),mobile varchar(10))");
    }

    //drop the table
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exists users");
    onCreate(db);
    }


    //user function
    public long saveNewUserData(String name,String mobile){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("mobile",mobile);
        long recordid = db.insert("users",null,cv);
        return recordid;
    }

    // View all the record
    public String getALlRecords(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor Cursor = db.rawQuery("select * from  users", null);
        String output= "";
        while(Cursor.moveToNext()){
            String name = Cursor.getString(0);
            String mobile = Cursor.getString(1);
            output = output + name + "-" +mobile+"\n";
        }
        return output;
    }
}
