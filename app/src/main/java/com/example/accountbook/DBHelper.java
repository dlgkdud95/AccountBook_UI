package com.example.accountbook;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "accountbook.db";

    public DBHelper(@Nullable Context context)
    {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //DB 생성시 호출
        db.execSQL("CREATE TABLE IF NOT EXISTS AccountBook (id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT NOT NULL, cost INTEGER NOT NULL, category TEXT NOT NULL, date TEXT NOT NULL)");
        // type = 입력타입(수입, 지출)
        // cost = 금액
        // category = 카테고리
        // date = 날짜

    }

    public int getSum(String _type)
    {
        // _type변수에 table에 있는 type(수입 or 지출)을 넣어주면 type에 맞는 합계를 구해줌
        int number = 0;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("SELECT IFNULL(AccountBook.cost, 0) FROM AccountBook WHERE type = '"+_type+"'",null);

        while(cursor.moveToNext())
        {
            number += cursor.getInt(0);
        }
        cursor.close();
        return number;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onCreate(db);
    }


    // DB에 데이터 넣기
    public void InsertDB(String _type, int _cost, String _category, String _date)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO AccountBook(type, cost, category, date) VALUES('"+ _type +"', "+ _cost +", '"+ _category +"', '"+ _date +"');");
    }

    // 업데이트는 써야해야할지 아직 못정함
    public void UpdateDB()
    {
        SQLiteDatabase db = getWritableDatabase();
    }


    // DB전체 삭제
    public void DeleteDB()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM AccountBook");
    }
}