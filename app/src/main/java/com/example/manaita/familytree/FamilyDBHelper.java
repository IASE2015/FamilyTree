package com.example.manaita.familytree;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
/**
 * Created by tazio on 2015/07/17.
 */

public class FamilyDBHelper extends SQLiteOpenHelper {

    static final String name = "family.db";
    static final int version = 1;
    static final SQLiteDatabase.CursorFactory factory = null;

    public FamilyDBHelper(Context context){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE familyDB ("
                + android.provider.BaseColumns._ID
                + "INTEGER PRIMARY KEY AUTOINCREMENT, family FName, name NAME);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
