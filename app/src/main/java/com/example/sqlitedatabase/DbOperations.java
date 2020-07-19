package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

//To perform DATABASE OPERATIONS
public class DbOperations extends SQLiteOpenHelper
{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "contact_info.db";
    private static final String CREATE_QUERY = "create table "+ContactContract.ContactEntry.TABLE_NAME+
            "("+ContactContract.ContactEntry.ID+" number,"+ ContactContract.ContactEntry.NAME+" text,"+
            ContactContract.ContactEntry.CONTACT_NUMBER+" integer,"+ ContactContract.ContactEntry.EMAIL+" text);";

    public DbOperations(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Database Operations","Database Created...");
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_QUERY);
        Log.d("Database Operations","Table created...");
    }

    public void addContact(int id, String name, String contact_number, String email, SQLiteDatabase database)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.ID, id);
        contentValues.put(ContactContract.ContactEntry.NAME, name);
        contentValues.put(ContactContract.ContactEntry.CONTACT_NUMBER, contact_number);
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);

        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations","One Row Inserted...");
    }

    public Cursor readContact(SQLiteDatabase database)
    {
        String []projections = {ContactContract.ContactEntry.ID,ContactContract.ContactEntry.NAME,
                ContactContract.ContactEntry.CONTACT_NUMBER,ContactContract.ContactEntry.EMAIL};

        Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
