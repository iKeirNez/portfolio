package com.keirnellyer.portfolio;

import com.keirnellyer.portfolio.entity.User;
import com.keirnellyer.portfolio.repository.IMainRepository;
import com.keirnellyer.portfolio.repository.MainRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PortfolioApplication {
    public static void main(String[] args) {
//        PortfolioApplication portfolioApplication = new PortfolioApplication();
//        portfolioApplication.test();

        SpringApplication.run(PortfolioApplication.class, args);

        //new WebApplication();
    }

    private IMainRepository repo;

    public PortfolioApplication() {
        //repo = new MainRepository(); // TODO inject this
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
