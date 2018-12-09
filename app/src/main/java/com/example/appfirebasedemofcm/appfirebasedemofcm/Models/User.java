package com.example.appfirebasedemofcm.appfirebasedemofcm.Models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String Email;
    public String UserName;
    public String Password;
    public Message message;

    public User() {
    }
    public User(String email,String password, String userName ) {
        this.Email = email;
        this.Password = password;
        this.UserName = userName;
    }
    public User(String UserName)
    {
        this.UserName = UserName;
    }
}
