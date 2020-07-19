package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addContact(View view)
    {
        startActivity(new Intent(this,AddContactActivity.class));
    }

    public void readContact(View view)
    {
        startActivity(new Intent(this,ReadContactActivity.class));
    }
}
