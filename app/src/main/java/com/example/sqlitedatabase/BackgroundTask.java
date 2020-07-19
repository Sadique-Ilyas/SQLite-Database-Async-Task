package com.example.sqlitedatabase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<String,Contacts,String> {
    Context context;
    Activity activity;
    TextView contact_info;
    Handler handler = new Handler();
    public BackgroundTask(Context context) {
        this.context = context;
        activity = (Activity) context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        DbOperations dbOperations = new DbOperations(context, null, null, 1);

        if (method.equals("add_contacts")) {
            String Id = params[1];
            String Name = params[2];
            String ContactNumber = params[3];
            String Email = params[4];

            SQLiteDatabase database = dbOperations.getWritableDatabase();
            dbOperations.addContact(Integer.parseInt(Id), Name, ContactNumber, Email, database);
            return "Contact Added Successfully...";
        }
        else if (method.equals("read_contacts"))
        {
            SQLiteDatabase database = dbOperations.getReadableDatabase();
            Cursor cursor = dbOperations.readContact(database);
            contact_info = activity.findViewById(R.id.txt_display);
            String info = " ", id, name, contactNumber, email;
            while (cursor.moveToNext())
            {
                id = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.ID));
                name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
                contactNumber = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_NUMBER));
                email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
                info = info+"\n\nId : "+id+"\nName : "+name+"\nPhone Number : "+contactNumber+"\nEmail : "+email;
            }
            final String finalInfo = info;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    contact_info.setText(finalInfo);
                }
            });
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Contacts... values) {

    }

    @Override
    protected void onPostExecute(String result)
    {
    }
}