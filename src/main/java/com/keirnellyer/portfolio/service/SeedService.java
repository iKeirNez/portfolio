package com.keirnellyer.portfolio.service;

import com.keirnellyer.portfolio.entity.Experience;
import com.keirnellyer.portfolio.entity.Profile;
import com.keirnellyer.portfolio.entity.Site;
import com.keirnellyer.portfolio.entity.User;
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

    private Profile createDefaultProfile(Iterable<Experience> experiences) {
        TextProducer text = fairy.textProducer();

        String bio = String.format("%s%n%n%s", text.paragraph(4), text.paragraph(4));
        Profile profile = new Profile(true, "Default Profile", "The default headline", bio);

        for (Experience experience : experiences) {
            profile.addExperience(experience);
        }

        return profile;
    }

    private List<Experience> createDefaultExperiences() {
        List<Experience> experiences = new ArrayList<>();
        TextProducer text = fairy.textProducer();

        LocalDate fromDate1 = LocalDate.of(2015, 1, 7);
        LocalDate toDate1 = LocalDate.of(2017, 5, 23);
        String description1 = text.paragraph(4);
        experiences.add(new Experience("GitHub", "Software Developer", fromDate1, toDate1, description1));

        LocalDate fromDate2 = LocalDate.of(2010, 1, 7);
        LocalDate toDate2 = LocalDate.of(2015, 4, 18);
        String description2 = text.paragraph(4);
        experiences.add(new Experience("Microsoft", "Software Developer", fromDate2, toDate2, description2));

        return experiences;
    }

    public User seedDefaultAdminUser() {
        User defaultAdminUser = createDefaultAdminUser();
        userRepository.save(defaultAdminUser);
        LOGGER.info("Seeded default users");
        return defaultAdminUser;
    }

    public Site seedDefaultSite(User siteOwner) {
        Profile profile = createDefaultProfile(createDefaultExperiences());
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
