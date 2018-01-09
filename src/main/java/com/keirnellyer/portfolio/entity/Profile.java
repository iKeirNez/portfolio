package com.keirnellyer.portfolio.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "siteId", nullable = false)
    private Site site;

    @Column(nullable = false)
    private boolean live;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    private String headline;

    @Column(nullable = false)
    private String biography;

    @OneToMany(mappedBy = "profile", targetEntity = SocialLink.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SocialLink> links = new HashSet<>();

    @OneToMany(mappedBy = "profile", targetEntity = Experience.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Experience> experiences = new HashSet<>();

    public Profile() {
    }

    public Profile(Site site, boolean live, String name, String headline, String biography) {
        this.site = site;
        this.live = live;
        this.name = name;
        this.headline = headline;
        this.biography = biography;
    }

    public Profile(Site site, boolean live, String name, String headline, String biography, Set<SocialLink> links, Set<Experience> experiences) {
        this.site = site;
        this.live = live;
        this.name = name;
        this.headline = headline;
        this.biography = biography;
        this.links = links;
        this.experiences = experiences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<SocialLink> getLinks() {
        return links;
    }

    public void setLinks(Set<SocialLink> links) {
        this.links = links;
    }

    public void addLink(SocialLink link) {
        link.setProfile(this);
        links.add(link);
    }

    public void removeLink(SocialLink link) {
        link.setProfile(null);
        links.remove(link);
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public void addExperience(Experience experience) {
        experience.setProfile(this);
        experiences.add(experience);
    }

    public void removeExperience(Experience experience) {
        experience.setProfile(null);
        experiences.remove(experience);
    }
}
