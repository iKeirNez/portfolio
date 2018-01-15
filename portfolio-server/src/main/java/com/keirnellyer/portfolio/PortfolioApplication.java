package com.keirnellyer.portfolio;

import com.keirnellyer.portfolio.entity.*;
import com.keirnellyer.portfolio.repository.IProfileRepository;
import com.keirnellyer.portfolio.repository.ISiteRepository;
import com.keirnellyer.portfolio.repository.IUserRepository;
import com.keirnellyer.portfolio.service.ISeedService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PortfolioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    private IUserRepository userRepository;
    private ISiteRepository siteRepository;
    private IProfileRepository profileRepository;
    private ISeedService seedService;

    public PortfolioApplication(IUserRepository userRepository, ISiteRepository siteRepository, IProfileRepository profileRepository, ISeedService seedService) {
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
        this.profileRepository = profileRepository;
        this.seedService = seedService;
        listEntities();
    }

    @EventListener
    public void seed(ContextRefreshedEvent e) {
        seedService.seed();
        listEntities();
    }

    public void listEntities() {
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println("Id: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
        }

        System.out.println();
        System.out.println("PROFILES");
        System.out.println();

        for (Site s : siteRepository.findAll()) {
            System.out.println("[Site] Id: " + s.getId());
            System.out.println("[Site] Owner: " + s.getOwner().getUsername());
            System.out.println("[Site] Title: " + s.getTitle());

            for (Profile p : profileRepository.findAll()) {
                System.out.println("[Profile] Id: " + p.getId());
                System.out.println("[Profile] Name: " + p.getName());
                System.out.println("[Profile] Headline: " + p.getHeadline());
                System.out.println("[Profile] Biography: " + p.getBiography());

                for (Job job : p.getJobs()) {
                    System.out.println("[Job] Id: " + job.getId());
                    System.out.println("[Job] Organisation: " + job.getOrganisation());
                    System.out.println("[Job] Website: " + job.getWebsite());
                    System.out.println("[Job] Position: " + job.getPosition());
                    System.out.println("[Job] From: " + job.getFrom());
                    System.out.println("[Job] To: " + job.getTo());
                    System.out.println("[Job] Description: " + job.getDescription());
                }

                for (Education education : p.getEducations()) {
                    System.out.println("[Education] Id: " + education.getId());
                    System.out.println("[Education] Establishment: " + education.getEstablishment());
                    System.out.println("[Education] Website: " + education.getWebsite());
                    System.out.println("[Education] Subject: " + education.getSubject());
                    System.out.println("[Education] From: " + education.getFrom());
                    System.out.println("[Education] To: " + education.getTo());
                    System.out.println("[Education] Description: " + education.getDescription());
                }
            }

            for (SocialLink link : s.getLinks()) {
                System.out.println("[Site Link] Id: " + link.getId());
                System.out.println("[Site Link] Name: " + link.getName());
                System.out.println("[Site Link] Icon: " + link.getIcon());
                System.out.println("[Site Link] URL: " + link.getUrl());
            }

            System.out.println("END OF SITE");
        }
    }
}
