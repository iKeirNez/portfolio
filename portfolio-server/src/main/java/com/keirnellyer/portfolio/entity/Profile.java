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

    @Column(nullable = false)
    private boolean live;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    private String headline;

    @Column(nullable = false)
    @Lob
    private String biography;

    @OneToMany(targetEntity = Experience.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private Set<Experience> experiences = new HashSet<>();

    public Profile() {
    }

    public Profile(boolean live, String name, String headline, String biography) {
        this.live = live;
        this.name = name;
        this.headline = headline;
        this.biography = biography;
    }

    public Profile(boolean live, String name, String headline, String biography, Set<Experience> experiences) {
        this.live = live;
        this.name = name;
        this.headline = headline;
        this.biography = biography;
        this.experiences = experiences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public void addExperience(Experience experience) {
        experiences.add(experience);
    }

    public void removeExperience(Experience experience) {
        experiences.remove(experience);
    }
}
