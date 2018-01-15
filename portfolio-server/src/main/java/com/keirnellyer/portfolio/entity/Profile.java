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

    @Column
    @NotBlank
    private String location;

    @Column(nullable = false)
    @Lob
    private String biography;

    @OneToMany(targetEntity = Job.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private Set<Job> jobs = new HashSet<>();

    @OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private Set<Education> educations = new HashSet<>();

    public Profile() {
    }

    public Profile(boolean live, String name, String headline, String location, String biography) {
        this.live = live;
        this.name = name;
        this.headline = headline;
        this.location = location;
        this.biography = biography;
    }

    public Profile(boolean live, String name, String headline, String location, String biography, Set<Job> jobs, Set<Education> educations) {
        this.live = live;
        this.name = name;
        this.headline = headline;
        this.location = location;
        this.biography = biography;
        this.jobs = jobs;
        this.educations = educations;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public void addEducation(Education education) {
        educations.add(education);
    }

    public void removeEducation(Education education) {
        educations.remove(education);
    }
}
