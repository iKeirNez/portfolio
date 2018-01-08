package com.keirnellyer.portfolio;

import com.keirnellyer.portfolio.entity.User;
import com.keirnellyer.portfolio.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PortfolioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    @Autowired
    private IUserRepository userRepo;

    public PortfolioApplication(IUserRepository userRepo) {
        this.userRepo = userRepo;
        test();
    }

    public void test() {
//        User user1 = new User("ikeirnez", "asdf");
//        User user2 = new User("testuser", "abc");
//
//        userRepo.save(user1);
//        userRepo.save(user2);

        Iterable<User> users = userRepo.findAll();
        for (User user : users) {
            System.out.println("Id: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
        }

        System.out.println("THE END");
    }
}
