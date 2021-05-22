package com.loginandregister;

import com.loginandregister.dao.UserDAO;
import com.loginandregister.model.User;

import java.util.Scanner;

public class LoginAndRegister {


    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;
        while (true) {
            System.out.println("Register new user" +
                    "\nPlease write your login and password");
            System.out.print("Login: ");
            login = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            userDAO.registerUser(user);
            System.out.println("User register successfully");
            System.out.println("User db: ");
            for (User u : userDAO.getUsersDb()) {
                if (u == null) {
                    break;
                }
                System.out.println(u);
            }
        }
    }

}