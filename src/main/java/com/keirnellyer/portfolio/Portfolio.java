package com.keirnellyer.portfolio;

import com.keirnellyer.portfolio.database.User;
import com.keirnellyer.portfolio.repository.IMainRepository;
import com.keirnellyer.portfolio.repository.MainRepository;

import java.util.List;

public class Portfolio {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();
        portfolio.test();

        new WebApplication();
    }

    private IMainRepository repo;

    public Portfolio() {
        repo = new MainRepository(); // TODO inject this
    }

    public void test() {
//        User user1 = new User("ikeirnez", "asdf");
//        User user2 = new User("testuser", "abc");
//
//        repo.addUser(user1);
//        repo.addUser(user2);

        List<User> users = repo.getUsers();
        for (User user : users) {
            System.out.println("Id: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
        }

        System.out.println("THE END");
    }
}
