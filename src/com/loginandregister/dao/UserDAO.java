package com.loginandregister.dao;

import com.loginandregister.model.User;

public class UserDAO {
    private User[] usersDb = new User[100];
    private static int USER_ID = -1;

    public boolean registerUser(User user) {
        for (User u : usersDb) {
            if (u == null) break;
            if (u.getLogin().equals(user.getLogin())) {
                return false;
            }
        }
        user.setId(++USER_ID);
        usersDb[USER_ID] = user;
        return true;
    }

    public boolean loginUser(String login, String password) {
        User user = findUserByLogin(login);
        if (user != null) {
             if (correctPasswordFromUser(user, password)) {
                return true;
             } else {
                 return false;
             }
        } else {
            return false;
        }
    }

    private boolean correctPasswordFromUser(User user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    private User findUserByLogin(String login) {
        for (User u : usersDb) {
            if (u == null) break;
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }



    public User[] getUsersDb() {
        return usersDb;
    }
}
