package com.keirnellyer.portfolio;

import com.keirnellyer.portfolio.entity.Experience;
import com.keirnellyer.portfolio.entity.Profile;
import com.keirnellyer.portfolio.entity.SocialLink;
import com.keirnellyer.portfolio.entity.User;
import com.keirnellyer.portfolio.repository.IProfileRepository;
import com.keirnellyer.portfolio.repository.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    private IUserRepository userRepo;
    private IProfileRepository profileRepo;

    public PortfolioApplication(IUserRepository userRepo, IProfileRepository profileRepo) {
        this.userRepo = userRepo;
        this.profileRepo = profileRepo;
        test();
    }

    public void test() {
//        User newUser = new User("newUser", "asdf");
//        Profile profile = new Profile(newUser, true, "Keir Nellyer", "Software Engineer", "asdf");
//        profile.addLink(new SocialLink("GitHub", "fa-github", "http://github.com"));
//        profile.addExperience(new Experience("Airts", "Software Developer", Instant.now(), null, "ggg"));
//
//        userRepo.save(newUser);
//        profileRepo.save(profile);

        Iterable<User> users = userRepo.findAll();
        for (User user : users) {
            System.out.println("Id: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
        }

        System.out.println();
        System.out.println("PROFILES");
        System.out.println();

        for (Profile p : profileRepo.findAll()) {
            System.out.println("Id: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Headline: " + p.getHeadline());
            System.out.println("Biography: " + p.getBiography());

            for (SocialLink link : p.getLinks()) {
                System.out.println("[Profile Link] Id: " + link.getId());
                System.out.println("PId: " + link.getProfile().getId());
                System.out.println("[Profile Link] Name: " + link.getName());
                System.out.println("[Profile Link] Icon: " + link.getIcon());
                System.out.println("[Profile Link] URL: " + link.getUrl());
            }

            for (Experience experience : p.getExperiences()) {
                System.out.println("[Experience] Id: " + experience.getId());
                System.out.println("[Experience] Organisation: " + experience.getOrganisation());
                System.out.println("[Experience] Position: " + experience.getPosition());
                System.out.println("[Experience] From: " + experience.getFrom());
                System.out.println("[Experience] To: " + experience.getTo());
                System.out.println("[Experience] Description: " + experience.getDescription());
            }
        }

        System.out.println("THE END");
    }
}
