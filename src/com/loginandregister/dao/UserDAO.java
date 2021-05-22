package com.loginandregister.dao;

import com.loginandregister.model.User;

public class UserDAO {
    private User[] usersDb = new User[100];
    private static int USER_ID = -1;

    public void registerUser(User user) {
        user.setId(++USER_ID);
        usersDb[USER_ID] = user;
        System.out.println("Saving new User: "
                + user);
    }

    public User[] getUsersDb() {
        return usersDb;
    }

}
