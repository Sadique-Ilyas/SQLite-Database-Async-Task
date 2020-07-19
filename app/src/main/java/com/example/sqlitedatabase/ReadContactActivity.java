package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ReadContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contact);

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("read_contacts");
    }
}
