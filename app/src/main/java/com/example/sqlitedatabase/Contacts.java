package com.example.sqlitedatabase;

public class Contacts
{
    private String Id, Name, ContactNumber, Email;

    public Contacts(String id, String name, String contactNumber, String email) {
        this.setId(id);
        this.setName(name);
        this.setContactNumber(contactNumber);
        this.setEmail(email);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
