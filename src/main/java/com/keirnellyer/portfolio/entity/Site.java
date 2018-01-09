package com.keirnellyer.portfolio.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @OneToMany(targetEntity = SocialLink.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "site_id")
    private Set<SocialLink> links = new HashSet<>();

    public Site() {
    }

    public Site(User owner, Profile profile, String title) {
        this.owner = owner;
        this.profile = profile;
        this.title = title;
    }

    public Site(User owner, Profile profile, String title, Set<SocialLink> links) {
        this.owner = owner;
        this.profile = profile;
        this.title = title;
        this.links = links;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<SocialLink> getLinks() {
        return links;
    }

    public void setLinks(Set<SocialLink> links) {
        this.links = links;
    }

    public void addLink(SocialLink link) {
        links.add(link);
    }

    public void removeLink(SocialLink link) {
        links.remove(link);
    }
}
