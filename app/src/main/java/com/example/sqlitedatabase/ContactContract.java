package com.example.sqlitedatabase;
//To define the structure of the database we need to make a CONTRACT CLASS i.e used for adding table into the database
public final class ContactContract
{
    public ContactContract() {
    }

    public static abstract class ContactEntry
    {
        public static final String TABLE_NAME = "contact_table";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String CONTACT_NUMBER = "contact_number";
        public static final String EMAIL = "email";
    }
}
