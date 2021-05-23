package com.loginandregister;

import com.loginandregister.dao.UserDAO;
import com.loginandregister.model.User;

import java.util.Scanner;

public class LoginAndRegister {
    public static final String POSSIBLE_ANSWER_1 = "register";
    public static final String POSSIBLE_ANSWER_2 = "login";
    public static final String POSSIBLE_ANSWER_3 = "show db";

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;
        String command;
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome! If do you want to login,\n" +
                    "please write 'login' and \nif you want to register," +
                    " write 'register'. Show user database: 'show db'");
            System.out.print("Write command: ");
            command = scanner.nextLine();
            switch (command) {
                case POSSIBLE_ANSWER_1:
                    User user = new User();
                    System.out.println("Ok, I understand you, want to register.\n"
                    + "We need you login and password");
                    System.out.print("Login: ");
                    login = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    user.setLogin(login);
                    user.setPassword(password);
                    if (userDAO.registerUser(user)) {
                        System.out.println("Cool! User with login " + login +
                                " was register");
                    } else {
                        System.out.println("Error! User with login " + login +
                                " is exist");
                    }
                    break;
                case POSSIBLE_ANSWER_2:
                    System.out.println("Ok, I understand you, you want to login.\n"
                    + "We need you login and password");
                    System.out.print("Login: ");
                    login = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    if (userDAO.loginUser(login, password)) {
                        System.out.println("Cool! User with login " + login +
                                " was login in his personal area");
                    } else {
                        System.out.println("Error! Login or password is incorrect");
                    }
                    break;
                case POSSIBLE_ANSWER_3:
                    System.out.println("User database:");
                    for (int i = 0; i < userDAO.getUsersDb().length; i++) {
                        if (userDAO.getUsersDb()[i] == null) break;
                        System.out.println(userDAO.getUsersDb()[i]);
                    }
                    break;
                default:
                    System.out.println("I not understand you. Can do this again");
            }
        }
    }

}