package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {
    EditText Id, Name, ContactNumber, Email;
    String id, name, contactNumber, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        Id = findViewById(R.id.txt_contact_id);
        Name = findViewById(R.id.txt_contact_name);
        ContactNumber = findViewById(R.id.txt_contact_number);
        Email = findViewById(R.id.txt_contact_email);
    }

    public void saveContacts(View view)
    {
        id = Id.getText().toString();
        name = Name.getText().toString();
        contactNumber = ContactNumber.getText().toString();
        email = Email.getText().toString();

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_contacts",id,name,contactNumber,email);
        finish();
    }
}
