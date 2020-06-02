package com.udemy.testdata;

import com.udemy.models.User;

import java.sql.Timestamp;

public interface UserData {
    int timestamp = new Timestamp(System.currentTimeMillis()).getNanos();

    User basicUser = new User("Georgiy","BLABLA" + timestamp + "@yopmail.com","Qwerty123!");
}
