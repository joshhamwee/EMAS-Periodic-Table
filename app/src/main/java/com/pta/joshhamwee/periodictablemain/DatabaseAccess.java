package com.pta.joshhamwee.periodictablemain;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;


    //Private constructor to avoid object creation from outside classes.
    //@param context
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }


     //Return a singleton instance of DatabaseAccess.
     //@param context the Context
     //@return the instance of DatabaseAccess
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    //Open the database connection.
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    //Close the database connection
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

     //Read all quotes from the database
     //@return a List of quotes
    public List<String> getElementData(String atomicNum, String sqlQuery) {
        List<String> data = new ArrayList<>();
        int length;
        try {
            //retrieve data from database via SQL query
            Cursor cursor = database.rawQuery(sqlQuery, null);
            cursor.moveToFirst();
            length = cursor.getColumnCount();
            for(int i = 0; i < length; i++) {
                data.add(cursor.getString(i));
            }
            cursor.close();
        }
        //catch any errors. Should not occur, but could happen if database is incomplete
        catch (Exception e){
            data.add(0, "null");
            data.add(1, "Element not found");
        }
        return data;
    }
}