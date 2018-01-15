package com.keirnellyer.portfolio.service;

import com.keirnellyer.portfolio.entity.*;
import com.keirnellyer.portfolio.repository.ISiteRepository;
import com.keirnellyer.portfolio.repository.IUserRepository;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.text.TextProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SeedService implements ISeedService {
    private Logger LOGGER = LoggerFactory.getLogger(SeedService.class);

    private IUserRepository userRepository;
    private ISiteRepository siteRepository;

    private Fairy fairy = Fairy.create();

    public SeedService(IUserRepository userRepository, ISiteRepository siteRepository) {
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
    }

    private User createDefaultAdminUser() {
        return new User("admin", "admin");
    }

    private Site createDefaultSite(User siteOwner, Profile profile) {
        return new Site(siteOwner, profile, "Default Site");
    }

    private Profile createDefaultProfile(Iterable<Job> jobs, Iterable<Education> educations) {
        TextProducer text = fairy.textProducer();

        String bio = String.format("%s%n%n%s", text.paragraph(4), text.paragraph(4));
        Profile profile = new Profile(true, "Default Profile", "The default headline", bio);

        jobs.forEach(profile::addJob);
        educations.forEach(profile::addEducation);

        return profile;
    }

    private List<Job> createDefaultJobs() {
        List<Job> jobs = new ArrayList<>();
        TextProducer text = fairy.textProducer();

        LocalDate fromDate1 = LocalDate.of(2015, 1, 7);
        LocalDate toDate1 = null; // currently working here
        String description1 = text.paragraph(4);
        jobs.add(new Job("GitHub", "http://github.com", "Software Developer", fromDate1, toDate1, description1));

        LocalDate fromDate2 = LocalDate.of(2010, 1, 7);
        LocalDate toDate2 = LocalDate.of(2015, 4, 18);
        String description2 = text.paragraph(4);
        jobs.add(new Job("Microsoft", "http://microsoft.com", "Software Developer", fromDate2, toDate2, description2));

        return jobs;
    }

    private List<Education> createDefaultEducations() {
        List<Education> educations = new ArrayList<>();
        TextProducer text = fairy.textProducer();

        LocalDate fromDate1 = LocalDate.of(2005, 5, 13);
        LocalDate toDate1 = LocalDate.of(2009, 7, 18);
        String description1 = text.paragraph(4);
        educations.add(new Education("MIT", "http://web.mit.edu/", "Software Design & Engineering", fromDate1, toDate1, description1));

        return educations;
    }

    public User seedDefaultAdminUser() {
        User defaultAdminUser = createDefaultAdminUser();
        userRepository.save(defaultAdminUser);
        LOGGER.info("Seeded default users");
        return defaultAdminUser;
    }

    public Site seedDefaultSite(User siteOwner) {
        Profile profile = createDefaultProfile(createDefaultJobs(), createDefaultEducations());
        Site defaultSite = createDefaultSite(siteOwner, profile);
        siteRepository.save(defaultSite);
        LOGGER.info("Seeded default sites");
        return defaultSite;
    }

    @Override
    public void seed() {
        boolean seedUsers = userRepository.count() == 0;
        boolean seedSites = siteRepository.count() == 0;

        if (seedUsers) {
            LOGGER.debug("Seeding default users");
            User defaultAdminUser = seedDefaultAdminUser();

            if (seedSites) {
                LOGGER.debug("Seeding default sites");
                seedDefaultSite(defaultAdminUser);
            }
        }
    }
}
